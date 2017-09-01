package com.example.nbhung.masterial.ExpandedNotificationsLayouts;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.example.nbhung.masterial.R;

/**
 * Created by nbhung on 8/8/2017.
 */

public class Notifications extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, Notifications.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
        Bitmap bitMap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_face_black_24dp);
        Notification n = new Notification.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject")
                .setSmallIcon(R.drawable.ic_face_black_24dp)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
//                .setStyle(new Notification.BigTextStyle().bigText("kjahsdakjshdkahskdhkah123h1hkhakhd182ysgdfhaduqwueqpwuroqwwiueowuerwtoiyuewriwupsfkjsdkjhkah"))
//                .setStyle(new Notification.BigPictureStyle().bigPicture(bitMap))
//                .setStyle(new Notification.InboxStyle()
//                        .addLine("1")
//                        .addLine("2")
//                        .addLine("3"))
                .build();
        notificationManager.notify(0, n);
    }
}
