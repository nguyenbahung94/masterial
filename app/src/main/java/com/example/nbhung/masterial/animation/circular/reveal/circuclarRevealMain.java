package com.example.nbhung.masterial.animation.circular.reveal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;

import com.example.nbhung.masterial.R;

/**
 * Created by nbhung on 8/1/2017.
 */

public class circuclarRevealMain extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private Transition.TransitionListener transitionListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuclarreveal);
//        floatingActionButton = (FloatingActionButton) findViewById(R.id.btn_floating);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            //   enterReveal();
//                exitReveal();
//            }
//        });
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            transitionListener = new Transition.TransitionListener() {
//                @Override
//                public void onTransitionStart(Transition transition) {
//
//                }
//
//                @Override
//                public void onTransitionEnd(Transition transition) {
//                    enterReveal();
//                }
//
//                @Override
//                public void onTransitionCancel(Transition transition) {
//
//                }
//
//                @Override
//                public void onTransitionPause(Transition transition) {
//
//                }
//
//                @Override
//                public void onTransitionResume(Transition transition) {
//
//                }
//            };
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().getEnterTransition().addListener(transitionListener);
//        }
//    }
//
//    //invisible view
//    private void enterReveal() {
//        int cx = floatingActionButton.getMeasuredWidth() / 2;
//        int cy = floatingActionButton.getMeasuredHeight() / 2;
//
//        int finalRadius = Math.max(floatingActionButton.getWidth(), floatingActionButton.getHeight()) / 2;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            Animator anim = ViewAnimationUtils.createCircularReveal(floatingActionButton, cx, cy, 0, finalRadius);
//            anim.start();
//            floatingActionButton.setVisibility(View.VISIBLE);
//        }
//
//    }
//
//    //visible view
//    private void exitReveal() {
//        int cx = floatingActionButton.getMeasuredWidth() / 2;
//        int cy = floatingActionButton.getMeasuredHeight() / 2;
//        int initialRadius = floatingActionButton.getWidth() / 2;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            Animator animator = ViewAnimationUtils.createCircularReveal(floatingActionButton, cx, cy, initialRadius, 0);
//            animator.addListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    super.onAnimationEnd(animation);
//                    floatingActionButton.setVisibility(View.INVISIBLE);
//
//                }
//            });
//            animator.start();
//        }
    }
}
