package jp.ecweb.homes.android.musicxmllib;

import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_PART_ID;

public class Part extends Element {

	// Attributes
	private String id;

	// Child Elements
	private Map<String, Measure> measure = new HashMap<>();

	public Part() {
		super();
	}

//	Part(Attributes attributes) {
//		super(attributes);
//	}

	// region Attributes

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public String getId() {
//		return getAttributeString(ATTR_PART_ID);
//	}

	// endregion

	// region Child Elements

	Map<String, Measure> getMeasuerMap() {
		return this.measure;
	}

	public Measure getMeasure(String number) {
		if (this.measure.containsKey(number)) {
			return this.measure.get(number);
		} else {
			return null;
		}
	}

	public void addMeasure(Measure measure) {
		this.measure.put(measure.getNumber(), measure);
	}

	public List<Measure> getMeasureList() {
		return new ArrayList<>(this.measure.values());
	}

	// endregion
}
