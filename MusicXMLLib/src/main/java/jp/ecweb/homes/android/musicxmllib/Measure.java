package jp.ecweb.homes.android.musicxmllib;

import java.util.ArrayList;
import java.util.List;

public class Measure extends Element {

	// Attributes
	private String number;
	private String implicit;
	private String nonControlling;
	private Integer width;

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

	// region Attributes

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getImplicit() {
		return implicit;
	}

	public void setImplicit(String implicit) {
		this.implicit = implicit;
	}

	public String getNonControlling() {
		return nonControlling;
	}

	public void setNonControlling(String nonControlling) {
		this.nonControlling = nonControlling;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setWidth(String width) {
		try {
			setWidth(Integer.valueOf(width));
		} catch (NumberFormatException e) {
			this.width = null;
		}
	}

	// endregion

	// region Child Elements

	public void addNote(Note note) {
		this.note.add(note);
	}

	public List<Note> getNoteList() {
		return note;
	}

	// endregion

}
