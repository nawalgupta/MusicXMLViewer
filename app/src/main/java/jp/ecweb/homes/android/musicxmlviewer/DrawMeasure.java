package jp.ecweb.homes.android.musicxmlviewer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import jp.ecweb.homes.android.musicxmllib.Measure;

class DrawMeasure {

	private Measure mMeasure;

	void setMeasure(Measure measure) {
		this.mMeasure = measure;
	}

	void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setStyle(Paint.Style.STROKE);

		canvas.drawRect(0, 0, mMeasure.getWidth(), 200, paint);
	}
}
