/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/1/2017
 * Hike.java
 * This class represents a Hike
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class stores all of the information relating to a hike.
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class Hike implements Serializable
{
    //fields
    private int ID;
    private String location;
    private String hikeName;
    private LocalDate startTime;
    private LocalDate endTime;
    private int steps;
    private int avgHeartRate;

    /**
     * Construtor for the Hike class
     *
     * @param ID : Incremented ID for each hike
     * @param location : Location of the Hike
     * @param hikeName : Name of the Hike
     * @param startTime : Time to start hike
     * @param endTime : Time to end hike
     * @param steps : steps taken during hike
     * @param avgHeartRate : average heart rate during hike
     */
    public Hike(int ID, String location, String hikeName, LocalDate startTime,
                LocalDate endTime, int steps, int avgHeartRate)
    {
        this.ID = ID;
        this.location = location;
        this.hikeName = hikeName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.steps = steps;
        this.avgHeartRate = avgHeartRate;
    }

    /**
     * Getter for ID
     *
     * @return int ID
     */
    public int getID()
    {
        return ID;
    }

    /**
     * Setter for ID
     * @param ID : ID for a hike
     */
    public void setID(int ID)
    {
        this.ID = ID;
    }

    /**
     * Getter for location
     *
     * @return String location
     */
    public String getLocation()
    {
        return location;
    }

    /**
     * Setter for location
     *
     * @param location : location of the hike
     */
    public void setLocation(String location)
    {
        this.location = location;
    }

    /**
     * Getter for hikeName
     *
     * @return String hikeName
     */
    public String getHikeName()
    {
        return hikeName;
    }

    /**
     * Setter for hikeName
     *
     * @param hikeName : name of the hike
     */
    public void setHikeName(String hikeName)
    {
        this.hikeName = hikeName;
    }

    /**
     * Getter for startTime
     *
     * @return LocalDateTime startTime
     */
    public LocalDate getStartTime()
    {
        return startTime;
    }

    /**
     * Setter for startTime
     *
     * @param startTime : Time to start hike
     */
    public void setStartTime(LocalDate startTime)
    {
        this.startTime = startTime;
    }

    /**
     * Getter for endTime
     *
     * @return LocalDateTime endTime
     */
    public LocalDate getEndTime()
    {
        return endTime;
    }

    /**
     * Setter for endTime
     *
     * @param endTime : Time to end hike
     */
    public void setEndTime(LocalDate endTime)
    {
        this.endTime = endTime;
    }

    /**
     * Getter for steps
     *
     * @return int steps
     */
    public int getSteps()
    {
        return steps;
    }

    /**
     * Setter for steps
     *
     * @param steps : Steps taken during hike
     */
    public void setSteps(int steps)
    {
        this.steps = steps;
    }

    /**
     * Getter for avgHeartRate
     *
     * @return int avgHeartRate
     */
    public int getAvgHeartRate()
    {
        return avgHeartRate;
    }

    /**
     * Setter for avgHeartRate
     *
     * @param avgHeartRate : Average heart rate during the hike
     */
    public void setAvgHeartRate(int avgHeartRate)
    {
        this.avgHeartRate = avgHeartRate;
    }
}
