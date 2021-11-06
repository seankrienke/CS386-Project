package com.example.walkitoff;

import android.content.Context;
import android.media.MediaPlayer;

public class Sound extends MainActivity{

    /*
    this class is to be used by the Alarm class. it functions as a library
    of sounds that the user can choose from, all stored in an array
     */

    // constants
    private static int DEFAULT_CAPACITY = 10;

    // array of alarm sounds that the user can choose from and array of every alarm sound
    public static String[] unlockedSoundArray;

    // sounds
    public static String DEFAULT_SOUND = "Default";
    public static String SOUND_ONE = "Sound One";
    public static String SOUND_TWO = "Sound Two";
    public static String SOUND_THREE = "Sound Three";

    private int arraySize, arrayCapacity, level;

    Context mainContext;

    /**
     * default constructor
     */
    public Sound( Context context, int level ){

        this( context, DEFAULT_CAPACITY, level );
    }

    /**
     * initialization constructor
     */
    public Sound( Context context, int capacity, int level ){
        arrayCapacity = capacity;
        unlockedSoundArray = new String[ arrayCapacity ];
        this.level = level;
        arraySize = 0;

        mainContext = context;

        addAllUnlockedSounds();
    }

    /**
     * appends a single sound to the array
     *
     * @param sound - alarm sound to add to array
     */
    private void addSound( String soundName ){

        if( arraySize < arrayCapacity ){

            unlockedSoundArray[ arraySize ] = soundName;
            arraySize++;

        }
    }

    /**
     * adds all unlocked sounds to the array.
     * <p>
     * note: uses score object to determine which sounds to add
     */
    @SuppressWarnings("unused")
    private void addAllUnlockedSounds(){

        // add the base sound
        addSound( DEFAULT_SOUND );

        if( userLevel >= 1 ){

            addSound( SOUND_ONE );
        }
        if( userLevel >= 2 ){

            addSound( SOUND_TWO );
        }
        if( userLevel >= 3 ){

            addSound( SOUND_THREE );
        }

    }

    /**
     * checks if the user has the required score to use the sound (called before adding sound to
     * unlocked sound array)
     *
     * @param sound - alarm sound that may or may not be added to unlocked sound array
     */
    private boolean checkWithScore( String soundName ){

        if( soundName.equals( DEFAULT_SOUND ) && userLevel >= 1 ){

            return true;
        }
        else if( soundName.equals( SOUND_ONE ) && userLevel >= 2 ){

            return true;

        }
        else if( soundName.equals( SOUND_TWO ) && userLevel >= 3 ){

            return true;
        }
        else if( soundName.equals( SOUND_THREE ) && userLevel >= 4 ){

            return true;

        }

        return false;
    }

    /**
     * finds sound in unlocked sound array
     *
     * @param Sound - alarm sound to match to array
     *
     * @return sound if found in unlocked sound array, null otherwise
     */
    public MediaPlayer chooseSound( String soundName ){

        if( soundName.equals( DEFAULT_SOUND ) ){

            return MediaPlayer.create( mainContext, R.raw.alarm_sound );
        }
        else{

            return MediaPlayer.create( mainContext, R.raw.second_alarm__sound );
        }
    }

}
