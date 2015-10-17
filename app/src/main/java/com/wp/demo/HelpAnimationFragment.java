package com.wp.demo;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2015/10/17.
 */
public class HelpAnimationFragment extends Fragment {
    private final static String EXTRA_DETAIL_JSON = "extra_detail_json";

    private HelpAnimationView mHelpAnimationView;
    private OnHelpPagerViewTouchListener mListener;

    public HelpAnimationFragment() {
    }

    public static HelpAnimationFragment newInstance(HelpPagerDetail helpPagerDetail,
                                                    OnHelpPagerViewTouchListener callback) {
        HelpAnimationFragment f = new HelpAnimationFragment();
        f.mListener = callback;
        String toJson = new Gson().toJson(helpPagerDetail);
        Bundle b = new Bundle(1);
        b.putString(EXTRA_DETAIL_JSON, toJson);
        f.setArguments(b);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.help_animation_fragment_layout, null);
        mHelpAnimationView = (HelpAnimationView) v.findViewById(R.id.help_view);
        mHelpAnimationView.setOnNextHelpViewListener(mListener);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String fromJson = getArguments().getString(EXTRA_DETAIL_JSON);
        HelpPagerDetail helpPagerDetail = new Gson().fromJson(fromJson, HelpPagerDetail.class);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            mHelpAnimationView.setBackground(getResources().getDrawable(helpPagerDetail.backgroundResId));
        } else {
            mHelpAnimationView.setBackgroundResource(helpPagerDetail.backgroundResId);
        }
    }
}
