package jp.ecweb.homes.android.musicxmllib;

import org.w3c.dom.Node;

public class Part {

	private Node elementNode;

	Part(Node node) {
		this.elementNode = node;
	}

	public String getId() {
		Node node = elementNode.getAttributes().getNamedItem("id");
		return node.getNodeValue();
	}
}
