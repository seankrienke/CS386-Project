package com.example.walkitoff;

import android.location.Location;
import android.location.LocationManager;

public class LocationService {

    Location location;
    LocationManager locationManager;

    /**
     * initialization constructor
     *<p>
     * checks for user permission before anything else
     *
     * @param inManager - location manager object to update current location
     */
    public LocationService( LocationManager inManager ){

        locationManager = inManager;
    }
}
