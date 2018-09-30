package jp.ecweb.homes.android.musicxmllib;

import org.w3c.dom.Document;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MusicXMLLib {

	private Document mDocument;

	public MusicXMLLib(File xmlFile) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		mDocument = builder.parse(xmlFile);
	}
}
