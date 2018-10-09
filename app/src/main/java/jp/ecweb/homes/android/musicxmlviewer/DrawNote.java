package jp.ecweb.homes.android.musicxmlviewer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import jp.ecweb.homes.android.musicxmllib.Note;

public class DrawNote {

	private Note mNote;

	void setNote(Note note) {
		this.mNote = note;
	}

	void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.STROKE);

		canvas.drawRect(mNote.getDefaultX(), 0, mNote.getDefaultX() + 20, 100, paint);
	}
}
