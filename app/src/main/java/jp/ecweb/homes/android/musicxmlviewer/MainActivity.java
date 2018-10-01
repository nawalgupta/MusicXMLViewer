package jp.ecweb.homes.android.musicxmlviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jp.ecweb.homes.android.musicxmllib.MusicXMLLib;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			MusicXMLLib musicXMLLib
					= new MusicXMLLib(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
