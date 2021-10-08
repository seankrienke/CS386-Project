package com.example.walkitoff;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;

import androidx.core.app.ActivityCompat;

public class LocationService {

    /*
    updates user location and provides information related to current location
     */

    // constants
    private static final int REQUEST_PERMISSION = 1;

    // member data
    private Location currentLocation;
    private LocationManager locationManager;

    Context context;

    /**
     * Constructor gets current location when initialized
     */
    public LocationService( Context activity, LocationManager inManager ) {

        context = activity;

        locationManager = inManager;

        // get current location
        updateLocation();
    }

    /**
     * checks for appropriate location service permissions
     * <p>
     * method should always be called before updating location
     */
    private void checkPermission(){

        boolean missingPermissions = ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission
                        (context, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED;

        // check for missing permissions
        if( missingPermissions ){

            // request permission to access location
            ActivityCompat.requestPermissions( (MainActivity)context,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION );
        }
    }
    /**
     * gets the last known location from location manager via gps services.
     * <p>
     * note: checks for permission granted before getting the current location
     */
    public void updateLocation() {

        // check for appropriate permissions
        checkPermission();

        // update the current location
        currentLocation = locationManager.getLastKnownLocation( LocationManager.GPS_PROVIDER );

    }

    /**
     * gets longitude of this location
     *
     * @return longitude (String)
     */
    public String parseLongitude(){

        // return string value of longitude
        return String.valueOf( currentLocation.getLongitude() );
    }

    /**
     * gets latitude of this location
     *
     * @return latitude (String)
     */
    public String parseLatitude(){

        // return string value of latitude
        return String.valueOf( currentLocation.getLatitude() );
    }
}
