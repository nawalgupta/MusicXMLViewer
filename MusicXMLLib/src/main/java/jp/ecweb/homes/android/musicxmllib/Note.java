package jp.ecweb.homes.android.musicxmllib;

import org.xml.sax.Attributes;

import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_DEFAULT_X;

public class Note extends Element {

	public Note() {
		super();
	}

	public Note(Attributes attributes) {
		super(attributes);
	}

	public int getDefaultX() {
		return tenthsToInt(getAttributeInt(ATTR_NOTE_DEFAULT_X));
	}
}
