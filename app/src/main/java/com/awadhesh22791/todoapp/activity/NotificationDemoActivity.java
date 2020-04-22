package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.awadhesh22791.todoapp.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_notification_demo)
public class NotificationDemoActivity extends AppCompatActivity {

    @ViewById(R.id.buttonNotify)
    Button buttonNotify;
    @ViewById(R.id.buttonNotifyUpdate)
    Button buttonNotifyUpdate;
    @ViewById(R.id.buttonNotifyCancel)
    Button buttonNotifyCancel;
    private static final String PRIMARY_CHANNEL_ID="primary_notification_channel";
    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);
        createNotificationChannel();
        setNotificationButtonState(true,false,false);
    }

    @Click(R.id.buttonNotify)
    public void sendNotification(){
        NotificationCompat.Builder notifyBuilder=getNotificationBuilder();
        mNotificationManager.notify(NOTIFICATION_ID,notifyBuilder.build());
        setNotificationButtonState(false,true,true);
    }

    @Click(R.id.buttonNotifyUpdate)
    public void updateNotification(){
        Bitmap androidImage= BitmapFactory.decodeResource(getResources(),R.drawable.mascot_1);
        NotificationCompat.Builder notifyBuilder=getNotificationBuilder();
        notifyBuilder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(androidImage)
        .setBigContentTitle("Notification updated!"));
        mNotificationManager.notify(NOTIFICATION_ID,notifyBuilder.build());
        setNotificationButtonState(false,false,true);
    }

    @Click(R.id.buttonNotifyCancel)
    public void cancelNotification(){
        mNotificationManager.cancel(NOTIFICATION_ID);
        setNotificationButtonState(true,false,false);
    }

    public void createNotificationChannel(){
        mNotificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            //create notification channel
            NotificationChannel notificationChannel=new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Mascot Notification",NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from mascot");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public NotificationCompat.Builder getNotificationBuilder(){
        Intent notificationIntent=new Intent(this,NotificationDemoActivity_.class);
        PendingIntent notificationPendingIntent=PendingIntent.getActivity(this,NOTIFICATION_ID,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notifyBuilder=new NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID)
                .setContentTitle("You have been notified.")
                .setContentText("This is notification Text.")
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        return notifyBuilder;
    }

    void setNotificationButtonState(boolean notifyEnabled,boolean updateEnabled,boolean cancelEnabled){
        buttonNotify.setEnabled(notifyEnabled);
        buttonNotifyUpdate.setEnabled(updateEnabled);
        buttonNotifyCancel.setEnabled(cancelEnabled);
    }
}
