package com.example.walkitoff;
/* TODO
- uncomment score Methods
- uncomment score variables
- Make connect Activity
- Connect to DB
- Load Values from DB
- Constructor
- Get methods
- changed multyplyer
-
* */
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String chosenSound;
  
    String timeSetting;

    public static String uID,uName,uDistance,uScore,uLevel;

    static final int REQUEST_PERMISSION = 1;

    int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // request permission for location services
        ActivityCompat.requestPermissions( this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION );

        // initialize time picker
        TimePicker timeSelected = findViewById( R.id.timepicker );

        // create anonymous class for time change listener
        timeSelected.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int inHour, int inMinute) {

                // save the chosen hour and minute
                timeSetting = new Time( inHour, inMinute ).parseTime();
            }
        });
        // end anonymous class

        fillMenu();

        Spinner soundSpinner = findViewById( R.id.soundspinner );

        soundSpinner.setOnItemSelectedListener( this );
    }

    /**
     * fills the drop down spinner menu with unlocked sounds
     */
    private void fillMenu(){

        String[] localSoundArray = new String[ level + 1 ];

        localSoundArray[ 0 ] = Sound.DEFAULT_SOUND;

        if( level >= 1 ){

            localSoundArray[ 1 ] = Sound.SOUND_ONE;
        }

        Spinner soundSpinner = findViewById( R.id.soundspinner );

        ArrayAdapter<String> soundAdapter =
                new ArrayAdapter<String>( this,
                        android.R.layout.simple_list_item_1, localSoundArray );

        soundAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        soundSpinner.setAdapter( soundAdapter );
    }

    //This is our login activity being created.
    public void connectDB(View view){

        Intent intent = new Intent(this, ConnectDB.class);
        startActivity(intent);
    }


    /**
     * called by a button/switch to set the alarm with a given sound
     *
     * @param view - parameter so that button can call method
     */
    public void setAlarm( View view ){

        MediaPlayer alarmSound;

        if( chosenSound.equals( Sound.DEFAULT_SOUND ) ){

            alarmSound = MediaPlayer.create( this, R.raw.alarm_sound );
        }
        else{
            alarmSound = MediaPlayer.create( this, R.raw.second_alarm__sound );
        }

        // initialize alarm object
        Alarm alarm = new Alarm( this, timeSetting, alarmSound );

        // set the alarm
        alarm.setAlarm();

        // increment level
        level++;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        chosenSound = adapterView.getItemAtPosition( i ).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        chosenSound = Sound.DEFAULT_SOUND;
    }

}
