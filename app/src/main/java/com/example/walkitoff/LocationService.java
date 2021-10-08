package com.example.walkitoff;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationManager;

import androidx.core.app.ActivityCompat;

public class LocationService extends MainActivity {

    /**
     * Constructor gets current location when initialized
     */
    public LocationService() {

        getCurrentLocation();
    }

    public void getCurrentLocation() {

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission
                        (this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions( this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION );
        }
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }

    /**
     * gets longitude of this location
     *
     * @return longitude (String)
     */
    public String getLongitude(){

        return String.valueOf( location.getLongitude() );
    }

    /**
     * gets latitude of this location
     *
     * @return latitude (String)
     */
    public String getLatitude(){

        return String.valueOf( location.getLatitude() );
    }
}
