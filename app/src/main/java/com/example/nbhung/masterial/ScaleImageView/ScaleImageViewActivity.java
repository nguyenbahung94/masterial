package com.example.nbhung.masterial.ScaleImageView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nbhung.masterial.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nbhung on 8/25/2017.
 */

public class ScaleImageViewActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    public static ScaleImageView imageview;
    public static boolean flag = false;
    public static int width = 0, height = 0;
    private Button btndraw, btnzoom, btnsave, btnTakePhoto;
    public static String mCurrentPhotoPath;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initwidget();
    }

    private void initwidget() {

        imageview = (ScaleImageView) findViewById(R.id.image);
        btnTakePhoto = (Button) findViewById(R.id.take_a_photo);
        btnsave = (Button) findViewById(R.id.activity_main_save);
        btndraw = (Button) findViewById(R.id.activity_main_zoom_draw);
        btnzoom = (Button) findViewById(R.id.activity_main_zoom_zoom);

        btndraw.setOnClickListener(this);
        btnzoom.setOnClickListener(this);
        btnsave.setOnClickListener(this);
        btnTakePhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
// TODO Auto-generated method stub
        if (btndraw.equals(arg0)) {
            flag = true;
        } else if (btnzoom.equals(arg0)) {
            flag = false;
        } else if (btnsave.equals(arg0)) {
            ScaleImageView.save();
            flag = false;
        }
        if (btnTakePhoto.equals(arg0)) {

            dispatchTakePictureIntent();
        }
    }

    private void dispatchTakePictureIntent() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = timeStamp + ".jpg";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        mCurrentPhotoPath = storageDir.getAbsolutePath() + "/" + imageFileName;
        File file = new File(mCurrentPhotoPath);
        Uri outputFileUri = Uri.fromFile(file);
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(cameraIntent, 1);
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File imgFile = new File(mCurrentPhotoPath);
                if (imgFile.exists()) {
                    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                    imageview.setImageBitmap(myBitmap);
                    galleryAddPic();
                }
            }
        }
    }
}
