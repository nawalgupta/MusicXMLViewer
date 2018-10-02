package jp.ecweb.homes.android.musicxmllib;

import org.w3c.dom.Node;

import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_ID;

public class Part extends Element {

	Part(Node node) {
		super(node);
	}

	public String getId() {
		return getAttributeValue(ATTR_ID);
	}
}
