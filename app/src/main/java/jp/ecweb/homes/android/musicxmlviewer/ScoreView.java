package jp.ecweb.homes.android.musicxmlviewer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import jp.ecweb.homes.android.musicxmllib.Measure;
import jp.ecweb.homes.android.musicxmllib.MusicXMLLib;
import jp.ecweb.homes.android.musicxmllib.Note;
import jp.ecweb.homes.android.musicxmllib.Part;
import jp.ecweb.homes.android.musicxmllib.ScorePartwise;

public class ScoreView extends SurfaceView implements SurfaceHolder.Callback {

	private static final String TAG = ScoreView.class.getSimpleName();

	private ScorePartwise mScorePartwise;

	public ScoreView(Context context, SurfaceView surfaceView) {
		super(context);
		SurfaceHolder holder = surfaceView.getHolder();
		holder.addCallback(this);
	}

	public ScoreView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	void setScore(ScorePartwise scorePartwise) {
		mScorePartwise = scorePartwise;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.d(TAG, "surfaceCreated");
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		Log.d(TAG, "surfaceChanged");

		if (mScorePartwise != null) {
			try {
				for (Part part : mScorePartwise.getPartList()) {
					for (Measure measure : part.getMeasureList()) {
						Canvas canvas = holder.lockCanvas();

						DrawMeasure drawMeasure = new DrawMeasure();
						drawMeasure.setMeasure(measure);
						drawMeasure.draw(canvas);

						for (Note note : measure.getNoteList()) {
							DrawNote drawNote = new DrawNote();
							drawNote.setNote(note);
							drawNote.draw(canvas);
						}

						holder.unlockCanvasAndPost(canvas);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(TAG, "surfaceDestroyed");
	}


}
