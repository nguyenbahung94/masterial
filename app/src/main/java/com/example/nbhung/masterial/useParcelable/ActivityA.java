package com.example.nbhung.masterial.useParcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.nbhung.masterial.R;

/**
 * Created by nbhung on 8/21/2017.
 */

public class ActivityA extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Intent i = new Intent(ActivityA.this, ActivityB.class);
        ContactInfomation ci = new ContactInfomation("hakshd", "ajhsdkj", 1);
        i.putExtra("objectA", ci);
        startActivity(i);
    }
}
