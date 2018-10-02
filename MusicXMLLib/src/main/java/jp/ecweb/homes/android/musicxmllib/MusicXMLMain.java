package jp.ecweb.homes.android.musicxmllib;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static jp.ecweb.homes.android.musicxmllib.Const.TAG_MEASURE;
import static jp.ecweb.homes.android.musicxmllib.Const.TAG_PART;

class MusicXMLMain {

	private Document mDocument;

	MusicXMLMain(InputStream xml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		mDocument = builder.parse(xml);
	}

	List<Part> getPartList() {
		List<Part> result = new ArrayList<>();

		NodeList nodeList = mDocument.getElementsByTagName(TAG_PART);

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			Part part = new Part(node);
			result.add(part);
		}

		return result;
	}

	List<Measure> getMeasureList() {
		List<Measure> result = new ArrayList<>();

		NodeList nodeList = mDocument.getElementsByTagName(TAG_MEASURE);

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			Measure measure = new Measure(node);
			result.add(measure);
		}

		return result;
	}
}
