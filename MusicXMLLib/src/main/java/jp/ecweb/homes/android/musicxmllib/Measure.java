package jp.ecweb.homes.android.musicxmllib;

import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.List;

import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_MEASURE_IMPLICIT;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_MEASURE_NONCONTROLLING;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_MEASURE_NUMBER;

public class Measure extends Element {

	// Child Elements
	// TODO 未実装エレメント
	// attributes
	// backup
	// barline
	// bookmark
	// direction
	// figured-bass
	// forward
	// grouping
	// harmony
	// link
	// note
	private List<Note> note = new ArrayList<>();
	// print
	// sound

	public Measure() {
		super();
	}

	Measure(Attributes attributes) {
		super(attributes);
	}

	// region Attributes

	public String getNumber() {
		return getAttributeString(ATTR_MEASURE_NUMBER);
	}

	public String getImplicit() {
		return getAttributeString(ATTR_MEASURE_IMPLICIT);
	}

	public String getNonControlling() {
		return getAttributeString(ATTR_MEASURE_NONCONTROLLING);
	}

	// endregion

	// region Child Elements

	public void addNote(Note note) {
		this.note.add(note);
	}

	// endregion

}
