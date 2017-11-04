/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/1/2017
 * Hike.java
 * This class represents a Hike
 */
package model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This class stores all of the information relating to a hike.
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class Hike implements Serializable
{
    //fields
    private String location;
    private String hikeName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int steps;
    private int avgHeartRate;
    private TaskList tasks;
    private MessageReminder reminders;

    /**
     * Construtor for the Hike class
     * @param location : Location of the Hike
     * @param hikeName : Name of the Hike
     * @param startTime : Time to start hike
     * @param endTime : Time to end hike
     * @param steps : steps taken during hike
     * @param avgHeartRate : average heart rate during hike
     */
    public Hike(String location, String hikeName, LocalDateTime startTime,
                LocalDateTime endTime, int steps, int avgHeartRate)
    {
        this.location = location;
        this.hikeName = hikeName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.steps = steps;
        this.avgHeartRate = avgHeartRate;
        this.tasks = new TaskList();
        this.reminders = new MessageReminder();
    }

    /**
     * getter for location
     * @return String location
     */
    public String getLocation()
    {
        return location;
    }

    /**
     * setter for location
     * @param location : location of the hike
     */
    public void setLocation(String location)
    {
        this.location = location;
    }

    /**
     * getter for hikeName
     * @return String hikeName
     */
    public String getHikeName()
    {
        return hikeName;
    }

    /**
     * setter for hikeName
     * @param hikeName : name of the hike
     */
    public void setHikeName(String hikeName)
    {
        this.hikeName = hikeName;
    }

    /**
     * getter for startTime
     * @return LocalDateTime startTime
     */
    public LocalDateTime getStartTime()
    {
        return startTime;
    }

    /**
     * setter for startTime
     * @param startTime : Time to start hike
     */
    public void setStartTime(LocalDateTime startTime)
    {
        this.startTime = startTime;
    }

    /**
     * getter for endTime
     * @return LocalDateTime endTime
     */
    public LocalDateTime getEndTime()
    {
        return endTime;
    }

    /**
     * setter for endTime
     * @param endTime : Time to end hike
     */
    public void setEndTime(LocalDateTime endTime)
    {
        this.endTime = endTime;
    }

    /**
     * getter for steps
     * @return int steps
     */
    public int getSteps()
    {
        return steps;
    }

    /**
     * setter for steps
     * @param steps : Steps taken during hike
     */
    public void setSteps(int steps)
    {
        this.steps = steps;
    }

    /**
     * getter for avgHeartRate
     * @return int avgHeartRate
     */
    public int getAvgHeartRate()
    {
        return avgHeartRate;
    }

    /**
     * setter for avgHeartRate
     * @param avgHeartRate : Average heart rate during the hike
     */
    public void setAvgHeartRate(int avgHeartRate)
    {
        this.avgHeartRate = avgHeartRate;
    }

    /**
     * getter for tasks
     * @return TaskList tasks
     */
    public TaskList getTasks()
    {
        return tasks;
    }

    /**
     * setter for tasks
     * @param tasks : Tasks to complete before the hike
     */
    public void setTasks(TaskList tasks)
    {
        this.tasks = tasks;
    }

    /**
     * getter for reminders
     * @return MessageReminder reminders
     */
    public MessageReminder getReminders()
    {
        return reminders;
    }

    /**
     * setter for reminders
     * @param reminders : reminders about the hike
     */
    public void setReminders(MessageReminder reminders)
    {
        this.reminders = reminders;
    }
}
