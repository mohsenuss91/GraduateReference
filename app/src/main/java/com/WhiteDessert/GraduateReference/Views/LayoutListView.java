package com.WhiteDessert.GraduateReference.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * Created by yazeed44 on 26/04/14.
 */
public class LayoutListView extends ListView {

    private int height = -1;

    public LayoutListView(Context context) {
        super(context);
    }

    public LayoutListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View v = getChildAt(getChildCount() - 1);
        if (v != null && height > 0 && changed && ((bottom - top) < height)) {
            int b = height - v.getTop();
            final int scrollTo = getLastVisiblePosition();
            super.onLayout(changed, left, top, right, bottom);
            final int offset = (bottom - top) - b;
            post(new Runnable() {
                @Override
                public void run() {
                    try {
                        setSelectionFromTop(scrollTo, offset - getPaddingTop());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            try {
                super.onLayout(changed, left, top, right, bottom);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        height = (bottom - top);
    }
}
