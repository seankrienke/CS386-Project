package com.example.walkitoff;

import android.location.LocationManager;
import android.media.MediaPlayer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alarm {

    private int hour, minute;
    private String wakeUpTime;

    MediaPlayer alarmSound;

    Distance distanceTracking;

    LocationManager locationManager;

    public Alarm( int inHour, int inMinute, MediaPlayer inSound,
                  LocationManager inLocationManager ){

        // set member data to parameters
        hour = inHour;
        minute = inMinute;
        alarmSound = inSound;

        // parse the wake-up time
        wakeUpTime = parseTime();

        locationManager = inLocationManager;


    }

    /**
     * concatenates minute to hour
     * <P>
     * ex. hour 23 and minute 12 returns 2312
     *
     * @return formatted time (String)
     */
    private String parseTime(){

        // return parsed time
        return String.valueOf( hour ) + String.valueOf( minute );
    }

    /**
     * plays alarm sound on a loop
     */
    private void playAlarm(){

        // play alarm sound
        alarmSound.start();

        // set loop
        alarmSound.setLooping( true );
    }

    /**
     * waits until wake-up time to play the alarm sound
     */
    public void setAlarm(){

        // initialize date objects
        Date time = new Date();
        SimpleDateFormat formatTime = new SimpleDateFormat( "HHmm" );

        // get the current time
        String currentTime = formatTime.format( time );

        // loop until current time equals wake-up time
        while( !currentTime.equals( wakeUpTime ) ){

            // reinitialize date object
            time = new Date();

            // get the current date
            currentTime = formatTime.format( time );
        }
        // end loop

        // play alarm sound
          // method: playAlarm
        playAlarm();
    }

    /**
     * stops the alarm sound
     */
    public void stopAlarm(){

        // stop loop
        alarmSound.setLooping( false );

        // release alarm sound
        alarmSound.release();
    }

}
