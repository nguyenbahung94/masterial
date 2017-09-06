package com.example.tablayoutswipescrolltabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nbhung on 9/5/2017.
 */

public class FragmentViewPager extends Fragment {
    private static final java.lang.String ARG_PAGE = "arg_age";
    private TextView tvShow;

    public static FragmentViewPager newInstance(int pageNumber) {
        FragmentViewPager fragmentViewPager = new FragmentViewPager();
        Bundle argument = new Bundle();
        argument.putInt(ARG_PAGE, pageNumber);
        fragmentViewPager.setArguments(argument);
        return fragmentViewPager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        Bundle agrument = getArguments();
        int agePage = agrument.getInt(ARG_PAGE);
        tvShow = (TextView) view.findViewById(R.id.tvShow);
        String page = "this is page " + agePage;
        tvShow.setText(page);
        return view;
    }
}
