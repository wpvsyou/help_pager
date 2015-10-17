package com.wp.demo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/17.
 */
public class HelpPagerViewFrameLayout extends FrameLayout implements OnHelpPagerViewTouchListener {
    private final static String TAG = "HelpPagerViewFrameLayout";

    private List<HelpPagerDetail> mDate = new ArrayList<>();
    private int mPosition = 0;
    private OnHelpAnimationFinishListener mCallback;
    private Context mContext;

    public HelpPagerViewFrameLayout(Context context) {
        super(context);
        init(context);
    }

    public HelpPagerViewFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HelpPagerViewFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context ctx) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        inflater.inflate(R.layout.help_pager_frame_layout, null);
        mContext = ctx;
    }

    public void setHelpPagerDetails(List<HelpPagerDetail> date) {
        mDate = date;
    }

    public void setOnHelpAnimationFinishListener(OnHelpAnimationFinishListener onHelpAnimationFinishListener) {
        mCallback = onHelpAnimationFinishListener;
    }

    public void start() throws HelpPagerDataNullException {
        if (mDate.isEmpty()) {
            throw new HelpPagerDataNullException("Error: before show help " +
                    "page you must set the help page show data use method setHelpPagerDetails!");
        }

        updateFragment(0);
    }

    private void showNextView() {
        if (mPosition == mDate.size() - 1) {
            mCallback.onHelpAnimationFinish();
            return;
        }
        updateFragment(++ mPosition);
    }

    private void updateFragment(int position) {
        HelpPagerDetail helpPagerDetail = mDate.get(position);
        FragmentManager fragmentManager = ((Activity) mContext).getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment f = HelpAnimationFragment.newInstance(helpPagerDetail, this);
        ft.replace(R.id.container, f, TAG);
        ft.addToBackStack(TAG);
        ft.commit();
    }

    @Override
    public void onHelpPagerViewTouch(float x, float y) {
        HelpPagerDetail helpPagerDetail = mDate.get(mPosition);
        if (checkTouchedOnNextButtonView((int) x, (int) y, helpPagerDetail)) {
            showNextView();
        }
    }

    private boolean checkTouchedOnNextButtonView(int x, int y, HelpPagerDetail helpPagerDetail) {
        int width = this.getWidth();
        int height = this.getHeight();
        double touchX = x / width;
        double touchY = y / height;
        return touchX >= helpPagerDetail.getNextButtonTopLifePoint().pointX &&
                touchX <= helpPagerDetail.getNextButtonTopRightPoint().pointX &&
                touchY >= helpPagerDetail.getNextButtonTopLifePoint().pointY &&
                touchY <= helpPagerDetail.getNextButtonBottomLifePoint().pointY;
    }

    class HelpPagerDataNullException extends Exception {

        public HelpPagerDataNullException(String detailMessage) {
            super(detailMessage);
        }
    }
}

