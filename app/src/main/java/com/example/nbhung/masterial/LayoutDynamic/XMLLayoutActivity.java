package com.example.nbhung.masterial.LayoutDynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nbhung on 8/21/2017.
 */

public class XMLLayoutActivity extends AppCompatActivity {
    private Button btnActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        //configuring the width and height of the linear layout
        LinearLayout.LayoutParams llLP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(llLP);
        //text view
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        tv.setLayoutParams(lp);
        tv.setText("Text View One");
        tv.setPadding(8, 8, 8, 8);
        ll.addView(tv);

        EditText edt = new EditText(this);
        edt.setText("EdtiText View One");
        edt.setPadding(8, 8, 8, 8);
        ll.addView(edt);

        Button btn = new Button(this);
        btn.setText("Button View One");
        btn.setPadding(8, 8, 8, 8);

        ll.addView(btn);
        setContentView(ll);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
