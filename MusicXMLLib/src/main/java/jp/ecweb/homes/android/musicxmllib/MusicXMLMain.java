package jp.ecweb.homes.android.musicxmllib;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
					mScorePartwise = new ScorePartwise(attributes);
					mLogger.log(Level.INFO, "ScorePartwise version : " + mScorePartwise.getVersion());
					break;
				case TAG_PART:
					Part part = new Part(attributes);
					mScorePartwise.addPart(part);
					mLogger.log(Level.INFO, "part id : " + part.getId());

					currentPart = part;
					break;
				case TAG_MEASURE:
					Measure measure = new Measure(attributes);
					currentPart.addMeasure(measure);
					mLogger.log(Level.INFO, "measure number : " + measure.getNumber());

					currentMeasure = measure;
					break;
				case TAG_NOTE:
					Note note = new Note(attributes);
					currentMeasure.addNote(note);
					mLogger.log(Level.INFO, "note number : " + measure.getNumber());

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
