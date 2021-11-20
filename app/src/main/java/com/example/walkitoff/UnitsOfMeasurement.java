package com.example.walkitoff;

@SuppressWarnings("unused")
public class UnitsOfMeasurement {

    /**
     * returns distance value from meters to feet
     *
     * @return distance in ft (double)
     */
    public static double toFeet( double distance ){

        // variables
        double feetPerMeter = 3.208;

        // temp return stub
        return distance * feetPerMeter;
    }

    /**
     * returns distance value from meters to kilometers
     *
     * @return distance in km (double)
     */
    public static double toKilometers( double distance ){

        // variables
        double kilometersPerMeter = 0.001;

        // temp return stub
        return distance * kilometersPerMeter;
    }

    /**
     * distance already in meters, return as is
     *
     * @return - distance (double)
     */
    public static double toMeters( double distance ){

        // return distance
        return distance;
    }

    /**
     * returns distance value from meters to miles
     *
     * @return distance in miles (double)
     */
    public static double toMiles( double distance ){

        // variables
        double milesPerMeter = 0.000621371;

        // temp return stub
        return distance * milesPerMeter;
    }

    /**
     * returns distance value from meters to yards
     *
     * @return distance in yards (double)
     */
    public static double toYards( double distance ){

        // variables
        double yardsPerMeter = 1.09361;

        // temp return stub
        return distance * yardsPerMeter;
    }
}
