package com.example.walkitoff;

public class SoundFacade {

    private int level;

    public SoundFacade( int level ){

        this.level = level;
    }

    public String[] getSoundArray(){

        Sound soundList = new Sound( level );

        return soundList.addAllUnlockedSounds();
    }

    public int getSound( String soundName ){

        return SoundName.getSound( soundName );
    }


}
