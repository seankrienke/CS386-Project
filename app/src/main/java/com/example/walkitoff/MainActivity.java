package com.example.walkitoff;

import androidx.annotation.NonNull;
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

    /**
     * concatenates minute to hour
     * <p>
     * (ex. hour 23 and minute 12 returns 2312)
     * @param hour - in 24 hour format
     * @param minute - minutes 0-59
     * @return minute concatenated to hour (String)
     */
    private String parseTime(int inHour, int inMinute ){

        // return parsed time
          // method: valueOf
        return String.valueOf( inHour ) + String.valueOf( inMinute );

    }

    /**
     * Called when user presses button to set alarm
     * @param view - parameter for button view
     */
    public void setAlarm( View view ){

        // initialize method/variables
        String wakeUpTime = parseTime( hour, minute );

        // set the alarm

          // loop until wakeup time

            // get the current time

          // end loop

          // sound alarm
    }

}
