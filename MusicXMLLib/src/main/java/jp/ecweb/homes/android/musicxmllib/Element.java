package jp.ecweb.homes.android.musicxmllib;

import org.w3c.dom.Node;

class Element {

	private Node elementNode;

	Element(Node node) {
		this.elementNode = node;
	}

	String getAttributeValue(String name) {
		Node node = elementNode.getAttributes().getNamedItem(name);
		return node.getNodeValue();
	}
}
