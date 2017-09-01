package com.example.nbhung.masterial.expandableTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nbhung.masterial.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

/**
 * Created by nbhung on 8/15/2017.
 */

public class expandableTextView extends AppCompatActivity {
    ExpandableTextView expandableTextView;
    String longText = "Using the library is really simple, just look at the source code of the provided sample. (Look at the SampleTextListAdapter.java for the use within a ListView)\n" +
            "\n" +
            "The important thing to note is that the view Ids for TextView and ImageButton must be set to \"@id/expandable_text\" and \"@id/expand_collapse\" respectively for this library to work.\n" +
            "\n" +
            "Also, you can optionally set the following attributes in your layout xml file to customize the behavior of the ExpandableTextView.\n" +
            "\n" +
            "maxCollapsedLines (defaults to 8) The maximum number of text lines allowed to be shown when the TextView gets collapsed\n" +
            "\n" +
            "animDuration (defaults to 300ms) Duration of the Animation for the expansion/collapse\n" +
            "\n" +
            "animAlphaStart (defaults to 0.7f) Alpha value of the TextView when the animation starts (NOTE) Set this value to 1 if you want to disable the alpha animation.\n" +
            "\n" +
            "expandDrawable Customize a drawable set to ImageButton to expand the TextView\n" +
            "\n" +
            "collapseDrawable Customize a drawable set to ImageButton to collapse the TextView";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandeble_textview);
        expandableTextView = (ExpandableTextView) findViewById(R.id.expandable_text_view);
        expandableTextView.setText(longText);
        expandableTextView.setOnExpandStateChangeListener(new ExpandableTextView.OnExpandStateChangeListener() {
            @Override
            public void onExpandStateChanged(TextView textView, boolean isExpanded) {
                Toast.makeText(com.example.nbhung.masterial.expandableTextView.expandableTextView.this, "expandable :" + isExpanded, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
