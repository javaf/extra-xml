// @wolfram77
package org.data;

//required modules
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import java.util.*;
import java.io.*;



public class Xml {

    // data
    final Element elem;
    final int NODE_TYPE_ELEMENT = 1;

    
    // Xml (node)
    // - create a xml object (internal)
    private Xml(Node node) {
        this.elem = (Element) node;
    }


    // DocBuilder ()
    // - get document builder object
    private DocumentBuilder docBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder();
    }


    // Transformer ()
    // - get transformer object
    private Transformer transformer() throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        return transformer;
    }


    // Save (node, file)
    // - save xml node to file
    private void save(Node node, File file) throws Exception {
        DOMSource source = new DOMSource(node);
        StreamResult result = new StreamResult(file);
        transformer().transform(source, result);
    }


    // To String (node)
    // - converts given node to string
    private String toString(Node node) {
        try {
            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(node);
            transformer().transform(source, result);
            return result.getWriter().toString();
        }
        catch (Exception e) {}
        return null;
    }


    // To XML List (node list)
    // - convert a node list to an xml list
    private List<Xml> toXmlList(NodeList nodeList) {
        List<Xml> xmlList = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() != NODE_TYPE_ELEMENT) continue;
            xmlList.add(new Xml(node));
        }
        return xmlList;
    }


    // To String Map (node map)
    // - convert a node map to an string map
    private Map<String, String> toStringMap(NamedNodeMap nodeMap) {
        Map<String, String> strMap = new HashMap<>();
        for (int i = 0; i < nodeMap.getLength(); i++) {
            Node node = nodeMap.item(i);
            if (node.getNodeType() != NODE_TYPE_ELEMENT) continue;
            strMap.put(node.getNodeName(), node.getNodeValue());
        }
        return strMap;
    }


    // To Xml (node)
    // - convert a node to xml
    private Xml toXml(Node node) {
        return (node != null) ? new Xml(node) : null;
    }


    // Parent Elem (node, name)
    // - get an element, this or above this
    private Node parentElem(Node node, String name) {
        while(node != null) {
            String tagName = ((Element)node).getTagName();
            if(name == null || tagName.equals(name)) break;
            node = node.getParentNode();
        }
        return node;
    }


    // Prev Elem (node, name)
    // - get an element, this or before this
    private Node prevElem(Node node, String name) {
        while(node != null) {
            if(node.getNodeType() != NODE_TYPE_ELEMENT) continue;
            String tagName = ((Element)node).getTagName();
            if(name == null || tagName.equals(name)) break;
            node = node.getPreviousSibling();
        }
        return node;
    }


    // Next Elem (node, name)
    // - get an element, this or after this
    private Node nextElem(Node node, String name) {
        while(node != null) {
            if(node.getNodeType() != NODE_TYPE_ELEMENT) continue;
            String tagName = ((Element)node).getTagName();
            if(name == null || tagName.equals(name)) break;
            node = node.getNextSibling();
        }
        return node;
    }


    // Adopt (src, new)
    // - adopts a node to current document (if required)
    private Node adopt(Node src, Node _new) {
        if (src.getOwnerDocument().equals(_new.getOwnerDocument())) return _new;
        _new = _new.cloneNode(true);
        src.getOwnerDocument().adoptNode(_new);
        return _new;
    }


    // Add Prev (src, new)
    // - add a node before current node
    private void addPrev(Node src, Node _new) {
        _new = adopt(src, _new);
        src.getParentNode().insertBefore(_new, src);
    }


    // Add (src, new)
    // - add a node inside current node
    private void add(Node src, Node _new) {
        _new = adopt(src, _new);
        src.appendChild(_new);
    }


    // Xml (xml)
    // - parse an xml file
    public Xml(File xmlFile) throws Exception {
        Document doc = docBuilder().parse(xmlFile);
        elem = doc.getDocumentElement();
    }


    // Xml (xml)
    // - parse an xml string
    public Xml(String xmlStr) throws Exception {
        InputSource in = new InputSource();
        in.setCharacterStream(new StringReader(xmlStr));
        Document doc = docBuilder().parse(in);
        elem = doc.getDocumentElement();
    }


    // Equals (xml)
    // - check if 2 xml elements are equal
    public boolean equals(Xml xml) {
        return elem.isEqualNode(xml.elem);
    }

    
    // Same (xml)
    // - check if 2 xml elements are same
    public boolean same(Xml xml) {
        return elem.isSameNode(xml.elem);
    }


    // Document ()
    // - get the W3C Document
    public Document document() {
        return elem.getOwnerDocument();
    }


    // Elem ()
    // - get current W3C Element
    public Element elem() {
        return elem;
    }


    // Root ()
    // - get the root element
    public Xml root() {
        return new Xml(document().getDocumentElement());
    }


    // Parent (name)
    // get the parent element with given name
    public Xml parent(String name) {
        return toXml(parentElem(elem.getParentNode(), name));
    }


    // Parent ()
    // get the parent element
    public Xml parent() {
        return parent(null);
    }


    // Prev (name)
    // - get previous element with given name
    public Xml prev(String name) {
        return toXml(prevElem(elem.getPreviousSibling(), name));
    }


    // Prev ()
    // - get previous element
    public Xml prev() {
        return prev(null);
    }


    // Next (name)
    // - get next element with given name
    public Xml next(String name) {
        return toXml(nextElem(elem.getNextSibling(), name));
    }


    // Next ()
    // - get next element
    public Xml next() {
        return next(null);
    }


    // Child (name)
    // - get first child with given name
    public Xml child(String name) {
        return toXml(nextElem(elem.getFirstChild(), name));
    }


    // Child ()
    // - get first child
    public Xml child() {
        return child(null);
    }


    // Last Child (name)
    // - get last child with given name
    public Xml lastChild(String name) {
        return toXml(prevElem(elem.getLastChild(), name));
    }


    // Last Child ()
    // - get last child element
    public Xml lastChild() {
        return lastChild(null);
    }


    // Children ()
    // - get all children
    public List<Xml> children() {
        return toXmlList(elem.getChildNodes());
    }


    // Children (name)
    // - get all children with given name
    public List<Xml> children(String name) {
        return toXmlList(elem.getElementsByTagName(name));
    }


    // Elem (name)
    // - create a new element with given tag name
    public Xml elem(String name) {
        return new Xml(document().createElement(name));
    }


    // Clone ()
    // - clones current element to be used elsewhere
    public Xml clone() {
        return new Xml(elem.cloneNode(true));
    }


    // Add Prev (elem)
    // - adds new xml element before current (moves to new)
    public Xml addPrev(Xml elem) {
        addPrev(this.elem, elem.elem);
        return elem;
    }


    // Add Prev (elemStr)
    // - adds new xml element before current (moves to new)
    public Xml addPrev(String elemStr) {
        return addPrev(elem(elemStr));
    }


    // Add Next (elem)
    // - adds new xml element after current (moves to new)
    public Xml addNext(Xml elem) {
        addPrev(this.elem.getNextSibling(), elem.elem);
        return elem;
    }


    // Add Next (elemStr)
    // - adds new xml element after current (moves to new)
    public Xml addNext(String elemStr) {
        return addNext(elem(elemStr));
    }


    // Add (elem)
    // - adds new xml element as child (moves to new)
    public Xml add(Xml elem) {
        add(this.elem, elem.elem);
        return elem;
    }


    // Add (elemStr)
    // - adds new xml element as child (moves to new)
    public Xml add(String elemStr) {
        return add(elem(elemStr));
    }


    // Save ()
    // - saves current element to file
    public Xml save(File file) throws Exception {
        save(elem, file);
        return this;
    }


    // To String ()
    // - converts current element to string
    public String toString() {
        return toString(elem);
    }


    // Name ()
    // - get xml tag name
    public String name() {
        return elem.getTagName();
    }


    // Name (val)
    // - set xml tag name (remove if val=null)
    public Xml name(String val) {
        if (val != null) {
            document().renameNode(elem, null, val);
        } else {
            elem.getParentNode().removeChild(elem);
        }
        return this;
    }


    // Attr ()
    // - get all attributes
    public Map<String, String> attr() {
        return toStringMap(elem.getAttributes());
    }


    // Attr (name)
    // - get the value of given attribute name
    public String attr(String name) {
        return elem.getAttribute(name);
    }


    // Attr (name, val)
    // - set the value of attribute (remove if val=null)
    public Xml attr(String name, String val) {
        if (val != null) {
            elem.setAttribute(name, val);
        } else {
            elem.removeAttribute(name);
        }
        return this;
    }


    // Val ()
    // - get the content of element
    public String val() {
        return elem.getTextContent();
    }


    // Val (val)
    // - set the content of element
    public Xml val(String val) {
        elem.setTextContent(val);
        return this;
    }


    // Child Val (name)
    // - get the content of child element
    public String childVal(String name) {
        return child(name).val();
    }


    // Content (name, val)
    // - set the content of child element
    public Xml childVal(String name, String val) {
        Xml child = child(name);
        child = (child != null) ? child : add(name);
        if (val != null) {
            child.val(val);
        } else {
            child.name(null);
        }
        return this;
    }
}
