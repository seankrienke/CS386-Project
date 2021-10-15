package com.example.walkitoff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Time timeSetting;

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

    /**
     * called by a button/switch to set the alarm with a given sound
     *
     * @param view - parameter so that button can call method
     */
    public void setAlarm( View view ){

        // initialize alarm sound
        MediaPlayer alarmSound = MediaPlayer.create( this, R.raw.alarm_sound );

        // initialize alarm object
        Alarm alarm = new Alarm( timeSetting, alarmSound );

        // set the alarm
        alarm.setAlarm();
    }

    /**
     * for testing purposes
     *<p>
     * called by alarm button to show coordinates
     *
     * @param view - parameter so that button can call method
     */
    public void showCoordinates( View view ){

        LocationData locationData = new LocationData( this );

        TextView text = findViewById( R.id.textView );

        text.setText( locationData.parseLongitude() + " " + locationData.parseLatitude() );

    }

}
