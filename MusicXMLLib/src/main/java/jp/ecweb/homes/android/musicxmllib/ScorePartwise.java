package jp.ecweb.homes.android.musicxmllib;


import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.Map;

import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_SCORE_PARTWISE_VERSION;

public class ScorePartwise {

	// Attributes
	private String version = "";
	// Child Elements
	private Map<String, Part> part = new HashMap<>();


	public ScorePartwise(String version) {
		this.version = version;
	}

	ScorePartwise(Attributes attributes) {
		String attrValue = attributes.getValue(ATTR_SCORE_PARTWISE_VERSION);
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

	// endregion

	// region Child Elements

	public Map<String, Part> getPart() {
		return part;
	}

	public void addPart(Part part) {
		this.part.put(part.getId(), part);
	}

	// endregion
}
