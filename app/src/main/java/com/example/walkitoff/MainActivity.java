package com.example.walkitoff;
/* TODO
- uncomment score Methods
- uncomment score variables
- Make connect Activity
- Connect to DB
- Load Values from DB
- Constructor
- Get methods
- changed multyplyer
-
* */
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Time timeSetting;
    public static String uID,uName,uDistance,uScore,uLevel;

    static final int REQUEST_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // request permission for location services
        ActivityCompat.requestPermissions( this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION );

        // initialize time picker
        TimePicker timeSelected = findViewById( R.id.timepicker );

        // create anonymous class for time change listener
        timeSelected.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int inHour, int inMinute) {

                // save the chosen hour and minute
                timeSetting = new Time( inHour, inMinute );
            }
        });
        // end anonymous class
    }

    //This is our login activity being created.
    public void connectDB(View view){

        Intent intent = new Intent(this, ConnectDB.class);
        startActivity(intent);
    }


    /**
     * called by a button/switch to set the alarm with a given sound
     *
     * @param view - parameter so that button can call method
     */
    public void setAlarm( View view ){

        // initialize alarm sound
        MediaPlayer alarmSound = MediaPlayer.create( this, R.raw.alarm_sound );

        // initialize alarm object
        Alarm alarm = new Alarm( this, timeSetting.parseTime(), alarmSound );

        // set the alarm
        alarm.setAlarm();
    }
    

}
