package com.example.walkitoff;

import android.media.MediaPlayer;

public class Sound extends MainActivity{

    /*
    this class is to be used by the Alarm class. it functions as a library
    of sounds that the user can choose from, all stored in an array
     */

    // constants
    private static int DEFAULT_CAPACITY = 10;

    // array of alarm sounds that the user can choose from
    private MediaPlayer[] soundArray;
    private MediaPlayer defaultSound;

    private int arraySize, arrayCapacity;

    /**
     * default constructor
     */
    public Sound(){

        // initialize array
        arraySize = 0;
        arrayCapacity = DEFAULT_CAPACITY;
        soundArray = new MediaPlayer[ arrayCapacity ];
        defaultSound = MediaPlayer.create( this, R.raw.alarm_sound );

        // add all unlocked sounds
        addAllUnlockedSounds();
    }

    /**
     * appends a single sound to the array
     *
     * @param sound - alarm sound to add to array
     */
    private void addSound( MediaPlayer sound ){

        // add sound to array size
        soundArray[ arraySize ] = sound;

        // increment array size
        arraySize++;
    }

    /**
     * adds all unlocked sounds to the array.
     * <p>
     * note: uses score object to determine which sounds to add
     */
    @SuppressWarnings("unused")
    private void addAllUnlockedSounds(){

        // add the base sound
        addSound( defaultSound );

        // TODO: add all other sounds accordingly once we have other sounds
    }

}
