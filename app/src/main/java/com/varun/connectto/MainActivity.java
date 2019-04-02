package com.varun.connectto;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private static final int NOTIFICATION_REMINDER_NIGHT = 12;
    private static final int NOTIFICATION_ID=3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new dashboardFrag()).commit();
        }

        Intent notifyIntent = new Intent (this,MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (getApplicationContext (),NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getApplicationContext ().getSystemService( Context.ALARM_SERVICE);
        alarmManager.setRepeating( AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                1000 * 60 * 60 * 12, pendingIntent);

        NotificationManager notificationManager=(NotificationManager)getSystemService ( NOTIFICATION_SERVICE );
        notificationManager.cancel ( MainActivity.NOTIFICATION_ID);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.dashboard:
                            selectedFragment = new dashboardFrag();
                            break;
                        case R.id.notification:
                            selectedFragment = new notificationFrag();
                            break;
                        case R.id.history:
                            selectedFragment = new historyFrag();
                            break;
                        case R.id.user:
                            selectedFragment = new aboutFrag();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}

