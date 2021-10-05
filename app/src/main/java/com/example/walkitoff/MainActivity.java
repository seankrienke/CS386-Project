package com.example.walkitoff;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Time timeSetting;

    MediaPlayer alarmSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: get permission for location services

        // initialize time picker
        TimePicker timeSelected = findViewById( R.id.timepicker );

        // create anonymous class for time change listener
        timeSelected.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int chosenHour, int chosenMinute) {

                // save the chosen hour and minute
                timeSetting = new Time( chosenHour, chosenMinute );
            }
        });
        // end anonymous class
    }

    public void setAlarm( View view ){

        // initialize alarm sound
        alarmSound = MediaPlayer.create( this, R.raw.alarm_sound );

        // initialize alarm object
        Alarm alarm = new Alarm( timeSetting, alarmSound );

        // set the alarm
        alarm.setAlarm();
    }

}
