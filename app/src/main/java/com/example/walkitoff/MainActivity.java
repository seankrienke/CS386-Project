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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    public static String chosenSound, chosenPresetLabel;

    public static String uID,uName,uDistance,uScore,uLevel;

    static final int REQUEST_PERMISSION = 1;

    int level = 0;

    AlarmList alarmList = new AlarmList();

    int hour, minute;

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
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {

                // save the chosen hour and minute
                MainActivity.this.hour = hour;
                MainActivity.this.minute = minute;
            }
        });
        // end anonymous class

        fillSoundMenu();

        Spinner soundSpinner = findViewById( R.id.soundspinner );
        Spinner presetSpinner = findViewById( R.id.presetspinner );

        presetSpinner.setOnItemSelectedListener( new PresetSpinner() );
        soundSpinner.setOnItemSelectedListener( new SoundSpinner() );

        Button alarmButton = findViewById( R.id.alarmbutton );
        Button saveButton = findViewById( R.id.savebutton );
        Button loginButton = findViewById( R.id.loginbutton );

        // called by alarm button
        alarmButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                setAlarm();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveAsPreset();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                connectDB();
            }
        });
    }


    /**
     * fills the drop down spinner menu with unlocked sounds
     */
    private void fillSoundMenu(){

        String[] soundArray = SoundFacade.getSoundArray( level );

        initializeSpinner( soundArray, R.id.soundspinner );
    }

    /**
     * fills second dropdown menu with alarm presets
     */
    private void fillPresetMenu(){

        String[] alarmLabelArray = new String[ alarmList.size ];

        int index;

        for( index = 0; index < alarmList.size; index++ ){

            alarmLabelArray[ index ] = alarmList.alarmArray[ index ].getAlarmLabel();
        }

        initializeSpinner( alarmLabelArray, R.id.presetspinner );
    }

    /**
     * initializes a spinner with a given array and spinner id
     *
     * @param array - to populate the spinner
     * @param spinnerId - reference to a spinner
     */
    private void initializeSpinner( String[] array, int spinnerId ){

        Spinner spinner = findViewById( spinnerId );

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, array );

        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        spinner.setAdapter( adapter );
    }

    /**
     * creates an alarm preset based on current settings and adds it to the sound spinner
     *
     * @return new preset alarm label if needed
     */
    private String saveAsPreset(){

        AlarmPreset preset =
                new AlarmPreset( MainActivity.this, hour, minute, chosenSound );

        alarmList.addPreset( preset );

        fillPresetMenu();

        return preset.getAlarmLabel();
    }

    /**
     * checks for chosen preset and sets alarm based off of it. Also updates sound menu if needed
     */
    private void setAlarm(){
        if( chosenPresetLabel == null ){

            chosenPresetLabel = saveAsPreset();
        }

        Alarm alarm = alarmList.findPreset( chosenPresetLabel ).makeAlarm();

        alarm.setAlarm();

        level++;

        fillSoundMenu();
    }

    //This is our login activity being created.
    public void connectDB(){

        Intent intent = new Intent(this, ConnectDB.class);
        startActivity(intent);
    }

}
