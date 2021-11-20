package com.example.walkitoff;

import android.content.Context;
import android.location.LocationManager;
import android.media.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alarm {

    private String wakeUpTime, alarmSound;

    Context mainContext;

    public Alarm( Context context, String inTime, String inSound ){

        // set member data to parameters
        wakeUpTime = inTime;
        alarmSound = inSound;

        mainContext = context;
    }

    /**
     * plays alarm sound on a loop until distance reached
     */
    private void playAlarm(){

        MediaPlayer sound = MediaPlayer.create( mainContext, SoundFacade.getSound( alarmSound ) );
        // play alarm sound
        sound.start();

        // set sound loop
        sound.setLooping( true );

        // initiate alarm stop
        stopAlarm( sound );
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
    public void stopAlarm( MediaPlayer sound ){

        // start tracking distance at test distance of 30 feet
        new Distance( mainContext, 30 ).trackDistance();

        // stop sound loop
        sound.setLooping( false );

        // release alarm sound
        sound.release();
    }

}
