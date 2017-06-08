package com.evaluation.karthika.sampleboxes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by karthika on 6/8/2017.
 */
public class CustomView extends View {

    private Rect rectangle;
    private Paint paint;
    int mrow, mcolumn, mremaining, n;

    public CustomView(Context context, int number) {
        super(context);
        int x = 50;
        int y = 50;
        int sideLength = 200;
        n = number;
        if (n % 2 == 1) {
            mcolumn = 2;
            mrow = n / mcolumn;
            mremaining = 1;
        } else {
            mcolumn = 2;
            mrow = n / mcolumn;
            mremaining = 0;
        }

        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int left = 50; // initial start position of rectangles (50 pixels from left)
        int top = 50; // 50 pixels from the top
        int width = 300;
        int height = 300;
        for (int row = 0; row < mrow; row++) {
            for (int col = 0; col < mcolumn; col++) {

                canvas.drawRect(left, top, left + width, top + height, paint);
                left = (left + width + 50); // set new left co-ordinate + 50 pixel gap

            }
            left = 50;
            top = top + height + 30; // move to new row by changing the top co-ordinate
        }
        if (mremaining == 1)
            canvas.drawRect(left, top, left + width, top + height, paint);

    }

}
