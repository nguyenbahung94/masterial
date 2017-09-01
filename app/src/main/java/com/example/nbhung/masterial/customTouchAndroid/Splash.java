package com.example.nbhung.masterial.customTouchAndroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nbhung.masterial.R;


public class Splash extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

    }
    public void proceed(View v){
        Intent intent=new Intent(Splash.this, MainActivityZoom.class);
        startActivity(intent);
    }
}
