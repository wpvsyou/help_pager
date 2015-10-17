package com.wp.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2015/10/17.
 */
public class HelpAnimationView extends View {
    private OnHelpPagerViewTouchListener mListener;

    public HelpAnimationView(Context context) {
        super(context);
    }

    public HelpAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HelpAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnNextHelpViewListener(OnHelpPagerViewTouchListener onHelpPagerViewTouchListener) {
        mListener = onHelpPagerViewTouchListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX(0);
        float eventY = event.getY(0);
        Log.d("WWW", "view onTouchEvent x= " + eventX + " y=" + eventY);
        mListener.onHelpPagerViewTouch(eventX, eventY);
        return super.onTouchEvent(event);
    }
}
