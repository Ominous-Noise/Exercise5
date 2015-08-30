package com.id12020261.exercise5;

import java.util.ArrayList;

/**
 * Created by Nathan on 8/29/2015.
 */
public class TrainData {

    //local varibles for class
    public String mPlatform;
    public int mArrivalTime;
    public String mStatus;
    public String mDestination;
    public String mDestinationTime;

    //constructor
    public TrainData(String platform,int arrivalTime, String status, String
            destination, String destinationTime)
    {
        mPlatform = platform;
        mArrivalTime = arrivalTime;
        mStatus = status;
        mDestination = destination;
        mDestinationTime = destinationTime;
    }
    //Array of TrainData objects for list
    public static ArrayList<TrainData> GetTrains() {

        ArrayList<TrainData> trains = new ArrayList<TrainData>();


        return trains;
    }

    // Get and Set methods(not used)
    public String getPlatform()
    {
        return mPlatform;
    }
    public int getTime()
    {
        return mArrivalTime;
    }
    public String getStatus()
    {
        return mStatus;
    }
    public String getDestination()
    {
        return mDestination;
    }
    public String getDestinationTime()
    {
        return mDestinationTime;
    }

    public void setPlatform(String platform)
    {
        mPlatform = platform;
    }
    public void settime(int time)
    {
        mArrivalTime = time;
    }
    public void setStatus(String status)
    {
        mStatus = status;
    }
    public void setDestination(String destination)
    {
        mDestination = destination;
    }
    public void setDestinationtime(String destinationtime)
    {
        mDestinationTime = destinationtime;
    }
}
