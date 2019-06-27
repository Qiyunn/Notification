package com.example.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.UiAutomation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    private final String CHANNEL_ID = "personal notification";
    public static final int NOTIFICATION_ID = 1;

    CharSequence s1="thks jfkds  kdnkf skfld jdbkf dsnfjkdn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        button = findViewById(R.id.button_main_activity);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        displayNotification();
    }


    private void displayNotification() {
        createNotificatinChannel();

//        Intent intent=new Intent(this,LandingActivity.class);
//        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

//        Intent yesIntent = new Intent(this,YesActivity.class);
//        yesIntent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent yesPendingIntent=PendingIntent.getActivity(this,0,yesIntent,PendingIntent.FLAG_ONE_SHOT);
//
//        Intent noIntent = new Intent(this,NoActivity.class);
//        noIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //custom layout*********************************************************************************
//        RemoteViews remoteViews1=new RemoteViews(getPackageName(),R.layout.layout_normal_notification);

//        RemoteViews remoteViews2=new RemoteViews(getPackageName(),R.layout.layout_expend_notification);



        //********************************************************************************************

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID);
//                .setSmallIcon(R.drawable.ic_textsms_black_24dp)
//                .setContentTitle("title")
//                .setContentText("this is a notificaton")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setSmallIcon(R.drawable.ic_textsms_black_24dp);
        builder.setContentTitle("this is the title");
        builder.setContentText("this is a simple noyification demo");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
//        builder.setContentIntent(pendingIntent);

//        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.img_snow);

//        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
//        builder.setLargeIcon(bitmap);
//        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(s1));
//        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(getString(R.string.notification)).setBigContentTitle("hello"));

//        builder.addAction(R.drawable.ic_textsms_black_24dp,"yes",yesPendingIntent);

        //***********************
//        builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
//        builder.setCustomContentView(remoteViews1);
//        builder.setCustomContentView(remoteViews2);
        //++++++++++

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());

    }

    private void createNotificatinChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            String name = "personal information";
            String description = "include all the personal information";
            int importance=NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,name,importance);

            notificationChannel.setDescription(description);
            NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}