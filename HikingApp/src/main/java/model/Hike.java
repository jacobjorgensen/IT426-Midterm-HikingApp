package model;

import java.time.LocalDateTime;

public class Hike
{
    private String location;
    private String hikeName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int steps;
    private int avgHeartRate;
    private TaskList tasks;
    private MessageReminder reminders;

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

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getHikeName()
    {
        return hikeName;
    }

    public void setHikeName(String hikeName)
    {
        this.hikeName = hikeName;
    }

    public LocalDateTime getStartTime()
    {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime)
    {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime()
    {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime)
    {
        this.endTime = endTime;
    }

    public int getSteps()
    {
        return steps;
    }

    public void setSteps(int steps)
    {
        this.steps = steps;
    }

    public int getAvgHeartRate()
    {
        return avgHeartRate;
    }

    public void setAvgHeartRate(int avgHeartRate)
    {
        this.avgHeartRate = avgHeartRate;
    }

    public TaskList getTasks()
    {
        return tasks;
    }

    public void setTasks(TaskList tasks)
    {
        this.tasks = tasks;
    }

    public MessageReminder getReminders()
    {
        return reminders;
    }

    public void setReminders(MessageReminder reminders)
    {
        this.reminders = reminders;
    }
}
