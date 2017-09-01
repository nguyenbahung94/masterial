package com.example.nbhung.masterial.animation.circular.reveal;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.RelativeLayout;

import com.example.nbhung.masterial.R;

/**
 * Created by nbhung on 8/14/2017.
 */

public class ViewCircilar extends AppCompatActivity {
    private FloatingActionButton fab;
    private RelativeLayout layoutMain;
    private RelativeLayout layoutButton;
    private RelativeLayout layoutContent;
    private boolean isOpen = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_circular);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        layoutMain = (RelativeLayout) findViewById(R.id.layoutMain);
        layoutButton = (RelativeLayout) findViewById(R.id.layoutbutton);
        layoutContent = (RelativeLayout) findViewById(R.id.layoutcontent);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMenu();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void viewMenu() {
        if (!isOpen) {
            int x = layoutContent.getRight();
            int y = layoutContent.getBottom();

            int starRadius = 0;
            int endRadius = (int) Math.max(layoutMain.getWidth(), layoutMain.getHeight());
            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(getResources(), android.R.color.white, null)));
            fab.setImageResource(R.drawable.ic_close_black_24dp);
            Animator animator = ViewAnimationUtils.createCircularReveal(layoutButton, x, y, starRadius, endRadius);
            layoutButton.setVisibility(View.VISIBLE);
            animator.setDuration(500);
            animator.start();
            isOpen = true;
        } else {
            int x = layoutContent.getRight();
            int y = layoutContent.getBottom();

            int starRadius = (int) Math.max(layoutMain.getWidth(), layoutMain.getHeight());
            int endRadius = 0;

            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(getResources(), R.color.colorAccent, null)));
            fab.setImageResource(R.drawable.ic_close_black_24dp);

            Animator animator = ViewAnimationUtils.createCircularReveal(layoutButton, x, y, starRadius, endRadius);
            layoutButton.setVisibility(View.VISIBLE);
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    layoutButton.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            animator.setDuration(500);
            animator.start();
            isOpen = false;
        }
    }
}
