package com.WhiteDessert.GraduateReference.Views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by yazeed on 12/04/14.
 */
public class UnderLineTextView extends TextView {


    private final Paint mPaint = new Paint();
    private int mUnderlineHeight = 0;
    public UnderLineTextView(Context context) {
        this(context, null);
    }

    public UnderLineTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UnderLineTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        Resources r = getResources();
        assert r != null;
        mUnderlineHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, r.getDisplayMetrics());
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom + mUnderlineHeight);
    }

    @Override
    protected void onDraw(@SuppressWarnings("NullableProblems") Canvas canvas) {
        super.onDraw(canvas);

        // Draw the underline the same color as the text
        //noinspection ConstantConditions
        mPaint.setColor(getTextColors().getDefaultColor());
        canvas.drawRect(0, getHeight() - mUnderlineHeight, getWidth(), getHeight(), mPaint);
    }

}
