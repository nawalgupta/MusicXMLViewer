package jp.ecweb.homes.android.musicxmllib;

import org.xml.sax.Attributes;

class Element {

	private Attributes mAttributes;


	public Element() {
	}

	Element(Attributes attributes) {
		this.mAttributes = attributes;
	}


	boolean containsKey(String key) {
		String attrValue = mAttributes.getValue(key);
		return attrValue != null;
	}

	String getAttributeString(String key) {
		return mAttributes.getValue(key);
	}

	int getAttributeInt(String key) {
		String attrValue = mAttributes.getValue(key);
		if (attrValue != null) {
			return Integer.parseInt(attrValue);
		} else {
			// todo 例外スロー
			return -1;
		}
	}

	int tenthsToInt(int tenths) {
		return tenths * 10;
	}
}
