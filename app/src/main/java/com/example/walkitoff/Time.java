package com.example.walkitoff;

public class Time {

    private int hour, minute;

    public Time( int inHour, int inMinute ){

        hour = inHour;
        minute = inMinute;
    }

    public String parseTime(){

        return String.valueOf( hour ) + String.valueOf( minute );
    }

    public void changeHour( int inHour ){

        hour = inHour;
    }

    public void changeMinute( int inMinute ){

        minute = inMinute;
    }

    public int getHour(){

        return hour;
    }

    public int getMinute(){

        return minute;
    }
}
