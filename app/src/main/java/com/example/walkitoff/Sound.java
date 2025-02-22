package com.example.walkitoff;

public class Sound {

    /*
    this class is to be used by the Alarm class. it functions as a library
    of sounds that the user can choose from, all stored in an array
     */

    private static final int NUMBER_OF_ALL_SOUNDS = 4;

    private int arrayCapacity, level;

    /**
     * default constructor
     */
    public Sound( int level ){

        this.level = level;

        if( level < NUMBER_OF_ALL_SOUNDS ){

            arrayCapacity = level + 1;
        }
        else{

            arrayCapacity = NUMBER_OF_ALL_SOUNDS;

        }
    }

    /**
     * appends a single sound to the array
     *
     * @param sound - alarm sound to add to array
     */
    private String[] addSound( String[] array, int arraySize, String soundName ){

        if( arraySize < arrayCapacity ){

            array[ arraySize ] = soundName;

        }

        return array;
    }

    /**
     * adds all unlocked sounds to the array.
     * <p>
     * note: uses score object to determine which sounds to add
     */
    @SuppressWarnings("unused")
    public String[] addAllUnlockedSounds(){

        String[] unlockedSoundArray = new String[ arrayCapacity ];

        int arraySize = 0;

        unlockedSoundArray = addSound( unlockedSoundArray, arraySize, SoundName.DEFAULT_SOUND );
        arraySize++;

        unlockedSoundArray = addSound( unlockedSoundArray, arraySize, SoundName.SOUND_ONE );
        arraySize++;

        unlockedSoundArray = addSound( unlockedSoundArray, arraySize, SoundName.SOUND_TWO );
        arraySize++;

        unlockedSoundArray = addSound( unlockedSoundArray, arraySize, SoundName.SOUND_THREE );
        arraySize++;

        return unlockedSoundArray;

    }

}
