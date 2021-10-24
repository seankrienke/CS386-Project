package com.example.walkitoff;

import android.content.Context;

public class Distance {

    /*
    this class keeps track of distance the user travelled.
    the plan is to create an object
     */

    private int travelledDistance, goalDistance;

    private Context mainContext;

    /*
    default distance goal in feet
     */
    private static final int DEFAULT_GOAL = 500;

    /**
     * default constructor
     *
     */
    public Distance( Context context ) {

        travelledDistance = 0;

        goalDistance = DEFAULT_GOAL;

        mainContext = context;
    }

    /**
     * initialization constructor
     *
     * @param inGoalDistance - user set goal distance
     */
    public Distance( Context context, int inGoalDistance ) {

        travelledDistance = 0;

        goalDistance = inGoalDistance;

        mainContext = context;
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
     * called by setAlarm method in Alarm class.
     * <p>
     * updates distance every one second until goal distance is reached
     */
    public void trackDistance(){

        // variables

        // loop while travelled distance less tha goal distance

          // call update distance

        // end loop

    }

    /**
     * gets current distance between current location and last known location
     */
    private void updateDistance(){

    }

}
