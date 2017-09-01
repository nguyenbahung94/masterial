package com.example.nbhung.masterial.simpleRippleRevealElevationTutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nbhung.masterial.R;

/**
 * Created by nbhung on 8/11/2017.
 */

public class MainButton extends AppCompatActivity {
    private final int MAX_BUTTON = 3;
    private ViewGroup buttonContainer;
    private Button activeButton = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);


    }
}
