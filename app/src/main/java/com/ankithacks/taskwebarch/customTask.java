package com.ankithacks.taskwebarch;

/**
 * Created by DellSe on 19-03-2017.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class customTask extends View {
    private Rect myRect;
    private Paint myPaint,paint;
    private static final int SQUARE_SIDE_LENGTH =   200;

    public customTask(Context context) {
        super(context);
        myRect = new Rect(30, 30, SQUARE_SIDE_LENGTH, SQUARE_SIDE_LENGTH);
        myPaint = new Paint();
        myPaint.setColor(Color.MAGENTA);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(100);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawRGB(77, 255, 77);
        canvas.drawRect(myRect, myPaint);
        canvas.drawText("Move it, Around !!", 150, 1730, paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if((int) event.getX()> myRect.left && (int) event.getX()<myRect.right&& (int) event.getY()> myRect.top && (int) event.getY()<myRect.bottom) {

            myRect.left = (int) event.getX() - (SQUARE_SIDE_LENGTH / 2);
            myRect.top = (int) event.getY() - (SQUARE_SIDE_LENGTH / 2);
            myRect.right = myRect.left + SQUARE_SIDE_LENGTH;
            myRect.bottom = myRect.top + SQUARE_SIDE_LENGTH;
        }

        invalidate();
        return true; // Indicates that a touch event was handled.
    }

}
