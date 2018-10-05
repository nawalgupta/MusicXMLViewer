package jp.ecweb.homes.android.musicxmllib;


import org.xml.sax.Attributes;

import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_VERSION;

public class ScorePartwise {

	private String version = "";

	public ScorePartwise(String version) {
		this.version = version;
	}

	ScorePartwise(Attributes attributes) {
		String attrValue = attributes.getValue(ATTR_VERSION);
		if (attrValue != null) {
			this.version = attrValue;
		}
	}

	// region Attributes

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	// region end
}
