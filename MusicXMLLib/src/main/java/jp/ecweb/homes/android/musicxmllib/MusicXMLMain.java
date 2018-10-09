package jp.ecweb.homes.android.musicxmllib;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_MEASURE_IMPLICIT;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_MEASURE_NONCONTROLLING;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_MEASURE_NUMBER;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_MEASURE_WIDTH;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_ATTACK;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_COLOR;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_DEFAULT_X;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_DEFAULT_Y;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_DYNAMICS;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_END_DYNAMICS;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_FONT_FAMILY;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_FONT_SIZE;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_FONT_STYLE;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_FONT_WEIGHT;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_PIZZICATO;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_PRINT_DOT;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_PRINT_LYRIC;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_PRINT_OBJECT;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_PRINT_SPACING;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_RELATIVE_X;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_RELATIVE_Y;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_RELEASE;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_NOTE_TIME_ONLY;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_PART_ID;
import static jp.ecweb.homes.android.musicxmllib.Const.ATTR_SCORE_PARTWISE_VERSION;
import static jp.ecweb.homes.android.musicxmllib.Const.TAG_MEASURE;
import static jp.ecweb.homes.android.musicxmllib.Const.TAG_NOTE;
import static jp.ecweb.homes.android.musicxmllib.Const.TAG_PART;
import static jp.ecweb.homes.android.musicxmllib.Const.TAG_SCORE_PARTWISE;

class MusicXMLMain {

	private Logger mLogger;
	private ScorePartwise mScorePartwise;

	MusicXMLMain(InputStream xml) throws Exception {
		mLogger = Logger.getLogger(MusicXMLMain.class.getSimpleName());

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		saxParser.parse(xml, new MusicXMLParseHandler());
	}

	ScorePartwise getScorePartwise() {
		return this.mScorePartwise;
	}


	private class MusicXMLParseHandler extends DefaultHandler {
		private Part currentPart;
		private Measure currentMeasure;

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			mLogger.log(Level.INFO, "MusicXML parse start");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			super.startElement(uri, localName, qName, attributes);
//			mLogger.log(Level.INFO, "Find element : " + qName);

			switch (qName) {
				case TAG_SCORE_PARTWISE:
					mScorePartwise = new ScorePartwise();
					mScorePartwise.setVersion(attributes.getValue(ATTR_SCORE_PARTWISE_VERSION));
					mLogger.log(Level.INFO, "ScorePartwise version : " + mScorePartwise.getVersion());
					break;
				case TAG_PART:
					Part part = new Part();
					part.setId(attributes.getValue(ATTR_PART_ID));
					mScorePartwise.addPart(part);
					mLogger.log(Level.INFO, "part id : " + part.getId());

					currentPart = part;
					break;
				case TAG_MEASURE:
					Measure measure = new Measure();
					measure.setNumber(attributes.getValue(ATTR_MEASURE_NUMBER));
					measure.setImplicit(attributes.getValue(ATTR_MEASURE_IMPLICIT));
					measure.setNonControlling(attributes.getValue(ATTR_MEASURE_NONCONTROLLING));
					measure.setWidth(attributes.getValue(ATTR_MEASURE_WIDTH));

					currentPart.addMeasure(measure);
					mLogger.log(Level.INFO, "measure number : " + measure.getNumber());
					mLogger.log(Level.INFO, "measure implicit : " + measure.getImplicit());
					mLogger.log(Level.INFO, "measure non-controlling : " + measure.getNonControlling());
					mLogger.log(Level.INFO, "measure width : " + measure.getWidth());

					currentMeasure = measure;
					break;
				case TAG_NOTE:
					Note note = new Note();

					note.setDefaultX(attributes.getValue(ATTR_NOTE_DEFAULT_X));
					note.setDefaultY(attributes.getValue(ATTR_NOTE_DEFAULT_Y));
					note.setRelativeX(attributes.getValue(ATTR_NOTE_RELATIVE_X));
					note.setRelativeY(attributes.getValue(ATTR_NOTE_RELATIVE_Y));
					note.setFontFamily(attributes.getValue(ATTR_NOTE_FONT_FAMILY));
					note.setFontStyle(attributes.getValue(ATTR_NOTE_FONT_STYLE));
					note.setFontSize(attributes.getValue(ATTR_NOTE_FONT_SIZE));
					note.setFontWeight(attributes.getValue(ATTR_NOTE_FONT_WEIGHT));
					note.setColor(attributes.getValue(ATTR_NOTE_COLOR));
					note.setPrintObject(attributes.getValue(ATTR_NOTE_PRINT_OBJECT));
					note.setPrintDot(attributes.getValue(ATTR_NOTE_PRINT_DOT));
					note.setPrintSpacing(attributes.getValue(ATTR_NOTE_PRINT_SPACING));
					note.setPrintLyric(attributes.getValue(ATTR_NOTE_PRINT_LYRIC));
					note.setDynamics(attributes.getValue(ATTR_NOTE_DYNAMICS));
					note.setEndDynamics(attributes.getValue(ATTR_NOTE_END_DYNAMICS));
					note.setAttack(attributes.getValue(ATTR_NOTE_ATTACK));
					note.setRelease(attributes.getValue(ATTR_NOTE_RELEASE));
					note.setTimeOnly(attributes.getValue(ATTR_NOTE_TIME_ONLY));
					note.setPizzicato(attributes.getValue(ATTR_NOTE_PIZZICATO));

					currentMeasure.addNote(note);
					mLogger.log(Level.INFO, "note default-x : " + note.getDefaultX());

					break;
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			super.endElement(uri, localName, qName);
		}

		@Override
		public void endDocument() throws SAXException {
			super.endDocument();
			mLogger.log(Level.INFO, "MusicXML parse end");
		}
	}
}
