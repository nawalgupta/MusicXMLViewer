package jp.ecweb.homes.android.musicxmllib;

import org.xml.sax.Attributes;

import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_DEFAULT_X;

public class Note extends Element {

	// Attributes
	private Integer defaultX;
	private Integer defaultY;
	private Integer relativeX;
	private Integer relativeY;
	private String[] fontFamily;
	private String fontStyle;
	private String fontSize;
	private String fontWeight;
	private String color;
	private String printObject;
	private String printDot;
	private String printSpacing;
	private String printLyric;
	private Integer dynamics;
	private Integer endDynamics;
	private Integer attack;
	private Integer release;
	private String timeOnly;
	private String pizzicato;

	// Child Elements

	public Note() {
		super();
	}


	// region Attributes

	public Integer getDefaultX() {
		return defaultX;
	}

	public void setDefaultX(Integer defaultX) {
		this.defaultX = defaultX;
	}

	void setDefaultX(String defaultX) {
		try {
			setDefaultX(Integer.valueOf(defaultX));
		} catch (NumberFormatException e) {
			this.defaultX = null;
		}
	}

	public Integer getDefaultY() {
		return defaultY;
	}

	public void setDefaultY(Integer defaultY) {
		this.defaultY = defaultY;
	}

	void setDefaultY(String defaultY) {
		try {
			setDefaultY(Integer.valueOf(defaultY));
		} catch (NumberFormatException e) {
			this.defaultY = null;
		}
	}

	public Integer getRelativeX() {
		return relativeX;
	}

	public void setRelativeX(Integer relativeX) {
		this.relativeX = relativeX;
	}

	void setRelativeX(String relativeX) {
		try {
			setRelativeX(Integer.valueOf(relativeX));
		} catch (NumberFormatException e) {
			this.relativeX = null;
		}
	}

	public Integer getRelativeY() {
		return relativeY;
	}

	public void setRelativeY(Integer relativeY) {
		this.relativeY = relativeY;
	}

	void setRelativeY(String relativeY) {
		try {
			setRelativeY(Integer.valueOf(relativeY));
		} catch (NumberFormatException e) {
			this.relativeY = null;
		}
	}

	public String[] getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		try {
			this.fontFamily = fontFamily.split(",");
		} catch (Exception e) {
			this.fontFamily = null;
		}
	}

	public String getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public String getFontWeight() {
		return fontWeight;
	}

	public void setFontWeight(String fontWeight) {
		this.fontWeight = fontWeight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPrintObject() {
		return printObject;
	}

	public void setPrintObject(String printObject) {
		this.printObject = printObject;
	}

	public String getPrintDot() {
		return printDot;
	}

	public void setPrintDot(String printDot) {
		this.printDot = printDot;
	}

	public String getPrintSpacing() {
		return printSpacing;
	}

	public void setPrintSpacing(String printSpacing) {
		this.printSpacing = printSpacing;
	}

	public String getPrintLyric() {
		return printLyric;
	}

	public void setPrintLyric(String printLyric) {
		this.printLyric = printLyric;
	}

	public Integer getDynamics() {
		return dynamics;
	}

	public void setDynamics(Integer dynamics) {
		this.dynamics = dynamics;
	}

	void setDynamics(String dynamics) {
		try {
			setDynamics(Integer.valueOf(dynamics));
		} catch (NumberFormatException e) {
			this.dynamics = null;
		}
	}

	public Integer getEndDynamics() {
		return endDynamics;
	}

	public void setEndDynamics(Integer endDynamics) {
		this.endDynamics = endDynamics;
	}

	void setEndDynamics(String endDynamics) {
		try {
			setEndDynamics(Integer.valueOf(endDynamics));
		} catch (NumberFormatException e) {
			this.endDynamics = null;
		}
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	void setAttack(String attack) {
		try {
			setAttack(Integer.valueOf(attack));
		} catch (NumberFormatException e) {
			this.attack = null;
		}
	}

	public Integer getRelease() {
		return release;
	}

	public void setRelease(Integer release) {
		this.release = release;
	}

	void setRelease(String release) {
		try {
			setRelease(Integer.valueOf(release));
		} catch (NumberFormatException e) {
			this.release = null;
		}
	}

	public String getTimeOnly() {
		return timeOnly;
	}

	public void setTimeOnly(String timeOnly) {
		this.timeOnly = timeOnly;
	}

	public String getPizzicato() {
		return pizzicato;
	}

	public void setPizzicato(String pizzicato) {
		this.pizzicato = pizzicato;
	}


	// endregion


}
