package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
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
    private static final String PRIMARY_CHANNEL_ID="primary_notification_channel";
    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);
        createNotificationChannel();
    }

    @Click(R.id.buttonNotify)
    public void sendNotification(){
        NotificationCompat.Builder notifyBuilder=getNotificationBuilder();
        mNotificationManager.notify(NOTIFICATION_ID,notifyBuilder.build());
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
        NotificationCompat.Builder notifyBuilder=new NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID)
                                                    .setContentTitle("You have been notified.")
                                                    .setContentText("This is notification Text.")
                                                    .setSmallIcon(R.drawable.ic_android);
        return notifyBuilder;
    }
}
