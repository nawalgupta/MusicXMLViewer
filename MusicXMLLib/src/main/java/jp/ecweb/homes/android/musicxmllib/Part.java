package jp.ecweb.homes.android.musicxmllib;

import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.Map;

import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_PART_ID;

public class Part extends Element {

	// Child Elements
	private Map<String, Measure> measure = new HashMap<>();

	public Part() {
		super();
	}

	Part(Attributes attributes) {
		super(attributes);
	}

	// region Attributes

	public String getId() {
		return getAttributeString(ATTR_PART_ID);
	}

	// endregion

	// region Child Elements

	public void addMeasure(Measure measure) {
		this.measure.put(measure.getNumber(), measure);
	}

	public Measure getMeasure(String number) {
		return this.measure.get(number);
	}

	// endregion
}
