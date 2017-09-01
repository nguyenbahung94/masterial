package com.example.nbhung.masterial.useParcelable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nbhung.masterial.R;

/**
 * Created by nbhung on 8/21/2017.
 */

public class ActivityB extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Bundle data = getIntent().getExtras();
        ContactInfomation contactInfomation = (ContactInfomation) data.getParcelable("objectA");
        Log.e("contactInformation", contactInfomation.toString());
    }
}
