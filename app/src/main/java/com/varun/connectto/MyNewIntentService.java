package com.varun.connectto;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyNewIntentService extends IntentService {
    private static final int NOTIFICATION_ID = 3;
//    private static final int time=6;

    Calendar calendar=Calendar.getInstance();
    SimpleDateFormat format=new SimpleDateFormat ( "HH:mm:ss" );
    String time = format.format(calendar.getTime ());



    public MyNewIntentService() {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {




            Notification.Builder builder = new Notification.Builder(this);
            builder.setContentTitle("Tablet Time!!");
            builder.setContentText("Did you already take your tablets??");
            builder.setSmallIcon(R.drawable.ic_medicine);
            Intent notifyIntent = new Intent(this, SplashScreen.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            //to be able to launch your activity from the notification

            Intent YesIntent=new Intent(this,MainActivity.class);

            YesIntent.setFlags ( Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK );
            PendingIntent YesPendingIntent = PendingIntent.getActivity ( this,0,YesIntent,PendingIntent.FLAG_ONE_SHOT );


            Intent NoIntent=new Intent(this,MainActivity.class);
            NoIntent.setFlags ( Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK );
            PendingIntent NoPendingIntent = PendingIntent.getActivity ( this,0,NoIntent,PendingIntent.FLAG_ONE_SHOT );

            builder.addAction ( R.drawable.ic_check_circle_black_24dp,"Yes",YesPendingIntent );
            builder.addAction ( R.drawable.ic_cancel_black_24dp,"No",NoPendingIntent );


            builder.setContentIntent(pendingIntent);
            Notification notificationCompat = builder.build();
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
            managerCompat.notify(NOTIFICATION_ID, notificationCompat);




    }
}
