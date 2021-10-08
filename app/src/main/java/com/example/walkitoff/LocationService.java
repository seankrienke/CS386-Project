package com.example.walkitoff;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;

import androidx.core.app.ActivityCompat;

public class LocationService extends MainActivity {

    /*
    updates user location and provides information related to current location
     */

    /*
    location member data
     */
    LocationManager locationManager;
    Location currentLocation;

    /**
     * Constructor gets current location when initialized
     */
    public LocationService() {

        // initialize location manager and get current location
        locationManager = ( LocationManager )getSystemService( LOCATION_SERVICE );
        updateLocation();
    }

    /**
     * gets the last known location from location manager via gps services.
     * <p>
     * note: checks for permission granted before getting the current location
     */
    public void updateLocation() {

        // check if permission to access location services has not been granted
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission
                        (this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

            // request permission
            ActivityCompat.requestPermissions( this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION );
        }
        else{
            // otherwise, assume permission granted and get last known location
            currentLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
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
