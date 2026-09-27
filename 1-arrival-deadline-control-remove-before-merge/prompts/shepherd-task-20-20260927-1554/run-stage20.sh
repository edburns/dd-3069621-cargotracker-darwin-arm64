#!/usr/bin/env bash
set -euo pipefail

REPO='edburns/dd-3069621-cargotracker-darwin-arm64'
PARENT_ISSUE=1
LOG_DIRECTORY='/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554'
BODY_DIRECTORY="$LOG_DIRECTORY/issue-bodies"
LEDGER="$LOG_DIRECTORY/creation-ledger.json"
RESULT="$LOG_DIRECTORY/stage-20-result.json"
DRAFT_VALIDATOR='/Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh'
ISSUE_BODY_VERIFIER='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh'
CHILD_LINK_VERIFIER='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh'
SELECTED_ISSUE_TYPE=''
CURRENT_OPERATION='initialization'

titles=(
  '4.1 — Add the application-layer deadline change operation'
  '4.2 — Expose deadline changes through the booking facade'
  '4.3 — Implement the deadline editor backing model'
  '4.4 — Implement the PrimeFaces deadline dialog'
  '4.5 — Integrate deadline editing into the Administration dashboard'
)
subsections=(
  '4.1 — Issue 1: Add the application-layer deadline change operation'
  '4.2 — Issue 2: Expose deadline changes through the booking facade'
  '4.3 — Issue 3: Implement the deadline editor backing model'
  '4.4 — Issue 4: Implement the PrimeFaces deadline dialog'
  '4.5 — Issue 5: Integrate deadline editing into the Administration dashboard'
)
body_files=(
  "$BODY_DIRECTORY/01-4.1-body.md"
  "$BODY_DIRECTORY/02-4.2-body.md"
  "$BODY_DIRECTORY/03-4.3-body.md"
  "$BODY_DIRECTORY/04-4.4-body.md"
  "$BODY_DIRECTORY/05-4.5-body.md"
)

atomic_write() {
  local path="$1" content="$2" temporary
  temporary="${path}.tmp.$$"
  printf '%s\n' "$content" > "$temporary"
  mv "$temporary" "$path"
}

update_ledger_flag() {
  local number="$1" field="$2" value="$3" updated
  updated="$(
    jq \
      --argjson number "$number" \
      --arg field "$field" \
      --argjson value "$value" \
      'map(if .number == $number then .[$field] = $value else . end)' \
      "$LEDGER"
  )" || return 1
  atomic_write "$LEDGER" "$updated"
}

write_result() {
  local status="$1" error="$2" content
  content="$(
    jq -n \
      --arg status "$status" \
      --arg error "$error" \
      '{
        schemaVersion: 1,
        status: $status,
        ledgerFile: "creation-ledger.json",
        operationError: (if $error == "" then null else $error end)
      }'
  )"
  atomic_write "$RESULT" "$content"
}

reconcile_failure() {
  local exit_code="$1" error="Operation '$CURRENT_OPERATION' failed with exit code $exit_code."
  trap - ERR
  set +e
  if [[ -f "$LEDGER" ]]; then
    server_output="$(gh api "repos/$REPO/issues/$PARENT_ISSUE/sub_issues" --paginate --slurp 2>&1)"
    server_status=$?
    if [[ $server_status -eq 0 ]]; then
      normalized="$(jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end' <<<"$server_output")"
      reconciled="$(
        jq \
          --argjson children "$normalized" \
          'map(.linked = ([ $children[] | select(.id == .id) ] | length > 0))' \
          "$LEDGER"
      )"
      # Reconcile by child ID without flattening the already-normalized array again.
      reconciled="$(
        jq \
          --argjson children "$normalized" \
          'map(. as $entry | .linked = ([$children[] | select(.id == $entry.id)] | length == 1))' \
          "$LEDGER"
      )"
      atomic_write "$LEDGER" "$reconciled"
    else
      error="$error Reconciliation query failed: $server_output"
    fi
  fi
  write_result failed "$error"
  printf '%s\n' "$error" >&2
  if [[ -s "$LEDGER" ]] && [[ "$(jq length "$LEDGER" 2>/dev/null)" -gt 0 ]]; then
    jq -r '.[] | "issue #\(.number) | \(.title) | \(.url) | \(.bodyFile) | body_verified=\(.body_verified) | linked=\(.linked)"' "$LEDGER" >&2
    jq -r --arg repo "$REPO" '.[] | "gh issue delete \(.number) --repo \"\($repo)\" --yes"' "$LEDGER" >&2
    printf '%s\n' 'The operation did not complete. No automatic rollback was performed. Delete every issue in the ledger before invoking this skill again.' >&2
  else
    printf '%s\n' 'No issues were created; no cleanup is required.' >&2
  fi
  exit "$exit_code"
}

trap 'reconcile_failure $?' ERR

CURRENT_OPERATION='draft validation'
"$DRAFT_VALIDATOR" "$BODY_DIRECTORY" 5 off

CURRENT_OPERATION='state initialization'
atomic_write "$LEDGER" '[]'
write_result in_progress ''

for index in "${!titles[@]}"; do
  title="${titles[$index]}"
  subsection="${subsections[$index]}"
  body_file="${body_files[$index]}"
  relative_body="${body_file#"$LOG_DIRECTORY/"}"

  CURRENT_OPERATION="create issue for $subsection"
  create_args=(
    "repos/$REPO/issues"
    -X POST
    -f "title=$title"
    -F "body=@$body_file"
  )
  if [[ -n "$SELECTED_ISSUE_TYPE" ]]; then
    create_args+=(-f "type=$SELECTED_ISSUE_TYPE")
  fi
  issue_json="$(gh api "${create_args[@]}" --jq '{id,number,node_id,html_url,title}')"
  issue_id="$(jq -r '.id' <<<"$issue_json")"
  issue_number="$(jq -r '.number' <<<"$issue_json")"
  issue_url="$(jq -r '.html_url' <<<"$issue_json")"

  updated="$(
    jq \
      --arg subsection "$subsection" \
      --arg body_file "$relative_body" \
      --argjson id "$issue_id" \
      --argjson number "$issue_number" \
      --arg title "$title" \
      --arg url "$issue_url" \
      '. + [{
        implementationSubsection: $subsection,
        bodyFile: $body_file,
        id: $id,
        number: $number,
        title: $title,
        url: $url,
        body_verified: false,
        linked: false
      }]' \
      "$LEDGER"
  )"
  atomic_write "$LEDGER" "$updated"

  CURRENT_OPERATION="verify body for issue #$issue_number"
  issue_json="$(
    "$ISSUE_BODY_VERIFIER" \
      "$REPO" \
      "$issue_number" \
      "$body_file" \
      6 \
      5 \
      "$LOG_DIRECTORY/issue-$issue_number-body-verification-failure.json"
  )"
  update_ledger_flag "$issue_number" body_verified true

  CURRENT_OPERATION="link issue #$issue_number"
  linked=false
  for attempt in 1 2 3; do
    if printf '{"sub_issue_id": %s}' "$issue_id" |
      gh api "repos/$REPO/issues/$PARENT_ISSUE/sub_issues" -X POST --input - >/dev/null; then
      linked=true
      break
    fi
    sleep 2
  done
  [[ "$linked" == true ]]
  update_ledger_flag "$issue_number" linked true
done

CURRENT_OPERATION='capture final child snapshot'
gh api "repos/$REPO/issues/$PARENT_ISSUE/sub_issues" --paginate --slurp |
  jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end' \
    > "$LOG_DIRECTORY/final-children.json"

CURRENT_OPERATION='verify child links'
"$CHILD_LINK_VERIFIER" \
  "$LOG_DIRECTORY/pre-creation-children.json" \
  "$LOG_DIRECTORY/final-children.json" \
  "$LEDGER"

CURRENT_OPERATION='verify final issue postconditions'
while IFS= read -r entry; do
  issue_number="$(jq -r '.number' <<<"$entry")"
  body_file="$LOG_DIRECTORY/$(jq -r '.bodyFile' <<<"$entry")"
  issue_json="$(
    "$ISSUE_BODY_VERIFIER" \
      "$REPO" \
      "$issue_number" \
      "$body_file" \
      6 \
      5 \
      "$LOG_DIRECTORY/issue-$issue_number-final-body-verification-failure.json"
  )"
  jq -e '.state == "open" and (.assignees | type == "array" and length == 0)' <<<"$issue_json" >/dev/null
done < <(jq -c '.[]' "$LEDGER")

CURRENT_OPERATION='complete stage result'
write_result complete ''
trap - ERR
jq '{status, ledgerFile, operationError}' "$RESULT"
jq -c '.[]' "$LEDGER"
