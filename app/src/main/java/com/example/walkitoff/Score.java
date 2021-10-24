package com.example.walkitoff;

public class Score {

    /*
    For storing, retrieving, and updating the user's total score and level. To be used by sound and
    theme classes to determine which sounds and themes are unlocked.
     */

    // member data
    private int userLevel = 1;
    private double totalScore = 0;
    private double scoreReq = 200;

    /**
     * default constructor
     */
    public Score(){

    }

    /**
     * calculates the users level
     */
    private void calcLevel(){

        int maxLvl;
        double scoreCurrent, multiplyer = 1.3;
        maxLvl = 15;

        scoreCurrent = totalScore;

        if (scoreCurrent >= scoreReq)
            {
                userLevel += 1;
                scoreCurrent = scoreCurrent - scoreReq;
                scoreReq = scoreReq * multiplyer;
                while((scoreReq % 10) != 0)
                    {
                        scoreReq += 1;
                    }
            }

        if (userLevel == maxLvl)
            {
                scoreCurrent = scoreReq;
            }

        totalScore = scoreCurrent;
    }

    /**
     * gets the current user level from the database
     *
     * @return user level (int)
     */
    private int getLevelFromServer(){

        return 0;
    }

    /**
     * gets the total score from the database
     *
     * @return total score (int)
     */
    private int getScoreFromServer(){

        return 0;
    }

    /**
     * updates the total score in the database
     */
    private void sendScoreToServer(){


    }

    /**
     * used for accessing the total score from outside the class
     *
     * @return totalScore (int)
     */
    public double totalScore(){

        return totalScore;

    }

    /**
     * called when the user is done accumulating points. It updates the score and sends it to the
     * database
     *
     * @param points
     */
    public void updateScore( int points ){

        totalScore = points + totalScore;

    }

    /**
     * used for accessing the user level from outside the class
     *
     * @return userLevel (int)
     */
    public int userLevel(){

        return userLevel;

    }
}
