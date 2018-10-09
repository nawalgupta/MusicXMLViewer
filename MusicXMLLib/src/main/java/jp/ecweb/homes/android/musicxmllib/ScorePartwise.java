package jp.ecweb.homes.android.musicxmllib;


import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_SCORE_PARTWISE_VERSION;

public class ScorePartwise {

	// Attributes
	private String version;
	// Child Elements
	private Map<String, Part> part = new HashMap<>();


//	public ScorePartwise(String version) {
//		this.version = version;
//	}

//	ScorePartwise(Attributes attributes) {
//		String attrValue = attributes.getValue(ATTR_SCORE_PARTWISE_VERSION);
//		if (attrValue != null) {
//			this.version = attrValue;
//		}
//	}

	// region Attributes

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	// endregion

	// region Child Elements

	Map<String, Part> getPartMap() {
		return this.part;
	}

	public Part getPart(String id) {
		if (this.part.containsKey(id)) {
			return this.part.get(id);
		} else {
			return null;
		}
	}

	public void addPart(Part part) {
		this.part.put(part.getId(), part);
	}

	public List<Part> getPartList() {
		return new ArrayList<>(this.part.values());
	}

	// endregion
}
