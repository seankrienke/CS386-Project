package com.example.walkitoff;

import android.content.Context;
import android.media.MediaPlayer;

public class AlarmPreset {

    public static String alarmLabel;
    private String time;
    private MediaPlayer sound;
    private Context context;

    /**
     * constructor for alarm preset
     * <p>
     * note: add distance to parameter as soon as the feature for choosing goal distance is
     * implemented
     *
     * @param time - wakeup time
     *
     * @param sound - the name of the sound to wake up to
     */
    public AlarmPreset( Context context, String time, MediaPlayer sound ){

        this.time = time;
        this.sound = sound;

        this.context = context;

    }

    /**
     * creates an alarm object based off of member data
     *
     * @return alarm
     */
    public Alarm makeAlarm(){

        return new Alarm( context, time, sound );
    }
}
