package com.example.nbhung.masterial.GetTokens;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.nbhung.masterial.R;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Created by nbhung on 8/23/2017.
 */

public class RegistrationExample extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_token);

//        if(getIntent().getExtras() != null){
//            String a = "";
//            for (String key: getIntent().getExtras().keySet()) {
//                a += getIntent().getExtras().keySet() + ":" + getIntent().getExtras().getString(key) + ";";
//            }
//            Toast.makeText(getApplicationContext(), "body:" + a, Toast.LENGTH_SHORT).show();
//            Log.e("TEST", a);
//        } else {

        SharedPreferences sharedPref = getDefaultSharedPreferences(RegistrationExample.this);
        String text = sharedPref.getString("body", "");
        Toast.makeText(getApplicationContext(), "body:" + text, Toast.LENGTH_SHORT).show();
    }
}
