package com.example.walkitoff;

import android.location.Location;
import android.location.LocationManager;

public class Distance {

    /*
    this class keeps track of distance the user travelled.
    the plan is to create an object
     */

    private int travelledDistance, goalDistance, currentCoordinates, prevCoordinates;

    Location location;

    /*
    default distance goal in feet
     */
    private static final int DEFAULT_GOAL = 500;

    /**
     * default constructor
     *
     * @param locationManager
     */
    public Distance( LocationManager locationManager ){

        travelledDistance = 0;
        currentCoordinates = 0;
        prevCoordinates = 0;

        goalDistance = DEFAULT_GOAL;

    }

    /**
     * initialization constructor
     *
     * @param locationManager
     *
     * @param inGoalDistance - user set goal distance
     */
    public Distance( LocationManager locationManager, int inGoalDistance ){

        travelledDistance = 0;
        currentCoordinates = 0;
        prevCoordinates = 0;

        goalDistance = inGoalDistance;
    }

    /**
     * used to access travelled distance outside of class
     *
     * @return travelledDistance
     */
    public int getTravelledDistance(){

        return travelledDistance;
    }
    /**
     * converts distance to feet (DEFAULT UNIT OF MEASUREMENT UNKNOWN)
     *
     * @return - distance in feet
     */
    private int toFeet(){

        // temporary return stub
        return 0;
    }

    /**
     * called by setAlarm method in Alarm class. Updates distance every one second
     */
    public void trackDistance(){

    }

    /**
     * gets current distance between current location and last known location
     */
    private void updateDistance(){

    }

}
