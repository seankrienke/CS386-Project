package com.example.walkitoff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Time timeSetting;

    static final int REQUEST_PERMISSION = 1;

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
                timeSetting = new Time( inHour, inMinute );
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

        MediaPlayer[] array = new MediaPlayer[ 2 ];

        array[ 0 ] = MediaPlayer.create( this, R.raw.alarm_sound );

        Spinner soundSpinner = findViewById( R.id.soundspinner );

        ArrayAdapter<MediaPlayer> soundAdapter =
                new ArrayAdapter<MediaPlayer>( this,
                        android.R.layout.simple_list_item_1, array );

        soundAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        soundSpinner.setAdapter( soundAdapter );
    }

    /**
     * called by a button/switch to set the alarm with a given sound
     *
     * @param view - parameter so that button can call method
     */
    public void setAlarm( View view ){

        // initialize alarm sound
        MediaPlayer alarmSound = MediaPlayer.create( this, R.raw.alarm_sound );

        // initialize alarm object
        Alarm alarm = new Alarm( this, timeSetting.parseTime(), alarmSound );

        // set the alarm
        alarm.setAlarm();
    }

    /**
     * for testing purposes
     *<p>
     * called by alarm button to show coordinates
     *
     * @param view - parameter so that button can call method
     */
    public void showCoordinates( View view ){

        LocationData locationData = new LocationData( this );

        TextView text = findViewById( R.id.textView );

        text.setText( locationData.parseLongitude() + " " + locationData.parseLatitude() );

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
