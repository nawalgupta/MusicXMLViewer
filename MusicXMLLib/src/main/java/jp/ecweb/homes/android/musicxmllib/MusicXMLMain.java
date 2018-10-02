package jp.ecweb.homes.android.musicxmllib;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class MusicXMLMain {

	private Document mDocument;

	MusicXMLMain(InputStream xml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		mDocument = builder.parse(xml);
	}

	List<Measure> getMeasureList() {
		List<Measure> result = new ArrayList<>();

		NodeList nodeList = mDocument.getElementsByTagName("measure");

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
		}

		return result;
	}
}
