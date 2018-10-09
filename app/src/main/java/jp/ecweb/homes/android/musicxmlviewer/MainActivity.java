package jp.ecweb.homes.android.musicxmlviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;

import jp.ecweb.homes.android.musicxmllib.Measure;
import jp.ecweb.homes.android.musicxmllib.MusicXMLLib;
import jp.ecweb.homes.android.musicxmllib.Part;
import jp.ecweb.homes.android.musicxmllib.ScorePartwise;

public class MainActivity extends AppCompatActivity {

	private String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SurfaceView surfaceView = findViewById(R.id.scoreView);
		ScoreView scoreView = new ScoreView(this, surfaceView);

		try {
			MusicXMLLib musicXMLLib
					= new MusicXMLLib(getResources().openRawResource(R.raw.chant));
			ScorePartwise scorePartwise = musicXMLLib.getScorePartwise();
			scoreView.setScore(scorePartwise);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
