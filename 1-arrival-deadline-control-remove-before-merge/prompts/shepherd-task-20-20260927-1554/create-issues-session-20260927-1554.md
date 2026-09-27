# Copilot CLI Session

> [!NOTE]
> - **Session ID:** `22f1fedb-7156-4d87-9fcd-0a1efafa7e55`  
> - **Started:** 9/27/2026, 3:54:05 PM  
> - **Duration:** 1m 53s  
> - **Exported:** 9/27/2026, 3:55:59 PM  

---

<sub>3s</sub>

### User

Invoke skill `shepherd-task-20-create-issues-from-plan` with these inputs:

- CAMPAIGN_ID: 6d936e74-9009-4555-9199-de80546ba90b
- LESSON_PROPAGATION: off
- REPO: edburns/dd-3069621-cargotracker-darwin-arm64
- BASE_BRANCH: experiment/shepherd-control
- PARENT_ISSUE: 1
- PLAN_DIRECTORY: 1-arrival-deadline-control-remove-before-merge
- PLAN_FILE_NAME: add-change-arrival-deadline-feature-ignorance-reduction-plan.md
- QUESTIONS_SECTION: ## Phase 3 — Ignorance reduction: questions to answer before writing code
- IMPLEMENTATION_SECTION: ## Phase 4 — Implementation (five serial issues)
- EXPECTED_TASK_COUNT: 5
- BASE_REMOTE: origin
- LOG_DIRECTORY: /Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554
- DRAFT_VALIDATOR: /Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh
- ISSUE_BODY_VERIFIER: /Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh
- CHILD_LINK_VERIFIER: /Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh

Fixture pagination response contract (mandatory):

- `gh api ... --paginate --slurp` returns a JSON array of page payloads, so a
  one-page response has the shape `[[{...}]]`, not `[{...}]`.
- Before indexing child issue fields such as `.id`, normalize the response to
  one flat issue array exactly once.
- In Bash, use:
  `jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end'`.
- In PowerShell, capture the `gh` output and `$LASTEXITCODE` first, then pass
  the complete JSON through the same `jq` normalization before
  `ConvertFrom-Json`.
- Use the normalized flat array for the pre-creation baseline, final child
  count/order checks, and failure reconciliation. Do not apply `add` a second
  time to an already-flat array.

---

<sub>6s</sub>

### `skill`

**shepherd-task-20-create-issues-from-plan**

<details>
<summary>Arguments</summary>

```json
{
  "skill": "shepherd-task-20-create-issues-from-plan"
}
```

</details>

```
Skill "shepherd-task-20-create-issues-from-plan" loaded successfully. Follow the instructions in the skill context.
```


---

<sub>11s</sub>

### Copilot

I’m validating the campaign inputs, plan structure, GitHub parent, branch/remote, issue-type support, and the required fixture-normalized child baseline before drafting anything.

---

<sub>20s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/01-1682-java-tool-ergonomics.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/01-1682-java-tool-ergonomics.md

<details>
<summary>15 lines</summary>

```
# Example 01: 1682-java-tool-ergonomics-prompts-remove-before-merge

Read `copilot-sdk/1682-java-tool-ergonomics-prompts-remove-before-merge/dd-3018003-ignorance-reduction-for-implementation-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 3 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating issues of type **Task** as children of Epic https://github.com/github/copilot-sdk/issues/1682 . These issues correspond to the sub-sections in `## Phase 4 — Implementation (the build order)`.

I want you to use `gh` to create issues as sub-issues of 1682.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Set the type to **Task**.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `upstream`: `edburns/1682-java-tool-ergonomics`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `1682-java-tool-ergonomics-prompts-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**, I want you to carefully consider if there are additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>20s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/02-1810-java-tool-as-lambda.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/02-1810-java-tool-as-lambda.md

<details>
<summary>12 lines</summary>

```
# Example 02: 1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge

Carefully read the plan `copilot-sdk/1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`.

We have completed Phases 1 - 3. We are now on Phase 4.

For each sub item in Phase 4, file a child issue of Feature #1810.

Use `gh` to look at Epic #1682 and its child issues for the standard of verbosity and concreteness for issue descriptions.

The issue should be assignable to a coding agent and there must be sufficient detail in the description for the agent to proceed to completion.

Pull out the specific relevant content from Phase 3 as it applies to this current issue in Phase 4.

Tell the agent to take `edburns/1810-java-tool-ergonomics-tool-as-lambda` as the base branch. When I assign the issue to the coding agent, I will set this as the base branch.

Tell the agent to read `1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`, which is present on the branch, for context.

Tell the agent which sub-item within Phase 4 they are solving.

Tell the agent that each issue will be assigned, resolved and merged to the base branch in the order in which they appear in the plan.

No work is to start until I assign each issue to the coding agent, in turn.
```

</details>


---

<sub>20s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/03-dd-3017826-java-real-estate-demo.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/03-dd-3017826-java-real-estate-demo.md

<details>
<summary>14 lines</summary>

```
# Example 03: dd-3017826-java-real-estate-demo-remove-before-merge

Read `dd-3017826-java-real-estate-demo-remove-before-merge\dd-3017826-java-real-estate-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/2 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #2.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/2-build-out-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `dd-3017826-java-real-estate-demo-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there are additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>20s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/04-28-python-agent-demo.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/04-28-python-agent-demo.md

<details>
<summary>16 lines</summary>

```
# Example 04: 28-python-agent-demo-remove-before-merge

Read `28-python-agent-demo-remove-before-merge/28-python-agent-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`. These pertain to the implementation tasks in Phase 3. ✅✅✅ Include relevant spike findings as self-contained prose in the issue description; do not direct the agent to spike directories or source files.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/28 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #28

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Again, ✅✅For each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`, include the relevant Resolution values in the issue description. These pertain to the implementation tasks in Phase 3. ✅✅✅ State relevant spike findings directly in the issue body with enough detail to implement them without reading spike code.

- For tasks dealing with the UI, make sure to refer to the relevant screengrabs, but only ones within `28-python-agent-demo-remove-before-merge/`.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/28-python-agent-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `28-python-agent-demo-remove-before-merge/`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there are additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>20s</sub>

### `bash`

**Validate campaign and capture baseline**

$ set -euo pipefail
REPO='edburns/dd-3069621-cargotracker-darwin-arm64'
BASE_BRANCH='experiment/shepherd-control'
BASE_REMOTE='origin'
PARENT_ISSUE='1'
PLAN_DIRECTORY='1-arrival-deadline-control-remove-before-merge'
PLAN_FILE_NAME='add-change-arrival-deadline-feature-ignorance-reduction-plan.md'
LOG_DIRECTORY='/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554'
DRAFT_VALIDATOR='/Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh'
ISSUE_BODY_VERIFIER='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh'
CHILD_LINK_VERIFIER='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh'
[ "$PARENT_ISSUE" = "${PARENT_ISSUE##*[!0-9]*}" ] && [ "$PARENT_ISSUE" -gt 0 ]
[ -d "$LOG_DIRECTORY" ] && [ -w "$LOG_DIRECTORY" ]
mkdir -p "$LOG_DIRECTORY/issue-bodies"
for script in "$DRAFT_VALIDATOR" "$ISSUE_BODY_VERIFIER" "$CHILD_LINK_VERIFIER"; do [ "${script#/}" != "$script" ] && [ -f "$script" ] && [ -x "$script" ]; done
[ "$BASE_BRANCH" != main ]
git show-ref --verify --quiet "refs/heads/$BASE_BRANCH"
git remote get-url "$BASE_REMOTE" | grep -Eq '(^git@github\.com:|^https://github\.com/)edburns/dd-3069621-cargotracker-darwin-arm64(\.git)?$'
default_branch="$(gh api "repos/$REPO" --jq '.default_branch')"
[ "$BASE_BRANCH" != "$default_branch" ]
gh api "repos/$REPO/issues/$PARENT_ISSUE" --jq '{number,state,pull_request,repository_url}' > "$LOG_DIRECTORY/parent-issue-validation.json"
jq -e --arg repo_url "https://api.github.com/repos/$REPO" '.number == 1 and .state == "open" and (.pull_request == null) and .repository_url == $repo_url' "$LOG_DIRECTORY/parent-issue-validation.json" >/dev/null
repo_json="$(gh api "repos/$REPO")"
owner="$(jq -r '.owner.login' <<<"$repo_json")"
owner_type="$(jq -r '.owner.type' <<<"$repo_json")"
case "$owner_type" in
  User) selected_type='' ;;
  Organization)
    issue_types="$(gh api "orgs/$owner/issue-types")"
    if jq -e '.[] | select(.name == "Task" and .is_enabled == true)' <<<"$issue_types" >/dev/null; then selected_type='Task'; else selected_type=''; fi ;;
  *) echo "Unrecognized owner type: $owner_type" >&2; exit 1 ;;
esac
printf '%s\n' "$selected_type" > "$LOG_DIRECTORY/selected-issue-type.txt"
git show "$BASE_BRANCH:$PLAN_DIRECTORY/$PLAN_FILE_NAME" > "$LOG_DIRECTORY/plan-from-base.md"
git show "$BASE_BRANCH:$PLAN_DIRECTORY/shepherd-campaign.json" > "$LOG_DIRECTORY/shepherd-campaign.json"
git cat-file -e "$BASE_BRANCH:$PLAN_DIRECTORY/campaign-lessons.md"
gh api "repos/$REPO/issues/$PARENT_ISSUE/sub_issues" --paginate --slurp | jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end' > "$LOG_DIRECTORY/pre-creation-children.json"
printf 'default_branch=%s\nowner=%s\nowner_type=%s\nselected_issue_type=%s\npre_children=%s\n' "$default_branch" "$owner" "$owner_type" "${selected_type:-UNTYPED}" "$(jq length "$LOG_DIRECTORY/pre-creation-children.json")"

<details>
<summary>6 lines</summary>

```
default_branch=20260902-2104Z-commit-e7b651f-liberty
owner=edburns
owner_type=User
selected_issue_type=UNTYPED
pre_children=0
<shellId: 0 completed with exit code 0>
```

</details>


---

<sub>24s</sub>

### `view`

**view the file at /Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/plan-from-base.md.**

/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/plan-from-base.md

<details>
<summary>679 lines</summary>

````
# Implementation plan: Change Arrival Deadline Date (`eclipse-ee4j/cargotracker#64`)

Human DRI: Ed Burns
Starting commit: `9b9f311b2a3a2854bdac947593950d9edb6bca7d` (`Make the system ready for implementation`)
Working directory: repository root of the current campaign worktree
Runtime baseline: Java 17, Java EE 7 (`javax.*`), Open Liberty 26.0.0.8, PrimeFaces 8.0
Baseline run instructions: `README.md`
Baseline preparation: fixed source branch and immutable SHA validated by the campaign fixture
Historical issue: `eclipse-ee4j/cargotracker#64`

Related directories and files:

- `src/main/java/org/eclipse/cargotracker/application/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/`
- `src/main/webapp/admin/dialogs/`
- `src/main/webapp/admin/tables/listNotRouted.xhtml`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

---

## Goal

Add an Administration dashboard operation that lets a shipping administrator
change the arrival deadline of a cargo listed in the **Not Routed Cargo** table.
The operation must preserve Cargo Tracker's layered architecture:

1. The application service owns the domain mutation.
2. The booking facade shields the web layer from domain types.
3. A JSF backing bean loads and submits the editable date.
4. A PrimeFaces dynamic dialog presents the editor.
5. The existing Not Routed Cargo table opens the dialog and refreshes after a
   successful update.

### User-visible acceptance behavior

Using the stable sample cargo `DEF789`:

1. Start the application with Java 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Open `http://localhost:8080/cargo-tracker/`.
3. Select **Administration**.
4. Find `DEF789` in the **Not Routed Cargo** table.
5. The Deadline cell displays its date together with an edit icon.
6. Hovering over the deadline displays:
   `Click to change cargo arrival deadline date.`
7. Selecting the deadline opens a modal dialog titled **Change Deadline**.
8. The dialog displays the cargo's origin and destination as read-only
   context.
9. The date editor is initialized to the cargo's current arrival deadline.
10. Selecting a different date and pressing **Update** closes the dialog and
    refreshes the Administration view.
11. The new date is shown in the Not Routed Cargo table.
12. Reloading the page continues to show the new date for the lifetime of the
    running in-memory sample application.
13. Pressing **Cancel** closes the dialog without changing the deadline.

### Domain acceptance behavior

Changing the deadline must:

- locate the cargo by `TrackingId`;
- preserve its existing origin;
- preserve its existing destination;
- replace only the arrival deadline in its `RouteSpecification`;
- apply the specification through `Cargo.specifyNewRoute(...)`;
- preserve the currently assigned itinerary rather than silently discarding
  it;
- allow the domain model to recalculate routing status and delivery-derived
  values against the new route specification;
- persist the changed cargo through `CargoRepository.store(...)`.

### Hard scope constraints

- Begin from commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d`.
- Preserve Java EE 7 and the `javax.*` namespace.
- Preserve the Java 7 source/target level used by this historical codebase.
- Run the application on JDK 17 using the existing Open Liberty profile.
- Do not migrate the application to Jakarta EE 8+, Jakarta EE 9+, Spring, or a
  different UI framework.
- Do not replace the in-memory Derby configuration or the Open Liberty runtime.
- Do not redesign unrelated cargo booking, routing, destination editing,
  messaging, batch, REST, or persistence behavior.
- Do not copy commits or files from feature-bearing branches. This plan is the
  implementation specification.
- Implement the five build issues below in order. Each issue must be complete
  and gated before the next issue begins.

---

## Completed phases

### Phase 1 ✅ — Establish a runnable feature-absent baseline

- Commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d` is based on the historical
  feature-absent commit and contains only the compatibility work needed to run
  the sample on JDK 17 and Open Liberty.
- `./mvnw clean package -Popenliberty liberty:run` starts the application.
- The home page and Administration flows return HTTP 200.
- JSF view metadata is placed at `UIViewRoot` scope for MyFaces compatibility.
- The internal routing REST client works without a Jersey/MOXy classloading
  conflict.
- The scheduled batch job has the local authorization it needs.

### Phase 2 ✅ — Verify the before and after user experience

- Before implementation, `DEF789` appears in the Not Routed Cargo table with a
  plain-text deadline and no edit operation.
- The neighboring Destination column demonstrates the existing PrimeFaces
  dynamic-dialog interaction pattern.
- The desired after behavior has been manually exercised: open the deadline
  editor, choose a new date, update, refresh the table, and observe the
  persisted value.
- The historical architectural boundaries and affected files have been
  identified.

---

## Phase 3 — Ignorance reduction: questions to answer before writing code

Resolve these questions before production implementation begins. The
recommendations intentionally define the desired design closely enough that an
implementing agent should not need to invent a different architecture.

### 3.1 — Which cargos expose the edit operation?

**Question:** Should deadline editing be exposed for all cargos or only for
cargos displayed in the Not Routed Cargo table?

The requested feature originates in the Administration dashboard's Not Routed
Cargo table. Other tables represent routed, misrouted, claimed, or otherwise
progressed cargo. Adding the affordance to every table would expand the feature
and require additional business rules about changing deadlines after handling
has begun.

| Option | UI scope | Trade-off |
|--------|----------|-----------|
| A | Not Routed Cargo table only | Matches the requested feature and the established destination-edit affordance. |
| B | Every Administration cargo table | Broader capability, but introduces lifecycle and authorization questions outside the request. |
| C | Cargo details page only | Avoids table complexity but does not meet the requested dashboard interaction. |

The application-service operation itself does not need to encode a UI-table
restriction. It should accept a tracking ID and apply the domain mutation to
the located cargo. The presentation layer determines where the operation is
offered.

**Recommendation:** Option A. Add the edit affordance only to
`src/main/webapp/admin/tables/listNotRouted.xhtml`. Keep the application
operation generally usable for a valid cargo.

**Resolution:**

Select Option A. Expose the edit affordance only in
`src/main/webapp/admin/tables/listNotRouted.xhtml`. The application and facade
operations remain generally callable for any cargo that can be found by
tracking ID; they do not encode knowledge of dashboard table membership.

### 3.2 — What is the exact domain mutation?

**Question:** Should the feature mutate the existing `RouteSpecification`, add
a setter to `Cargo`, or replace the specification using the existing domain
operation?

`RouteSpecification` is a value object describing origin, destination, and
arrival deadline. The existing `changeDestination(...)` implementation already
establishes the correct pattern: create a replacement specification, call
`Cargo.specifyNewRoute(...)`, and store the aggregate.

Proposed application-service shape:

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

Proposed implementation:

```java
Cargo cargo = cargoRepository.find(trackingId);
RouteSpecification specification = new RouteSpecification(
        cargo.getOrigin(),
        cargo.getRouteSpecification().getDestination(),
        deadline);

cargo.specifyNewRoute(specification);
cargoRepository.store(cargo);
```

Calling `specifyNewRoute(...)` is significant. It lets the aggregate recalculate
delivery and routing status relative to the new specification. Direct field
mutation or a persistence-only update would bypass that behavior.

**Recommendation:** Replace the `RouteSpecification` through
`Cargo.specifyNewRoute(...)`. Preserve origin, destination, and itinerary.
Persist using the existing repository. Do not add a deadline setter to the
domain model.

**Resolution:**

Use the same aggregate-update pattern as `changeDestination(...)`. Add
`BookingService.changeDeadline(TrackingId, Date)` and implement it by loading
the cargo, constructing a new `RouteSpecification` from the existing origin,
existing destination, and supplied deadline, calling
`cargo.specifyNewRoute(...)`, and storing the cargo through
`cargoRepository.store(...)`. Do not add mutable deadline setters to the domain
objects.

### 3.3 — What should happen to an existing itinerary and delivery state?

**Question:** When a routed cargo's deadline changes, should its itinerary be
cleared, retained, or recomputed?

Although the UI initially exposes the feature only for unrouted cargo, the
application operation should have deterministic domain behavior if invoked for
a routed cargo. The existing `changeDestination(...)` behavior preserves the
assigned itinerary and lets `Cargo.specifyNewRoute(...)` recalculate whether
that itinerary still satisfies the new specification.

The core application test should deliberately invoke the operation after:

1. booking a cargo;
2. requesting route candidates;
3. assigning an itinerary;
4. changing its destination;
5. changing its deadline.

This sequence verifies that the feature uses the aggregate correctly rather
than assuming the cargo always has an empty itinerary.

**Recommendation:** Preserve the itinerary. Let the domain model recompute
routing and delivery-derived state. Assert all unaffected fields explicitly in
`BookingServiceTest`.

**Resolution:**

Retain the existing itinerary. Do not clear, replace, or reroute it as part of
the deadline change. `Cargo.specifyNewRoute(...)` recalculates the delivery
snapshot and routing status against the replacement specification. In the
established sequential application test, the assigned itinerary remains
unchanged and the cargo remains `MISROUTED` after the deadline changes.

### 3.4 — What type crosses the facade boundary?

**Question:** Should the booking facade accept a `Date`, a formatted string, or
a newly introduced request DTO?

The existing facade already uses `java.util.Date` for
`bookNewCargo(...)`. Introducing another representation for this one operation
would create unnecessary conversion code and depart from the historical
application style.

Proposed facade shape:

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

The implementation converts only the identifier:

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

**Recommendation:** Use `String` for the tracking ID and `java.util.Date` for
the deadline. Do not expose `TrackingId`, `Cargo`, or `RouteSpecification` to
the JSF layer and do not introduce a new DTO solely for this command.

**Resolution:**

Add `void changeDeadline(String trackingId, Date arrivalDeadline)` to
`BookingServiceFacade`. `DefaultBookingServiceFacade` converts the string to
`new TrackingId(trackingId)` and passes the same `Date` to
`BookingService.changeDeadline(...)`. No new command DTO or formatted-string
service parameter is introduced.

### 3.5 — How is the DTO's formatted deadline converted for editing?

**Question:** `CargoRoute` exposes its deadline as formatted strings, while
`p:datePicker` binds naturally to `java.util.Date`. How should the backing bean
initialize the editor?

At the starting commit:

- `CargoRoute.getArrivalDeadline()` returns
  `MM/dd/yyyy hh:mm a z`.
- `CargoRoute.getArrivalDeadlineDate()` returns only the date component.
- The table displays `getArrivalDeadlineDate()`.

Options:

| Option | Approach | Trade-off |
|--------|----------|-----------|
| A | Parse `cargo.getArrivalDeadlineDate()` with `MM/dd/yyyy` | Small, localized change; preserves the existing DTO contract. |
| B | Add a `Date` property to `CargoRoute` | Cleaner typing, but broadens a DTO used throughout the application. |
| C | Reload the domain object in the backing bean | Violates the facade boundary. |

The formatter/parser must be created per operation or per view bean; do not add
a shared mutable `SimpleDateFormat`.

**Recommendation:** Option A. Load `CargoRoute` through
`BookingServiceFacade.loadCargoForRouting(trackingId)` and parse
`cargo.getArrivalDeadlineDate()` using `new SimpleDateFormat("MM/dd/yyyy")`.
Surface an explicit failure if the existing DTO value cannot be parsed; do not
silently submit a null date.

**Resolution:**

Use Option A and keep date conversion inside the view-scoped editor bean. The
existing implementation loads the `CargoRoute`, creates
`new SimpleDateFormat("MM/dd/yyyy")`, and parses the leading date portion of
`cargo.getArrivalDeadline()`. Because that value begins with `MM/dd/yyyy`,
`SimpleDateFormat.parse(...)` obtains the same date that
`getArrivalDeadlineDate()` displays. A per-load formatter is used, so no shared
mutable formatter is added.

### 3.6 — Which JSF bean scopes and interaction pattern should be used?

**Question:** Should deadline editing introduce a new navigation page, use an
inline editor, or mirror the existing Change Destination dynamic-dialog
pattern?

The baseline already contains:

- `ChangeDestination`, a CDI `@Named` and JSF `@ViewScoped` editor bean;
- `ChangeDestinationDialog`, a session-scoped JSF managed bean that opens and
  closes a PrimeFaces dynamic dialog;
- `changeDestination.xhtml`, a dialog view;
- a `dialogReturn` Ajax listener that refreshes `tableNotRouted`.

Using the same pattern minimizes changes and provides a consistent user
experience.

Proposed bean names:

```text
changeArrivalDeadlineDate
changeArrivalDeadlineDateDialog
```

**Recommendation:** Add a serializable CDI `@Named @ViewScoped`
`ChangeArrivalDeadlineDate` editor and a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped`
launcher. Mirror the existing destination-dialog lifecycle rather than
introducing a new navigation or inline-edit framework.

**Resolution:**

Mirror the existing Change Destination interaction. Implement
`ChangeArrivalDeadlineDate` as a serializable CDI `@Named @ViewScoped` bean and
`ChangeArrivalDeadlineDateDialog` as a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped` bean.
Use a PrimeFaces dynamic dialog rather than navigation to a full page or inline
cell editing.

### 3.7 — What is the dynamic-dialog contract?

**Question:** What path, request parameters, dimensions, and close result should
the PrimeFaces dialog use?

The launcher needs one parameter, `trackingId`, supplied as a
`Map<String, List<String>>`. The dialog metadata binds the parameter and invokes
the editor bean's `load()` action.

Proposed launcher contract:

```java
PrimeFaces.current().dialog().openDynamic(
        "/admin/dialogs/changeArrivalDeadlineDate.xhtml",
        options,
        params);
```

Required options:

| Option | Value |
|--------|-------|
| `modal` | `true` |
| `draggable` | `true` |
| `resizable` | `false` |
| `contentWidth` | `410` |
| `contentHeight` | `280` |

Required completion behavior:

- successful update: `closeDynamic("DONE")`;
- cancel: `closeDynamic("")`;
- caller listens for `dialogReturn` and updates `tableNotRouted`.

Because Open Liberty uses MyFaces, `<f:metadata>` must be a direct child of the
view root, before `<h:head>` and `<h:body>`. It must not be nested inside
`<h:body>`.

**Recommendation:** Use the contract above and preserve the metadata placement
required by the prepared baseline.

**Resolution:**

Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with a single
`trackingId` request parameter and these options: modal and draggable are
`true`, resizable is `false`, content width is `410`, and content height is
`280`. Successful submission closes with `"DONE"`; cancellation closes with
the empty string. The caller handles `dialogReturn` and updates
`tableNotRouted`. Place the dialog's `<f:metadata>` directly under the root
`<html>` element, before `<h:head>` and `<h:body>`, so the known MyFaces
`UIViewRoot` requirement is satisfied.

### 3.8 — What date validation is required?

**Question:** Must the new deadline be non-null, in the future, after the
current date, or after itinerary completion?

The requested feature is an administrative correction to an existing arrival
deadline. No new domain policy about future dates is part of the request.
Inventing such a rule could reject dates accepted by existing cargo booking or
`RouteSpecification` behavior.

The UI must nevertheless prevent a null submission because the operation
requires a concrete replacement deadline.

**Recommendation:** Require a date value in the JSF form and display a normal
Faces validation message when it is absent. Do not add a new minimum-date,
future-date, or itinerary-date business rule. Continue to rely on the existing
domain model for its established invariants.

**Resolution:**

Require a non-null date selection, but add no new chronological business rule.
In particular, do not require the replacement deadline to be after today,
after the old deadline, or after every itinerary leg. Pass the selected
`java.util.Date` to the existing domain construction path and let the current
`RouteSpecification` invariants apply.

### 3.9 — How will the feature be tested on the prepared historical baseline?

**Question:** Which automated and runtime tests are mandatory, given that the
historical JUnit/Arquillian suite is configured for a remote Payara 4
container, while the prepared production baseline runs on JDK 17/Open Liberty?

The starting POM deliberately leaves `skipTests=true`. The Open Liberty profile
builds and compiles all test sources but does not provide a Liberty Arquillian
adapter. Modernizing the entire integration-test runtime is outside this
feature's scope.

The feature still needs layered evidence:

1. Extend `BookingServiceTest` with the domain/application assertions that
   specify the deadline mutation.
2. Ensure all test sources compile as part of
   `./mvnw clean package -Popenliberty`.
3. Add focused JUnit tests for facade and backing-bean delegation where they
   can run without a container, using hand-written fakes rather than adding a
   mocking framework.
4. Perform mandatory end-to-end verification against the running Open Liberty
   application.
5. Preserve the existing Payara Arquillian test path; do not delete, disable,
   or rewrite it to manufacture a passing result.

**Spike needed:** Before Issue 1 implementation, run the starting commit's
standard Open Liberty package command and record whether tests are compiled but
skipped. Confirm the new `BookingServiceTest` method can be added without
expanding the runtime modernization scope.

**Recommendation:** Treat the JDK 17/Open Liberty build plus HTTP/UI acceptance
as the mandatory executable gate. Keep the historical Arquillian test as a
precise application-layer specification and run it only when its documented
Payara environment is available.

**Resolution:**

Extend the existing sequential Arquillian `BookingServiceTest` with
`testChangeDeadline()` after `testChangeDestination()`. The test changes the
deadline by one month, reloads the cargo through JPA, and asserts the complete
set of preserved and recalculated domain state described above. The prepared
Open Liberty build compiles this test but retains the historical default
`skipTests=true`; executing that Arquillian suite still requires its documented
remote Payara environment. Therefore the mandatory executable gates are the
JDK 17 Open Liberty package/start command, direct HTTP checks, and the complete
`DEF789` browser acceptance flow. No Arquillian-runtime modernization or new
mocking dependency is part of this feature.

---

## Phase 4 — Implementation (five serial issues)

Implement these issues in order. Each issue should be a separate commit. Do not
start an issue until the previous issue's gating criteria are satisfied.

### 4.1 — Issue 1: Add the application-layer deadline change operation

**What to build**

Add the core use case to the application layer. This issue must contain no JSF
or PrimeFaces changes.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`
- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

**Required API**

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

**Required implementation behavior**

1. Load the cargo using `cargoRepository.find(trackingId)`.
2. Obtain the current destination from
   `cargo.getRouteSpecification().getDestination()`.
3. Construct a replacement `RouteSpecification` from:
   - `cargo.getOrigin()`;
   - the current destination;
   - the new deadline.
4. Apply it using `cargo.specifyNewRoute(routeSpecification)`.
5. Persist using `cargoRepository.store(cargo)`.
6. Log the tracking ID and new deadline at `Level.INFO`, following the style of
   `changeDestination(...)`.

Do not:

- add a setter to `Cargo` or `RouteSpecification`;
- modify the origin or destination;
- clear or replace the itinerary directly;
- update persistence entities behind the aggregate's back.

**Tests to write first**

Append a sequential `testChangeDeadline()` case to `BookingServiceTest` after
`testChangeDestination()`. Build a new deadline one month after the test's
original `deadline`, invoke the service, reload the cargo with
`Cargo.findByTrackingId`, and assert:

- origin remains Chicago;
- destination remains Helsinki;
- stored deadline is the same calendar day as the requested new deadline;
- assigned itinerary remains unchanged;
- transport status remains `NOT_RECEIVED`;
- last known location remains `Location.UNKNOWN`;
- current voyage remains `Voyage.NONE`;
- cargo is not marked misdirected;
- estimated time of arrival is `Delivery.ETA_UNKOWN`;
- next expected activity is `Delivery.NO_ACTIVITY`;
- cargo is not unloaded at destination;
- routing status reflects the domain model's recalculation and remains
  `MISROUTED` for the established test sequence.

**Gating criteria**

- The test source compiles.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- No web, facade, REST, Liberty, or persistence configuration files change in
  this issue.

### 4.2 — Issue 2: Expose deadline changes through the booking facade

**What to build**

Expose the use case to presentation clients without leaking domain identifier
types into the web layer.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`

**Optional focused test file**

- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`

**Required API**

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

**Required implementation**

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

The facade must not:

- load and mutate `Cargo` itself;
- call `CargoRepository.store(...)`;
- parse a formatted date;
- introduce JSF or PrimeFaces types.

**Tests**

Where a container-free test is added, use a hand-written `BookingService` fake
or spy and prove that:

- the same `Date` object/value reaches the application service;
- the tracking-ID string is converted to an equivalent `TrackingId`;
- the facade delegates exactly once;
- no repository work is duplicated in the facade.

Do not add Mockito or another dependency solely for this test.

**Gating criteria**

- Existing facade consumers still compile.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- The application-layer test added in Issue 1 remains unchanged and compiling.

### 4.3 — Issue 3: Implement the deadline editor backing model

**What to build**

Add the view-scoped backing bean that loads a cargo's current deadline and
submits a replacement deadline through the booking facade. Do not add the
dialog launcher or XHTML in this issue.

**File to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`

**Required bean shape**

```java
@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String trackingId;
    private CargoRoute cargo;
    private Date arrivalDeadlineDate;

    @Inject
    private BookingServiceFacade bookingServiceFacade;
}
```

Required properties and methods:

- `getTrackingId()` / `setTrackingId(String)`
- `getCargo()`
- `getArrivalDeadlineDate()` / `setArrivalDeadlineDate(Date)`
- `load()`
- `changeArrivalDeadline()`

**Load behavior**

1. Call `bookingServiceFacade.loadCargoForRouting(trackingId)`.
2. Store the returned `CargoRoute`.
3. Parse `cargo.getArrivalDeadlineDate()` using `MM/dd/yyyy`.
4. Store the resulting `Date` in `arrivalDeadlineDate`.
5. Do not query a repository or domain object directly.
6. Do not ignore a parsing failure or merely print its stack trace. Surface a
   clear application/view error consistent with existing JSF behavior.

**Submit behavior**

1. Refuse a null date through JSF validation or explicit bean validation.
2. Call
   `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`.
3. Close the dynamic dialog with:

   ```java
   PrimeFaces.current().dialog().closeDynamic("DONE");
   ```

4. Do not close the dialog if the facade call fails.

**Tests to write**

Add a container-free JUnit test if practical, using a hand-written fake facade,
that proves:

- `load()` requests the correct tracking ID;
- `load()` converts an `MM/dd/yyyy` DTO date into the editable `Date`;
- `changeArrivalDeadline()` delegates the selected date and tracking ID;
- a malformed DTO deadline is surfaced rather than converted to null;
- a null selected date is rejected.

Do not add a mocking framework solely for these tests.

**Gating criteria**

- The bean is serializable and uses the established CDI/JSF annotations.
- The bean references only facade DTOs, not domain model classes.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.

### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog

**What to build**

Add the session-scoped dialog launcher and the dynamic dialog view. The dialog
must work when addressed directly with a `trackingId` query parameter, but it
is not yet linked from the dashboard in this issue.

**Files to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`
- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`

**Launcher requirements**

Use:

```java
@ManagedBean(name = "changeArrivalDeadlineDateDialog")
@SessionScoped
```

Implement:

- `showDialog(String trackingId)`
- `handleReturn(SelectEvent event)`
- `cancel()`

`showDialog(...)` must:

- set the options documented in Question 3.7;
- pass `trackingId` as a dynamic-dialog request parameter;
- open `/admin/dialogs/changeArrivalDeadlineDate.xhtml`.

`cancel()` must close the dialog without invoking the facade.

**XHTML requirements**

The page title must be:

```xhtml
<title>Change Deadline</title>
```

Place metadata directly beneath the root `<html>` element and before
`<h:head>`:

```xhtml
<f:metadata>
    <f:viewParam name="trackingId"
                 value="#{changeArrivalDeadlineDate.trackingId}"/>
    <f:viewAction action="#{changeArrivalDeadlineDate.load}"/>
</f:metadata>
```

The form must display:

- `Origin:` and `changeArrivalDeadlineDate.cargo.originName`;
- `Destination:` and
  `changeArrivalDeadlineDate.cargo.finalDestinationName`;
- `Deadline:` and a `p:datePicker` bound to
  `changeArrivalDeadlineDate.arrivalDeadlineDate`;
- **Cancel**, invoking
  `changeArrivalDeadlineDateDialog.cancel()`;
- **Update**, invoking
  `changeArrivalDeadlineDate.changeArrivalDeadline()`.

The date picker must require a value. The Update action must reload or refresh
the calling Administration view after a successful dialog close, following the
existing destination-dialog behavior.

**Runtime tests**

With the application running, request:

```text
http://localhost:8080/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789
```

Verify:

- HTTP 200;
- title is **Change Deadline**;
- origin and destination render;
- the existing deadline is selected;
- no `TagException`, `Parent UIComponent`, `FacesException`, or server error is
  present;
- Cancel does not change the persisted deadline;
- Update changes the deadline.

**Gating criteria**

- `./mvnw clean package -Popenliberty liberty:run` succeeds on JDK 17.
- Direct dialog loading and both actions work.
- Destination editing continues to work.
- Stop Liberty cleanly before completing the issue.

### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard

**What to build**

Replace the plain deadline text in the Not Routed Cargo table with the
PrimeFaces command-link affordance that opens the completed dialog and refreshes
the table after return.

**File to modify**

- `src/main/webapp/admin/tables/listNotRouted.xhtml`

**Required UI shape**

Within the existing Deadline column, add a `p:commandLink` that:

- calls
  `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;
- retains the displayed
  `cargoNotRouted.arrivalDeadlineDate`;
- adds the existing Font Awesome edit icon style;
- uses a stable component ID such as `arrivalDeadlineToUpdate`;
- listens for `dialogReturn`;
- invokes
  `changeArrivalDeadlineDateDialog.handleReturn`;
- updates `tableNotRouted`;
- provides the tooltip:
  `Click to change cargo arrival deadline date.`

Follow the adjacent Destination column's established structure and styling. Do
not alter tracking-ID routing or destination editing.

**End-to-end acceptance test**

1. Start from a clean build on JDK 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Confirm the home page returns HTTP 200.
3. Open Administration and locate `DEF789`.
4. Record the original deadline.
5. Confirm the deadline now has an edit icon and tooltip.
6. Open the deadline dialog.
7. Confirm origin and destination identify the same cargo.
8. Choose a visibly different date.
9. Press **Update**.
10. Confirm the dialog closes and the Not Routed Cargo table refreshes.
11. Confirm the table shows the selected date.
12. Reload the browser and confirm the selected date remains.
13. Reopen the dialog and confirm the editor initializes to the changed date.
14. Press **Cancel** and confirm no additional change occurs.
15. Verify the Destination edit dialog still opens.
16. Verify selecting `DEF789` for routing still loads without an error page.

**Log acceptance**

The final run must contain none of:

- `<f:metadata> Parent UIComponent`;
- `TagException`;
- `VerifyError`;
- `FacesException`;
- `CWWKZ0002E` or `CWWKZ0003E`;
- recurring batch authorization failures;
- new FFDC files attributable to this feature.

Transient JMS activation-order warnings are acceptable only if all message
endpoints subsequently activate, as established by the prepared baseline.

**Final regression and scope checks**

- `./mvnw clean package -Popenliberty` succeeds.
- The existing test sources and the new deadline test compile.
- No Java EE namespace migration occurred.
- No Open Liberty, Derby, Jackson, JSF metadata, batch authorization, or REST
  compatibility fix from the starting commit was reverted.
- The feature affects only the intended application, facade, web, dialog,
  table, and test surfaces.
- Stop Liberty cleanly.

---

## Phase 5 — Documentation and implementation handoff

- Update `README.md` only if user-facing Administration capabilities are
  enumerated there; add one concise sentence that administrators can change an
  unrouted cargo's arrival deadline.
- Record the exact JDK 17 run command in the final issue or pull-request
  description:

  ```bash
  ./mvnw clean package -Popenliberty liberty:run
  ```

- Include `DEF789` and the before/after deadline values in the acceptance
  evidence.
- State explicitly that data is in-memory and resets when the application is
  rebuilt/restarted.

---

## Cross-cutting concerns

| Concern | Required handling |
|---------|--------------------|
| Domain-driven design | Mutate the aggregate through `Cargo.specifyNewRoute(...)`; do not bypass it with persistence-level field updates. |
| Layering | Web bean → booking facade → booking service → cargo repository. |
| Date handling | Use `java.util.Date` at service/facade boundaries and `MM/dd/yyyy` for the date-only editor representation. |
| Time zones | Acceptance compares the calendar date displayed by the application; do not introduce a new timezone policy in this feature. |
| Error handling | Do not silently swallow parse, lookup, validation, or persistence failures. A failed update must not look successful. |
| JSF compatibility | Keep `<f:metadata>` at view-root scope for MyFaces. |
| Bean lifecycle | Editor is CDI `@ViewScoped`; dynamic-dialog launcher mirrors the existing session-scoped JSF managed bean. |
| Accessibility | Preserve visible labels; the date editor must have an associated label and validation feedback. |
| Backward compatibility | Existing destination editing, routing, tracking, REST, messaging, batch, and startup behavior must remain intact. |
| Test discipline | Add tests before production code where practical; every issue must preserve all prior gates. |
| Experiment integrity | Implement from this specification starting at `9b9f311b2a3a2854bdac947593950d9edb6bca7d`; do not cherry-pick or inspect feature-bearing commits. |
````

</details>


---

<sub>24s</sub>

### `view`

**view the file at /Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/shepherd-campaign.json.**

/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/shepherd-campaign.json

<details>
<summary>16 lines</summary>

```
{
  "schemaVersion": 1,
  "campaignId": "6d936e74-9009-4555-9199-de80546ba90b",
  "campaignIssueNumber": 1,
  "campaignShortname": "arrival-deadline-control",
  "repository": "edburns/dd-3069621-cargotracker-darwin-arm64",
  "baseBranch": "experiment/shepherd-control",
  "lessonPropagation": "off",
  "campaignMetadataDirectory": "1-arrival-deadline-control-remove-before-merge",
  "lessonsFile": "campaign-lessons.md",
  "createdBy": {
    "shepherdTaskVersion": "1.0.5",
    "stageOutcomeProtocolVersion": 1
  },
  "createdAt": "2026-09-27T19:53:40Z"
}
```

</details>


---

<sub>24s</sub>

### `glob`

**1-arrival-deadline-control-remove-before-merge/**/***

"1-arrival-deadline-control-remove-before-merge/**/*"

<details>
<summary>15 matches</summary>

```
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/campaign-lessons.md
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/.stage20-after.32953
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/shepherd-test-experiment.json
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/shepherd-campaign.json
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/.stage20-before.32953
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/selected-issue-type.txt
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/parent-issue-validation.json
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/shepherd-campaign.json
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/20260927-1554-invoke-shepherd-task-20-create-issues-from-plan-skill.sh
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/pre-creation-children.json
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/create-issues-session-20260927-1554.jsonl
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/create-issues-otel-20260927-1554.jsonl
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/plan-from-base.md
/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/20260927-1554-invoke-shepherd-task-20-create-issues-from-plan-skill.md
```

</details>


---

<sub>24s</sub>

### `view`

**view the file at /Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh.**

/Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh (lines 1-240)

<details>
<summary>65 lines</summary>

```
#!/usr/bin/env bash
# shepherd-task-version: 1.0.5

set -euo pipefail

[[ $# -eq 3 ]] || {
    echo "Usage: $0 <body-directory> <expected-count> <off|campaign>" >&2
    exit 1
}

body_directory="$1"
expected_count="$2"
lesson_propagation="$3"

[[ -d "$body_directory" ]] || {
    echo "Stage-20 body directory does not exist: $body_directory" >&2
    exit 1
}
[[ "$expected_count" =~ ^[1-9][0-9]*$ ]] || {
    echo "Expected count must be a positive integer." >&2
    exit 1
}
[[ "$lesson_propagation" == "off" || "$lesson_propagation" == "campaign" ]] || {
    echo "Lesson propagation must be off or campaign." >&2
    exit 1
}

body_files=()
for body_file in "$body_directory"/*-body.md; do
    [[ -f "$body_file" ]] || continue
    [[ "$body_file" != *-observed-body.md ]] || continue
    body_files+=("$body_file")
done
[[ ${#body_files[@]} -eq $expected_count ]] || {
    echo "Expected $expected_count persisted stage-20 body files; found ${#body_files[@]}." >&2
    exit 1
}

required_headings=(
    '## Campaign context and required reading'
    '## Branch and execution order'
    '## Implement'
    '## Completion gates'
    '## Out of scope'
)

for body_file in "${body_files[@]}"; do
    [[ -s "$body_file" && "$(awk 'END { print NR }' "$body_file")" -gt 1 ]] || {
        echo "Persisted issue body must contain physical Markdown lines: $body_file" >&2
        exit 1
    }
    first_nonblank="$(awk 'NF { print; exit }' "$body_file")"
    [[ "$first_nonblank" =~ ^##[[:space:]]+[^[:space:]] ]] || {
        echo "Persisted issue body must begin with a level-two heading: $body_file" >&2
        exit 1
    }
    for heading in "${required_headings[@]}"; do
        grep -Fqx -- "$heading" "$body_file" || {
            echo "Persisted issue body is missing the physical heading '$heading': $body_file" >&2
            exit 1
        }
    done
    if [[ "$lesson_propagation" == "campaign" ]]; then
        grep -Fqx -- '## Campaign lessons (REQUIRED)' "$body_file" || {
            echo "Treatment issue body is missing its campaign-lessons heading: $body_file" >&2
            exit 1
        }
    elif grep -Fqx -- '## Campaign lessons (REQUIRED)' "$body_file"; then
        echo "Control issue body unexpectedly contains a campaign-lessons heading: $body_file" >&2
        exit 1
    fi
done
```

</details>


---

<sub>24s</sub>

### `view`

**view the file at /Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh.**

/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh (lines 1-240)

<details>
<summary>30 lines</summary>

```
#!/usr/bin/env bash
# shepherd-task-version: 1.0.5

set -euo pipefail

if [[ $# -ne 3 ]]; then
    echo "Usage: $0 <PRE_CREATION_CHILDREN_JSON> <FINAL_CHILDREN_JSON> <CREATION_LEDGER_JSON>" >&2
    exit 2
fi

for command_name in jq; do
    command -v "$command_name" >/dev/null 2>&1 || {
        echo "Error: Required command '$command_name' was not found." >&2
        exit 1
    }
done

script_dir="$(cd "$(dirname "$0")" && pwd)"
filter_path="$script_dir/verify-stage20-child-links.jq"
[[ -f "$filter_path" ]] || {
    echo "Error: Stage-20 child-link verification filter was not found: $filter_path" >&2
    exit 1
}

for input_path in "$@"; do
    [[ -f "$input_path" ]] || {
        echo "Error: Stage-20 child-link verification input was not found: $input_path" >&2
        exit 1
    }
done

jq -n \
    --slurpfile baseline "$1" \
    --slurpfile final "$2" \
    --slurpfile ledger "$3" \
    -f "$filter_path"
```

</details>


---

<sub>28s</sub>

### Copilot

Validation passed: the parent is open, the topic branch is non-default, the campaign manifest matches, all nine gating questions have substantive resolutions, and the five direct implementation tasks match the requested count. The repository owner is a user account, so the children will be created **without an issue type**. I’m now persisting all five complete specifications before any GitHub mutation.

---

<sub>1m 5s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

````json
"*** Begin Patch\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/issue-bodies/01-4.1-body.md\n+## Campaign context and required reading\n+\n+**On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.**\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`\n+- `### User-visible acceptance behavior`\n+- `### Domain acceptance behavior`\n+- `### Hard scope constraints`\n+- `### 3.2 — What is the exact domain mutation?`\n+- `### 3.3 — What should happen to an existing itinerary and delivery state?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.1 — Issue 1: Add the application-layer deadline change operation`\n+- `## Cross-cutting concerns`\n+\n+The resolved design is concrete: load the aggregate by `TrackingId`, create a replacement `RouteSpecification` from the existing origin, existing destination, and supplied `Date`, invoke `Cargo.specifyNewRoute(...)`, and persist through `CargoRepository.store(...)`. Do not add a mutable deadline setter. Preserve the assigned itinerary and allow `specifyNewRoute(...)` to recalculate delivery and routing state; in the established sequential test, the cargo remains `MISROUTED`.\n+\n+Research established that the prepared Open Liberty build compiles the historical Arquillian test sources but retains `skipTests=true`. Executing Arquillian still requires the documented remote Payara environment. Do not modernize the test runtime or add a mocking dependency.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the base branch for the pull request. This is task 1 of 5. The tasks are assigned, completed, and merged serially in plan order. Do not begin until this issue is assigned; task 2 must not begin until this task's gates pass and its pull request is merged.\n+\n+Implement from the campaign starting point; do not cherry-pick, copy, or inspect feature-bearing commits or use spike source as production code.\n+\n+## Implement\n+\n+Add the application-layer deadline-change operation with no facade, JSF, PrimeFaces, REST, Liberty, or persistence-configuration changes.\n+\n+Modify only the directly required files:\n+\n+- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`\n+- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`\n+- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`\n+\n+Add this service API:\n+\n+```java\n+void changeDeadline(TrackingId trackingId, Date deadline);\n+```\n+\n+Implement it by:\n+\n+1. Loading the cargo with `cargoRepository.find(trackingId)`.\n+2. Reading the current destination from `cargo.getRouteSpecification().getDestination()`.\n+3. Constructing a replacement `RouteSpecification` with `cargo.getOrigin()`, the current destination, and the supplied deadline.\n+4. Applying it through `cargo.specifyNewRoute(routeSpecification)`.\n+5. Persisting with `cargoRepository.store(cargo)`.\n+6. Logging the tracking ID and new deadline at `Level.INFO` in the style of `changeDestination(...)`.\n+\n+Write the test first. Append sequential `testChangeDeadline()` after `testChangeDestination()` in `BookingServiceTest`. Advance the original test deadline by one month, call the service, reload through `Cargo.findByTrackingId`, and assert:\n+\n+- origin remains Chicago;\n+- destination remains Helsinki;\n+- the stored deadline is the same calendar day as requested;\n+- the assigned itinerary is unchanged;\n+- transport status is `NOT_RECEIVED`;\n+- last known location is `Location.UNKNOWN`;\n+- current voyage is `Voyage.NONE`;\n+- the cargo is not misdirected;\n+- estimated arrival is `Delivery.ETA_UNKOWN`;\n+- next expected activity is `Delivery.NO_ACTIVITY`;\n+- the cargo is not unloaded at destination;\n+- routing status is recalculated and remains `MISROUTED`.\n+\n+Use `java.util.Date` and preserve the Java 7 source level and `javax.*` APIs.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- The new Arquillian specification compiles in the standard Open Liberty package build.\n+- The test explicitly proves every preserved and recalculated field listed above, including itinerary identity/content and `MISROUTED`.\n+- Existing tests remain unchanged except for the sequential deadline test addition.\n+- The diff is limited to the application API, application implementation, and application test.\n+- No parse, lookup, validation, or persistence failure is swallowed or turned into apparent success.\n+\n+## Out of scope\n+\n+- Facade APIs and facade tests.\n+- JSF backing beans, managed beans, dialogs, XHTML, and dashboard integration.\n+- New chronological rules such as requiring a future date or a date after itinerary completion.\n+- Clearing, replacing, or rerouting an itinerary.\n+- Adding setters to `Cargo` or `RouteSpecification`.\n+- Direct persistence-field updates.\n+- Arquillian/Payara modernization, dependency changes, or test-skipping changes.\n+- Java EE/Jakarta migration, Derby replacement, Liberty configuration, or unrelated behavior.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/issue-bodies/02-4.2-body.md\n+## Campaign context and required reading\n+\n+**On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.**\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`\n+- `### Domain acceptance behavior`\n+- `### Hard scope constraints`\n+- `### 3.2 — What is the exact domain mutation?`\n+- `### 3.4 — What type crosses the facade boundary?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.2 — Issue 2: Expose deadline changes through the booking facade`\n+- `## Cross-cutting concerns`\n+\n+The resolved facade contract is `void changeDeadline(String trackingId, Date arrivalDeadline)`. Convert only the identifier to `new TrackingId(trackingId)` and pass the same `java.util.Date` to the application service. The facade must preserve the architectural boundary: web clients receive no `TrackingId`, `Cargo`, or `RouteSpecification`, and no new command DTO or formatted-string parameter is introduced.\n+\n+Research established that focused container-free tests may use hand-written fakes, but this feature must not add Mockito or another mocking dependency. The standard Open Liberty package build is the mandatory executable compilation gate; do not modernize the historical Arquillian runtime.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the base branch for the pull request. This is task 2 of 5. The tasks are assigned, completed, and merged serially in plan order. Do not begin until this issue is assigned and task 1 has passed its gates and merged. Preserve task 1's application-layer API and test unchanged.\n+\n+Implement from the plan and merged predecessors; do not copy or inspect feature-bearing commits or transplant spike code.\n+\n+## Implement\n+\n+Expose the merged application use case through the booking facade.\n+\n+Modify:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`\n+\n+Optionally add:\n+\n+- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`\n+\n+Add:\n+\n+```java\n+void changeDeadline(String trackingId, Date arrivalDeadline);\n+```\n+\n+Delegate exactly as follows in architectural terms:\n+\n+```java\n+bookingService.changeDeadline(\n+        new TrackingId(trackingId),\n+        arrivalDeadline);\n+```\n+\n+Keep conversion and orchestration minimal. The application service remains the sole owner of aggregate loading, route-specification replacement, domain recalculation, and repository storage.\n+\n+If a focused test is practical with the repository's current test setup, use a hand-written `BookingService` fake/spy to prove:\n+\n+- the string becomes an equivalent `TrackingId`;\n+- the same `Date` object/value reaches the application service;\n+- delegation occurs exactly once;\n+- no repository work is duplicated in the facade.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- All existing facade consumers compile.\n+- Task 1's application-layer test remains unchanged and compiles.\n+- The facade method delegates once and contains no domain mutation or repository access.\n+- No new dependency is introduced.\n+- The diff contains no JSF, PrimeFaces, XHTML, REST, Liberty, or persistence changes.\n+\n+## Out of scope\n+\n+- Parsing or formatting deadline strings.\n+- Loading or mutating `Cargo` in the facade.\n+- Calling `CargoRepository.store(...)` from the facade.\n+- New command DTOs or exposure of domain types to the web layer.\n+- Backing beans, dynamic-dialog launchers, XHTML, and dashboard integration.\n+- New date-policy validation.\n+- Test-runtime modernization or mocking-framework adoption.\n+- Any unrelated Java EE, Open Liberty, Derby, routing, destination-editing, messaging, batch, or REST changes.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/issue-bodies/03-4.3-body.md\n+## Campaign context and required reading\n+\n+**On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.**\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`\n+- `### User-visible acceptance behavior`\n+- `### Hard scope constraints`\n+- `### 3.4 — What type crosses the facade boundary?`\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.3 — Issue 3: Implement the deadline editor backing model`\n+- `## Cross-cutting concerns`\n+\n+Resolved decisions: create a serializable CDI `@Named @ViewScoped` editor bean. It must load only through `BookingServiceFacade.loadCargoForRouting(trackingId)`, retain the `CargoRoute`, and parse the DTO date into `java.util.Date` with a per-load `SimpleDateFormat(\"MM/dd/yyyy\")`. The plan records that the full formatted deadline begins with that date portion, yielding the same calendar date shown by the table. Do not introduce a shared mutable formatter or access domain/repository types.\n+\n+A malformed deadline must surface a clear application/view error rather than becoming null or merely printing a stack trace. A null selected date must be rejected, but no future-date, old-deadline, or itinerary chronology rule may be invented. Successful submission delegates through the facade and closes with `\"DONE\"`; a failed facade call must not close the dialog.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the base branch for the pull request. This is task 3 of 5. The tasks are assigned, completed, and merged serially in plan order. Do not begin until assigned and tasks 1 and 2 have passed their gates and merged. Build only on those merged APIs.\n+\n+Implement from the specification; do not open, copy, or adapt spike source or feature-bearing commits.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`\n+\n+Use this required shape:\n+\n+```java\n+@Named\n+@ViewScoped\n+public class ChangeArrivalDeadlineDate implements Serializable {\n+    private static final long serialVersionUID = 1L;\n+\n+    private String trackingId;\n+    private CargoRoute cargo;\n+    private Date arrivalDeadlineDate;\n+\n+    @Inject\n+    private BookingServiceFacade bookingServiceFacade;\n+}\n+```\n+\n+Provide:\n+\n+- `getTrackingId()` and `setTrackingId(String)`;\n+- `getCargo()`;\n+- `getArrivalDeadlineDate()` and `setArrivalDeadlineDate(Date)`;\n+- `load()`;\n+- `changeArrivalDeadline()`.\n+\n+`load()` must:\n+\n+1. Call `bookingServiceFacade.loadCargoForRouting(trackingId)`.\n+2. Retain the returned `CargoRoute`.\n+3. Create a new `SimpleDateFormat(\"MM/dd/yyyy\")` for that load.\n+4. Parse the DTO's displayed date representation into `arrivalDeadlineDate`.\n+5. Surface parsing failure using a clear repository-consistent application/view error.\n+\n+`changeArrivalDeadline()` must:\n+\n+1. Reject a null selected date with normal JSF validation or explicit bean validation.\n+2. Invoke `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`.\n+3. Only after successful return, call `PrimeFaces.current().dialog().closeDynamic(\"DONE\")`.\n+4. Propagate or visibly report facade failure without closing.\n+\n+Add a focused container-free JUnit test if practical using a hand-written facade fake. Cover the correct tracking ID on load, `MM/dd/yyyy` conversion, exact submit delegation, malformed DTO data, and null selected date. Do not add a mocking library.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- The bean is serializable and uses the established CDI `@Named` and JSF `@ViewScoped` annotations.\n+- The bean imports facade APIs/DTOs but no cargo domain or repository classes.\n+- Parsing uses no static/shared mutable `SimpleDateFormat`.\n+- Malformed DTO data and null input have explicit failure behavior.\n+- The dialog closes only after successful facade delegation.\n+- No launcher class or XHTML is added in this task.\n+\n+## Out of scope\n+\n+- Dynamic-dialog launcher behavior or session-scoped managed beans.\n+- Dialog XHTML and dashboard-table changes.\n+- Repository or domain access from the web layer.\n+- Changing `CargoRoute` to add a `Date` property.\n+- New request DTOs or formatted-string facade parameters.\n+- New chronological business rules.\n+- Mocking dependencies, Arquillian modernization, or unrelated framework/configuration changes.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/issue-bodies/04-4.4-body.md\n+## Campaign context and required reading\n+\n+**On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.**\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`\n+- `### User-visible acceptance behavior`\n+- `### Hard scope constraints`\n+- `### Phase 1 ✅ — Establish a runnable feature-absent baseline`\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog`\n+- `## Cross-cutting concerns`\n+\n+Resolved decisions: mirror the existing Change Destination interaction with a serializable session-scoped JSF managed launcher and a PrimeFaces dynamic dialog. Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with one `trackingId` parameter; options are `modal=true`, `draggable=true`, `resizable=false`, `contentWidth=410`, and `contentHeight=280`. Success closes with `\"DONE\"` and cancellation with `\"\"`.\n+\n+The prepared MyFaces/Open Liberty baseline established a strict compatibility requirement: `<f:metadata>` must be directly beneath the root `<html>` element and before `<h:head>` and `<h:body>`. Nesting metadata in the body causes view-root failures. Implement this production pattern directly; do not copy spike code.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the base branch for the pull request. This is task 4 of 5. The tasks are assigned, completed, and merged serially in plan order. Do not begin until assigned and tasks 1 through 3 have passed their gates and merged.\n+\n+The dashboard link is task 5. This task must make the dialog independently addressable and functional without changing the Not Routed Cargo table.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`\n+- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`\n+\n+The serializable launcher must use:\n+\n+```java\n+@ManagedBean(name = \"changeArrivalDeadlineDateDialog\")\n+@SessionScoped\n+```\n+\n+Implement `showDialog(String trackingId)`, `handleReturn(SelectEvent event)`, and `cancel()`. `showDialog(...)` must construct the exact options above, pass `trackingId` as a `Map<String, List<String>>` dynamic-dialog request parameter, and open the exact dialog path. `cancel()` closes with an empty-string result and must not invoke the facade.\n+\n+The XHTML must:\n+\n+- use `<title>Change Deadline</title>`;\n+- place `<f:metadata>` directly under `<html>` and before `<h:head>`;\n+- bind `trackingId` to `#{changeArrivalDeadlineDate.trackingId}`;\n+- invoke `#{changeArrivalDeadlineDate.load}` through `<f:viewAction>`;\n+- display labeled, read-only origin via `changeArrivalDeadlineDate.cargo.originName`;\n+- display labeled, read-only destination via `changeArrivalDeadlineDate.cargo.finalDestinationName`;\n+- bind a labeled `p:datePicker` to `changeArrivalDeadlineDate.arrivalDeadlineDate`;\n+- require a date and render validation feedback;\n+- provide Cancel via `changeArrivalDeadlineDateDialog.cancel()`;\n+- provide Update via `changeArrivalDeadlineDate.changeArrivalDeadline()`.\n+\n+Follow the established destination-dialog return lifecycle. Ensure a successful return can refresh the calling Administration view, while preserving the task boundary that the dashboard link itself is not added here.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty liberty:run` succeeds on JDK 17.\n+- A direct request to `/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789` returns HTTP 200.\n+- The page title, origin, destination, and current deadline render correctly.\n+- Update changes the deadline and Cancel preserves it.\n+- Required date validation is visible and prevents null submission.\n+- No `TagException`, `Parent UIComponent`, `FacesException`, or server error appears.\n+- Existing destination editing still works.\n+- Liberty is stopped cleanly before completion.\n+\n+## Out of scope\n+\n+- Editing `src/main/webapp/admin/tables/listNotRouted.xhtml`.\n+- Exposing the operation in routed, misrouted, claimed, or other cargo tables.\n+- Inline editing or full-page navigation.\n+- New date chronology policies.\n+- Changes to application, domain, repository, or facade behavior already merged.\n+- JSF/Jakarta migration, Liberty/Derby replacement, or unrelated UI redesign.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/issue-bodies/05-4.5-body.md\n+## Campaign context and required reading\n+\n+**On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.**\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`\n+- `### User-visible acceptance behavior`\n+- `### Domain acceptance behavior`\n+- `### Hard scope constraints`\n+- `### Phase 1 ✅ — Establish a runnable feature-absent baseline`\n+- `### Phase 2 ✅ — Verify the before and after user experience`\n+- `### 3.1 — Which cargos expose the edit operation?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard`\n+- `## Phase 5 — Documentation and implementation handoff`\n+- `## Cross-cutting concerns`\n+\n+The resolved scope is the Not Routed Cargo table only. The service/facade remain generally callable, but no edit affordance belongs in routed, misrouted, claimed, or other tables. Mirror the adjacent Destination column's PrimeFaces command-link structure and styling. The dialog contract is already complete: successful update returns `\"DONE\"`; the caller handles `dialogReturn` and updates `tableNotRouted`.\n+\n+Research on the prepared baseline established that the standard JDK 17/Open Liberty build compiles tests while historical Arquillian execution remains skipped and requires remote Payara. The mandatory final evidence is the package/start command, direct HTTP checks, and the complete `DEF789` browser flow. Do not modernize Arquillian or add a mocking framework.\n+\n+## Branch and execution order\n+\n+Use `experiment/shepherd-control` from remote `origin` as the base branch for the pull request. This is task 5 of 5. The tasks are assigned, completed, and merged serially in plan order. Do not begin until assigned and tasks 1 through 4 have passed their gates and merged.\n+\n+This final task integrates and verifies the completed feature. Do not copy or inspect feature-bearing commits or use spike source as an implementation template.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/webapp/admin/tables/listNotRouted.xhtml`\n+\n+In the existing Deadline column, replace plain deadline text with a `p:commandLink` that:\n+\n+- calls `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;\n+- continues displaying `cargoNotRouted.arrivalDeadlineDate`;\n+- uses the existing Font Awesome edit-icon style;\n+- has a stable component ID such as `arrivalDeadlineToUpdate`;\n+- contains a `dialogReturn` listener invoking `changeArrivalDeadlineDateDialog.handleReturn`;\n+- updates `tableNotRouted`;\n+- exposes the exact tooltip `Click to change cargo arrival deadline date.`\n+\n+Follow the neighboring Destination column's established structure. Preserve its behavior, tracking-ID routing, and all other table operations.\n+\n+Run the complete end-to-end acceptance flow:\n+\n+1. Start with `./mvnw clean package -Popenliberty liberty:run` on JDK 17.\n+2. Confirm the home page returns HTTP 200.\n+3. Open Administration, find `DEF789`, and record its original deadline.\n+4. Verify the deadline has the edit icon and exact tooltip.\n+5. Open the deadline dialog and verify origin/destination identify `DEF789`.\n+6. Select a visibly different date and press Update.\n+7. Verify the dialog closes, the Not Routed table refreshes, and the selected date appears.\n+8. Reload and verify the selected date persists for the lifetime of the running in-memory application.\n+9. Reopen and verify the editor initializes to the changed date.\n+10. Cancel and verify no additional change.\n+11. Verify the Destination edit dialog still opens.\n+12. Verify selecting `DEF789` for routing does not produce an error page.\n+\n+If `README.md` enumerates user-facing Administration capabilities, add one concise sentence about changing an unrouted cargo's arrival deadline; otherwise leave it unchanged. In the pull-request evidence, record `DEF789`, the before/after dates, the exact run command, and that in-memory data resets after rebuild/restart.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17 and all test sources compile.\n+- The full browser flow above passes, including update persistence, reopen initialization, and cancel behavior.\n+- Home and relevant direct HTTP requests return HTTP 200.\n+- Destination editing and routing selection remain functional.\n+- Runtime logs contain none of: `<f:metadata> Parent UIComponent`, `TagException`, `VerifyError`, `FacesException`, `CWWKZ0002E`, `CWWKZ0003E`, recurring batch authorization failures, or new feature-attributable FFDC files.\n+- Transient JMS activation-order warnings are acceptable only if every endpoint subsequently activates.\n+- No Java EE namespace migration occurs and none of the prepared Liberty, Derby, Jackson, JSF metadata, batch authorization, or REST compatibility fixes are reverted.\n+- Liberty is stopped cleanly.\n+\n+## Out of scope\n+\n+- Edit affordances outside `listNotRouted.xhtml`.\n+- Changes to tracking-ID routing or destination editing.\n+- New business rules for future dates or itinerary chronology.\n+- Refactoring completed application, facade, bean, or dialog layers without a gate-blocking defect.\n+- Arquillian/Payara modernization or test-configuration manipulation.\n+- Java EE/Jakarta migration, framework replacement, datastore/runtime replacement, or unrelated redesign.\n*** End Patch\n"
````

</details>

```
Added 5 file(s): /Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/issue-bodies/01-4.1-body.md, /Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/issue-bodies/02-4.2-body.md, /Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/issue-bodies/03-4.3-body.md, /Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/issue-bodies/04-4.4-body.md, /Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/issue-bodies/05-4.5-body.md
```


---

<sub>1m 24s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

```json
"*** Begin Patch\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/run-stage20.sh\n+#!/usr/bin/env bash\n+set -euo pipefail\n+\n+REPO='edburns/dd-3069621-cargotracker-darwin-arm64'\n+PARENT_ISSUE=1\n+LOG_DIRECTORY='/Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554'\n+BODY_DIRECTORY=\"$LOG_DIRECTORY/issue-bodies\"\n+LEDGER=\"$LOG_DIRECTORY/creation-ledger.json\"\n+RESULT=\"$LOG_DIRECTORY/stage-20-result.json\"\n+DRAFT_VALIDATOR='/Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh'\n+ISSUE_BODY_VERIFIER='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh'\n+CHILD_LINK_VERIFIER='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh'\n+SELECTED_ISSUE_TYPE=''\n+CURRENT_OPERATION='initialization'\n+\n+titles=(\n+  '4.1 — Add the application-layer deadline change operation'\n+  '4.2 — Expose deadline changes through the booking facade'\n+  '4.3 — Implement the deadline editor backing model'\n+  '4.4 — Implement the PrimeFaces deadline dialog'\n+  '4.5 — Integrate deadline editing into the Administration dashboard'\n+)\n+subsections=(\n+  '4.1 — Issue 1: Add the application-layer deadline change operation'\n+  '4.2 — Issue 2: Expose deadline changes through the booking facade'\n+  '4.3 — Issue 3: Implement the deadline editor backing model'\n+  '4.4 — Issue 4: Implement the PrimeFaces deadline dialog'\n+  '4.5 — Issue 5: Integrate deadline editing into the Administration dashboard'\n+)\n+body_files=(\n+  \"$BODY_DIRECTORY/01-4.1-body.md\"\n+  \"$BODY_DIRECTORY/02-4.2-body.md\"\n+  \"$BODY_DIRECTORY/03-4.3-body.md\"\n+  \"$BODY_DIRECTORY/04-4.4-body.md\"\n+  \"$BODY_DIRECTORY/05-4.5-body.md\"\n+)\n+\n+atomic_write() {\n+  local path=\"$1\" content=\"$2\" temporary\n+  temporary=\"${path}.tmp.$$\"\n+  printf '%s\\n' \"$content\" > \"$temporary\"\n+  mv \"$temporary\" \"$path\"\n+}\n+\n+update_ledger_flag() {\n+  local number=\"$1\" field=\"$2\" value=\"$3\" updated\n+  updated=\"$(\n+    jq \\\n+      --argjson number \"$number\" \\\n+      --arg field \"$field\" \\\n+      --argjson value \"$value\" \\\n+      'map(if .number == $number then .[$field] = $value else . end)' \\\n+      \"$LEDGER\"\n+  )\" || return 1\n+  atomic_write \"$LEDGER\" \"$updated\"\n+}\n+\n+write_result() {\n+  local status=\"$1\" error=\"$2\" content\n+  content=\"$(\n+    jq -n \\\n+      --arg status \"$status\" \\\n+      --arg error \"$error\" \\\n+      '{\n+        schemaVersion: 1,\n+        status: $status,\n+        ledgerFile: \"creation-ledger.json\",\n+        operationError: (if $error == \"\" then null else $error end)\n+      }'\n+  )\"\n+  atomic_write \"$RESULT\" \"$content\"\n+}\n+\n+reconcile_failure() {\n+  local exit_code=\"$1\" error=\"Operation '$CURRENT_OPERATION' failed with exit code $exit_code.\"\n+  trap - ERR\n+  set +e\n+  if [[ -f \"$LEDGER\" ]]; then\n+    server_output=\"$(gh api \"repos/$REPO/issues/$PARENT_ISSUE/sub_issues\" --paginate --slurp 2>&1)\"\n+    server_status=$?\n+    if [[ $server_status -eq 0 ]]; then\n+      normalized=\"$(jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end' <<<\"$server_output\")\"\n+      reconciled=\"$(\n+        jq \\\n+          --argjson children \"$normalized\" \\\n+          'map(.linked = ([ $children[] | select(.id == .id) ] | length > 0))' \\\n+          \"$LEDGER\"\n+      )\"\n+      # Reconcile by child ID without flattening the already-normalized array again.\n+      reconciled=\"$(\n+        jq \\\n+          --argjson children \"$normalized\" \\\n+          'map(. as $entry | .linked = ([$children[] | select(.id == $entry.id)] | length == 1))' \\\n+          \"$LEDGER\"\n+      )\"\n+      atomic_write \"$LEDGER\" \"$reconciled\"\n+    else\n+      error=\"$error Reconciliation query failed: $server_output\"\n+    fi\n+  fi\n+  write_result failed \"$error\"\n+  printf '%s\\n' \"$error\" >&2\n+  if [[ -s \"$LEDGER\" ]] && [[ \"$(jq length \"$LEDGER\" 2>/dev/null)\" -gt 0 ]]; then\n+    jq -r '.[] | \"issue #\\(.number) | \\(.title) | \\(.url) | \\(.bodyFile) | body_verified=\\(.body_verified) | linked=\\(.linked)\"' \"$LEDGER\" >&2\n+    jq -r --arg repo \"$REPO\" '.[] | \"gh issue delete \\(.number) --repo \\\"\\($repo)\\\" --yes\"' \"$LEDGER\" >&2\n+    printf '%s\\n' 'The operation did not complete. No automatic rollback was performed. Delete every issue in the ledger before invoking this skill again.' >&2\n+  else\n+    printf '%s\\n' 'No issues were created; no cleanup is required.' >&2\n+  fi\n+  exit \"$exit_code\"\n+}\n+\n+trap 'reconcile_failure $?' ERR\n+\n+CURRENT_OPERATION='draft validation'\n+\"$DRAFT_VALIDATOR\" \"$BODY_DIRECTORY\" 5 off\n+\n+CURRENT_OPERATION='state initialization'\n+atomic_write \"$LEDGER\" '[]'\n+write_result in_progress ''\n+\n+for index in \"${!titles[@]}\"; do\n+  title=\"${titles[$index]}\"\n+  subsection=\"${subsections[$index]}\"\n+  body_file=\"${body_files[$index]}\"\n+  relative_body=\"${body_file#\"$LOG_DIRECTORY/\"}\"\n+\n+  CURRENT_OPERATION=\"create issue for $subsection\"\n+  create_args=(\n+    \"repos/$REPO/issues\"\n+    -X POST\n+    -f \"title=$title\"\n+    -F \"body=@$body_file\"\n+  )\n+  if [[ -n \"$SELECTED_ISSUE_TYPE\" ]]; then\n+    create_args+=(-f \"type=$SELECTED_ISSUE_TYPE\")\n+  fi\n+  issue_json=\"$(gh api \"${create_args[@]}\" --jq '{id,number,node_id,html_url,title}')\"\n+  issue_id=\"$(jq -r '.id' <<<\"$issue_json\")\"\n+  issue_number=\"$(jq -r '.number' <<<\"$issue_json\")\"\n+  issue_url=\"$(jq -r '.html_url' <<<\"$issue_json\")\"\n+\n+  updated=\"$(\n+    jq \\\n+      --arg subsection \"$subsection\" \\\n+      --arg body_file \"$relative_body\" \\\n+      --argjson id \"$issue_id\" \\\n+      --argjson number \"$issue_number\" \\\n+      --arg title \"$title\" \\\n+      --arg url \"$issue_url\" \\\n+      '. + [{\n+        implementationSubsection: $subsection,\n+        bodyFile: $body_file,\n+        id: $id,\n+        number: $number,\n+        title: $title,\n+        url: $url,\n+        body_verified: false,\n+        linked: false\n+      }]' \\\n+      \"$LEDGER\"\n+  )\"\n+  atomic_write \"$LEDGER\" \"$updated\"\n+\n+  CURRENT_OPERATION=\"verify body for issue #$issue_number\"\n+  issue_json=\"$(\n+    \"$ISSUE_BODY_VERIFIER\" \\\n+      \"$REPO\" \\\n+      \"$issue_number\" \\\n+      \"$body_file\" \\\n+      6 \\\n+      5 \\\n+      \"$LOG_DIRECTORY/issue-$issue_number-body-verification-failure.json\"\n+  )\"\n+  update_ledger_flag \"$issue_number\" body_verified true\n+\n+  CURRENT_OPERATION=\"link issue #$issue_number\"\n+  linked=false\n+  for attempt in 1 2 3; do\n+    if printf '{\"sub_issue_id\": %s}' \"$issue_id\" |\n+      gh api \"repos/$REPO/issues/$PARENT_ISSUE/sub_issues\" -X POST --input - >/dev/null; then\n+      linked=true\n+      break\n+    fi\n+    sleep 2\n+  done\n+  [[ \"$linked\" == true ]]\n+  update_ledger_flag \"$issue_number\" linked true\n+done\n+\n+CURRENT_OPERATION='capture final child snapshot'\n+gh api \"repos/$REPO/issues/$PARENT_ISSUE/sub_issues\" --paginate --slurp |\n+  jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end' \\\n+    > \"$LOG_DIRECTORY/final-children.json\"\n+\n+CURRENT_OPERATION='verify child links'\n+\"$CHILD_LINK_VERIFIER\" \\\n+  \"$LOG_DIRECTORY/pre-creation-children.json\" \\\n+  \"$LOG_DIRECTORY/final-children.json\" \\\n+  \"$LEDGER\"\n+\n+CURRENT_OPERATION='verify final issue postconditions'\n+while IFS= read -r entry; do\n+  issue_number=\"$(jq -r '.number' <<<\"$entry\")\"\n+  body_file=\"$LOG_DIRECTORY/$(jq -r '.bodyFile' <<<\"$entry\")\"\n+  issue_json=\"$(\n+    \"$ISSUE_BODY_VERIFIER\" \\\n+      \"$REPO\" \\\n+      \"$issue_number\" \\\n+      \"$body_file\" \\\n+      6 \\\n+      5 \\\n+      \"$LOG_DIRECTORY/issue-$issue_number-final-body-verification-failure.json\"\n+  )\"\n+  jq -e '.state == \"open\" and (.assignees | type == \"array\" and length == 0)' <<<\"$issue_json\" >/dev/null\n+done < <(jq -c '.[]' \"$LEDGER\")\n+\n+CURRENT_OPERATION='complete stage result'\n+write_result complete ''\n+trap - ERR\n+jq '{status, ledgerFile, operationError}' \"$RESULT\"\n+jq -c '.[]' \"$LEDGER\"\n*** End Patch\n"
```

</details>

```
Added 1 file(s): /Users/edburns/workareas/dd-3069621-cargotracker-darwin-arm64-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/run-stage20.sh
```


---

<sub>1m 27s</sub>

### Copilot

All five persisted issue bodies are ready and conform to the required structure, serial dependencies, spike firewall, concrete resolution values, tests, and scope boundaries. I’m running the mandatory draft validator now, then the one-shot create/verify/link sequence and authoritative postcondition checks.

---

<sub>1m 42s</sub>

### `bash`

**Create and verify child issues**

$ set -euo pipefail
chmod +x '1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/run-stage20.sh'
'1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260927-1554/run-stage20.sh'

<details>
<summary>23 lines</summary>

```
{
  "baselineCount": 0,
  "ledgerCount": 5,
  "finalCount": 5,
  "newIssueIds": [
    5605780741,
    5605780945,
    5605781144,
    5605781335,
    5605781539
  ]
}
{
  "status": "complete",
  "ledgerFile": "creation-ledger.json",
  "operationError": null
}
{"implementationSubsection":"4.1 — Issue 1: Add the application-layer deadline change operation","bodyFile":"issue-bodies/01-4.1-body.md","id":5605780741,"number":2,"title":"4.1 — Add the application-layer deadline change operation","url":"https://github.com/edburns/dd-3069621-cargotracker-darwin-arm64/issues/2","body_verified":true,"linked":true}
{"implementationSubsection":"4.2 — Issue 2: Expose deadline changes through the booking facade","bodyFile":"issue-bodies/02-4.2-body.md","id":5605780945,"number":3,"title":"4.2 — Expose deadline changes through the booking facade","url":"https://github.com/edburns/dd-3069621-cargotracker-darwin-arm64/issues/3","body_verified":true,"linked":true}
{"implementationSubsection":"4.3 — Issue 3: Implement the deadline editor backing model","bodyFile":"issue-bodies/03-4.3-body.md","id":5605781144,"number":4,"title":"4.3 — Implement the deadline editor backing model","url":"https://github.com/edburns/dd-3069621-cargotracker-darwin-arm64/issues/4","body_verified":true,"linked":true}
{"implementationSubsection":"4.4 — Issue 4: Implement the PrimeFaces deadline dialog","bodyFile":"issue-bodies/04-4.4-body.md","id":5605781335,"number":5,"title":"4.4 — Implement the PrimeFaces deadline dialog","url":"https://github.com/edburns/dd-3069621-cargotracker-darwin-arm64/issues/5","body_verified":true,"linked":true}
{"implementationSubsection":"4.5 — Issue 5: Integrate deadline editing into the Administration dashboard","bodyFile":"issue-bodies/05-4.5-body.md","id":5605781539,"number":6,"title":"4.5 — Integrate deadline editing into the Administration dashboard","url":"https://github.com/edburns/dd-3069621-cargotracker-darwin-arm64/issues/6","body_verified":true,"linked":true}
<shellId: 1 completed with exit code 0>
```

</details>


---

<sub>1m 52s</sub>

### Copilot

Created and linked five verified, unassigned child issues under #1 in the required order. All issue bodies and stage artifacts are persisted; `stage-20-result.json` reports `complete`.

| Implementation subsection | Issue | Title |
|---|---:|---|
| 4.1 | [#2](https://github.com/edburns/dd-3069621-cargotracker-darwin-arm64/issues/2) | Add the application-layer deadline change operation |
| 4.2 | [#3](https://github.com/edburns/dd-3069621-cargotracker-darwin-arm64/issues/3) | Expose deadline changes through the booking facade |
| 4.3 | [#4](https://github.com/edburns/dd-3069621-cargotracker-darwin-arm64/issues/4) | Implement the deadline editor backing model |
| 4.4 | [#5](https://github.com/edburns/dd-3069621-cargotracker-darwin-arm64/issues/5) | Implement the PrimeFaces deadline dialog |
| 4.5 | [#6](https://github.com/edburns/dd-3069621-cargotracker-darwin-arm64/issues/6) | Integrate deadline editing into the Administration dashboard |

**Ordered child numbers:** `2,3,4,5,6`

**Suggested stage 25 invocation:** Invoke `shepherd-task-25-given-list` for repository `edburns/dd-3069621-cargotracker-darwin-arm64`, base branch `experiment/shepherd-control`, parent issue `1`, ordered issues `2,3,4,5,6`, and plan directory `1-arrival-deadline-control-remove-before-merge`.

The issues were created **without an issue type** because the repository is user-owned and organization issue types are unavailable.

---

<sub>Generated by [GitHub Copilot CLI](https://github.com/features/copilot/cli)</sub>
