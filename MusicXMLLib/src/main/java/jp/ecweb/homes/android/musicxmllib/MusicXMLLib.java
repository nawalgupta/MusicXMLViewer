package jp.ecweb.homes.android.musicxmllib;

import java.io.InputStream;
import java.util.List;

public class MusicXMLLib {

	private MusicXMLMain mMusicXMLMain;

	public MusicXMLLib(InputStream xml) throws Exception {
		mMusicXMLMain = new MusicXMLMain(xml);
	}

	public ScorePartwise getScorePartwise() {
		return mMusicXMLMain.getScorePartwise();
	}

//	public List<Part> getPartlist() {
//		return mMusicXMLMain.getPartList();
//	}
//
//	public List<Measure> getMeasureList() {
//		return mMusicXMLMain.getMeasureList();
//	}
}
