package vn.com.ebizworld.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;


public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        {
            // Set the alarm here.
            Class<?> activityClass;

            try {
                SharedPreferences prefs = context.getSharedPreferences("X", Context.MODE_PRIVATE);
                activityClass = Class.forName(
                        prefs.getString("lastActivity", MainActivity.class.getName()));
            } catch (ClassNotFoundException ex) {
                activityClass = MainActivity.class;
            }
            Intent intent1 = new Intent(context, activityClass);
            intent1.putExtra("alarm",1);
            context.startActivity(intent1);


        }

    }
}