package com.example.nbhung.masterial.customTouchAndroid;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nbhung.masterial.R;


public class MainActivityZoom extends Activity {


    private CustomImageVIew view;
    ImageView fin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (CustomImageVIew) findViewById(R.id.imageView);
        fin = (ImageView) findViewById(R.id.imageView1);

        final Button paintBtn = (Button) findViewById(R.id.btn);
        paintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {

                button.setSelected(!button.isSelected());
                view.isZoomable = !button.isSelected();
                paintBtn.setText(button.isSelected() ? "Paint" : "Zoom");

                /*if (!button.isSelected()) {
                    Bitmap returnedBitmap = Bitmap.createBitmap(
                            image.getWidth(),
                            image.getHeight(),
                            Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(returnedBitmap);
                    image.draw(canvas);
                    ByteArrayOutputStream bs = new ByteArrayOutputStream();
                    returnedBitmap.compress(Bitmap.CompressFormat.PNG, 50, bs);

                    Bitmap FinalBitmap = BitmapFactory.decodeByteArray(bs.toByteArray(), 0,
                            bs.toByteArray().length);

                    image.setImageBitmap(FinalBitmap);
                }*/
            }
        });
        paintBtn.setText("Zoom");
    }

    public void ButtonClick(View v) {
        view.saveBitmap();
        fin.setImageBitmap(view.getBitmapSaved());
    }
}