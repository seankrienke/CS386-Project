package com.example.walkitoff;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    int hour, minute;

    MediaPlayer alarm;

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
     *
     * @param view - parameter for button view
     */
    public void setAlarm( View view ){

        // initialize method/variables

          // parse the wake up time
          String wakeUpTime = parseTime( hour, minute );

          // initialize date objects
          Date time = new Date();
          SimpleDateFormat formatTime = new SimpleDateFormat( "HHmm" );

        // set the alarm

          // get current time
          String currentTime = formatTime.format( time );

          // loop until wakeup time
          while( !currentTime.equals( wakeUpTime ) ){

              // reinitialize the date object
              time = new Date();

              // get the current time
              currentTime = formatTime.format( time );
          }
          // end loop

          // sound alarm
            // method: soundAlarm
          soundAlarm();
    }

    /**
     * plays alarm sound
     */
    private void soundAlarm(){

        // initialize method/variables
        alarm = MediaPlayer.create( this, R.raw.alarm_sound );

        // play the alarm sound
        alarm.start();

        // loop the alarm sound
        alarm.setLooping( true );

    }

    /**
     * stops alarm sound
     *
     * @param view - for now, the alarm sound stops on button input for purposes of testing
     */
    public void stopAlarm( View view ){

        // initialize method/variables

        // stop alarm sound loop
        alarm.setLooping( false );

        // release the alarm sound
        alarm.release();
    }

}
