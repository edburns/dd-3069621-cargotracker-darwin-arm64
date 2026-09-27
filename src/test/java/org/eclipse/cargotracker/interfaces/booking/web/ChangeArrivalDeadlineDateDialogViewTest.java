package org.eclipse.cargotracker.interfaces.booking.web;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChangeArrivalDeadlineDateDialogViewTest {

    @Test
    public void metadataIsAtViewRootAndDateIsRequiredWithFeedback() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document view = factory.newDocumentBuilder().parse(new File(
                "src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml"));
        Element html = view.getDocumentElement();
        Element metadata = firstElementChild(html);

        assertEquals("metadata", metadata.getLocalName());
        assertEquals("http://xmlns.jcp.org/jsf/core", metadata.getNamespaceURI());
        assertEquals("head", nextElementSibling(metadata.getNextSibling()).getLocalName());
        assertEquals("#{changeArrivalDeadlineDate.trackingId}",
                element(view, "http://xmlns.jcp.org/jsf/core", "viewParam")
                        .getAttribute("value"));
        assertEquals("#{changeArrivalDeadlineDate.load}",
                element(view, "http://xmlns.jcp.org/jsf/core", "viewAction")
                        .getAttribute("action"));

        Element datePicker = element(view, "http://primefaces.org/ui", "datePicker");
        assertEquals("#{changeArrivalDeadlineDate.arrivalDeadlineDate}",
                datePicker.getAttribute("value"));
        assertEquals("true", datePicker.getAttribute("required"));
        assertEquals("arrivalDeadlineDate", element(view,
                "http://primefaces.org/ui", "message").getAttribute("for"));
        assertEquals("arrivalDeadlineDate", labeledDate(view).getAttribute("for"));
    }

    private Element labeledDate(Document view) {
        NodeList labels = view.getElementsByTagNameNS("http://primefaces.org/ui", "outputLabel");
        for (int i = 0; i < labels.getLength(); i++) {
            Element label = (Element) labels.item(i);
            if ("Deadline:".equals(label.getAttribute("value"))) {
                return label;
            }
        }
        throw new AssertionError("Deadline label not found");
    }

    private Element element(Document view, String namespace, String name) {
        NodeList matches = view.getElementsByTagNameNS(namespace, name);
        assertTrue(name + " is missing", matches.getLength() > 0);
        return (Element) matches.item(0);
    }

    private Element firstElementChild(Node parent) {
        return nextElementSibling(parent.getFirstChild());
    }

    private Element nextElementSibling(Node node) {
        while (node != null && node.getNodeType() != Node.ELEMENT_NODE) {
            node = node.getNextSibling();
        }
        assertNotNull(node);
        return (Element) node;
    }
}
