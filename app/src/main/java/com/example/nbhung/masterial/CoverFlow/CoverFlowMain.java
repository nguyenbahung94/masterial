package com.example.nbhung.masterial.CoverFlow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.nbhung.masterial.R;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/**
 * Created by nbhung on 8/15/2017.
 */

public class CoverFlowMain extends AppCompatActivity {
    private FeatureCoverFlow mFeatureCoverFlow;
    private MovieAdapter movieAdapter;
    private List<Movie> movieList = new ArrayList<>();
    private TextSwitcher mTextSwitcher;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cover_flow_activity);
        initData();
        mTextSwitcher = (TextSwitcher) findViewById(R.id.title);
        mTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(CoverFlowMain.this);
                TextView txt = (TextView) inflater.inflate(R.layout.layout_title, null);
                return txt;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_buttom);
        mTextSwitcher.setInAnimation(in);
        mTextSwitcher.setOutAnimation(out);

        movieAdapter = new MovieAdapter(movieList, this);
        mFeatureCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverFlow);
        mFeatureCoverFlow.setAdapter(movieAdapter);
        mFeatureCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTextSwitcher.setText(movieList.get(position).getName());
            }

            @Override
            public void onScrolling() {

            }
        });

    }

    private void initData() {
        movieList.add(new Movie("Movie","http://i.imgur.com/DvpvklR.png"));
        movieList.add(new Movie("Movie","http://i.imgur.com/DvpvklR.png"));
        movieList.add(new Movie("Movie","http://i.imgur.com/DvpvklR.png"));
        movieList.add(new Movie("Movie","http://i.imgur.com/DvpvklR.png"));
        movieList.add(new Movie("Movie","http://i.imgur.com/DvpvklR.png"));
        movieList.add(new Movie("Movie","http://i.imgur.com/DvpvklR.png"));
        movieList.add(new Movie("Movie","http://i.imgur.com/DvpvklR.png"));
        movieList.add(new Movie("Movie","http://i.imgur.com/DvpvklR.png"));
        movieList.add(new Movie("Movie","http://i.imgur.com/DvpvklR.png"));
    }
}
