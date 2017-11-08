/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * Task.java
 * This class is the logic for a Task object
 */
package model;

import java.io.Serializable;

/**
 * This class contains the functionality for making Task objects
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class Task implements Serializable
{
    private String task;
    private boolean checked;

    /**
     * Constructor for a task object
     *
     * @param task The task being created
     * @param checked The checked status
     */
    public Task(String task, boolean checked)
    {
        this.task = task;
        this.checked = checked;
    }

    /**
     * Getter for a task
     *
     * @return A String representation of the task
     */
    public String getTask()
    {
        return task;
    }

    /**
     * Setter for a task
     *
     * @param task The task being set
     */
    public void setTask(String task)
    {
        this.task = task;
    }

    /**
     * Method which checks to see if the task is checked
     *
     * @return A boolean representation of the checked status
     */
    public boolean isChecked()
    {
        return checked;
    }

    /**
     * Setter shich changes the checked status
     *
     * @param checked The new checked status
     */
    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }

}


