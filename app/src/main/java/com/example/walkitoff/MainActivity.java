package com.example.walkitoff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TimePicker timeSelected;

    int hour, minute;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: get permission for location services

        // initialize time picker
        timeSelected = findViewById( R.id.timepicker );

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
}