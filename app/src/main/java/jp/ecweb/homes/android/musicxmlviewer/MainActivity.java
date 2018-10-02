package jp.ecweb.homes.android.musicxmlviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import jp.ecweb.homes.android.musicxmllib.MusicXMLLib;
import jp.ecweb.homes.android.musicxmllib.Part;

public class MainActivity extends AppCompatActivity {

	private String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			MusicXMLLib musicXMLLib
					= new MusicXMLLib(getResources().openRawResource(R.raw.chant));

			for (Part part : musicXMLLib.getPartlist()) {
				Log.d(TAG, "part id = " + part.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
