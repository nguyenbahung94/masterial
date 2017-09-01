package com.example.nbhung.masterial.GetTokens;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.nbhung.masterial.MainActivity;
import com.example.nbhung.masterial.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by nbhung on 8/23/2017.
 */

public class GetMessages extends FirebaseMessagingService {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Log.e("TAG", "From: " + remoteMessage.getFrom());

        if (remoteMessage.getNotification() != null) {
            Log.e("TAG", "Message Notification Body: " + remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }


        //This will give you the Text property in the curl request(Sample Message):
//        Log.e("TAG", "Notification Message Body: " + remoteMessage.getNotification().getBody());
//        //This is where you get your click_action
//        Log.e("TAG", "Notification Click Action: " + remoteMessage.getNotification().getClickAction());
//        if (remoteMessage.getData().size() > 0) {
//            SharedPreferences.Editor editor = sharedPref.edit();
//            editor.putString("body", remoteMessage.getData().toString());
//            editor.apply();
//            Log.e("AAAAAAAA", "AAAAAAAAAAA");
//        } else {
//            Log.e("BBBBBBB", "BBBBBBBBBB");
//        }
//        Log.e("From: ", "" + remoteMessage.getFrom());
//        Log.e("Notification Message: ", "" + remoteMessage.getData());
//        if (remoteMessage.getNotification() != null) {
//            Log.e("Notification Message: ", "" + remoteMessage.getNotification());
//            if (remoteMessage.getNotification().getBody() != null) {
//                Log.e("Body: ", "" + remoteMessage.getNotification().getBody());
//            }
//        }
    }

    private void sendNotification(String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.sunset)
                .setContentTitle("FCM Message")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}
