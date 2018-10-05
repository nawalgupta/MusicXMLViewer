package jp.ecweb.homes.android.musicxmllib;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static jp.ecweb.homes.android.musicxmllib.Const.TAG_MEASURE;
import static jp.ecweb.homes.android.musicxmllib.Const.TAG_PART;
import static jp.ecweb.homes.android.musicxmllib.Const.TAG_SCORE_PARTWISE;

class MusicXMLMain {

	private Logger mLogger;
	private Document mDocument;
	private ScorePartwise mScorePartwise;

	MusicXMLMain(InputStream xml) throws Exception {
		mLogger = Logger.getLogger(MusicXMLMain.class.getSimpleName());

//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = factory.newDocumentBuilder();
//		mDocument = builder.parse(xml);

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		saxParser.parse(xml, new MusicXMLParseHandler());
	}

	private class MusicXMLParseHandler extends DefaultHandler {
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			mLogger.log(Level.INFO, "MusicXML parse start");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			mLogger.log(Level.INFO, "Finde element : " + qName);

			switch (qName) {
				case TAG_SCORE_PARTWISE:
					mScorePartwise = new ScorePartwise(attributes);
					mLogger.log(Level.INFO, "version : " + mScorePartwise.getVersion());
					break;
				case TAG_PART:
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

//	List<Part> getPartList() {
//		List<Part> result = new ArrayList<>();
//
//		NodeList nodeList = mDocument.getElementsByTagName(TAG_PART);
//
//		for (int i = 0; i < nodeList.getLength(); i++) {
//			Node node = nodeList.item(i);
//			Part part = new Part(node);
//			result.add(part);
//		}
//
//		return result;
//	}
//
//	List<Measure> getMeasureList() {
//		List<Measure> result = new ArrayList<>();
//
//		NodeList nodeList = mDocument.getElementsByTagName(TAG_MEASURE);
//
//		for (int i = 0; i < nodeList.getLength(); i++) {
//			Node node = nodeList.item(i);
//			Measure measure = new Measure(node);
//			result.add(measure);
//		}
//
//		return result;
//	}
}
