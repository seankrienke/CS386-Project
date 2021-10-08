package com.example.walkitoff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    int hour, minute;

    static final int REQUEST_PERMISSION = 1;

    MediaPlayer alarmSound;

    LocationManager locationManager;
    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: get permission for location services
        ActivityCompat.requestPermissions( this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION );

        // initialize location manager
        locationManager = (LocationManager)getSystemService( LOCATION_SERVICE );

        // initialize time picker
        TimePicker timeSelected = findViewById( R.id.timepicker );

        // create anonymous class for time change listener
        timeSelected.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int chosenHour, int chosenMinute) {

                // save the chosen hour and minute
                hour = chosenHour;
                minute = chosenMinute;
            }
        });
        // end anonymous class
    }

    public void setAlarm( View view ){

        // initialize alarm sound
        alarmSound = MediaPlayer.create( this, R.raw.alarm_sound );

        // initialize alarm object
        Alarm alarm = new Alarm( hour, minute, alarmSound );

        // set the alarm
        alarm.setAlarm();
    }

}
