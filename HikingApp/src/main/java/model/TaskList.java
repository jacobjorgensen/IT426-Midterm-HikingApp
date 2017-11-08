/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * TaskList.java
 * This class is the data structure for the tasks list
 */
package model;

import java.io.*;
import java.util.ArrayList;

/**
 * This class contains the functionality for File IO and
 * list management for the list of Tasks
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class TaskList implements Serializable
{
    private ArrayList<Task> tasks = new ArrayList<>();


    /**
     * This method retrieves a list of tasks from the Tasks.txt file
     *
     * @return Am array of Task objects
     */
    public Task[] getArrayOfTasks()
    {
        readTasksFromFile();
        return tasks.toArray(new Task[0]);
    }

    /**
     * This method adds a new task to the list
     *
     * @param task The task being added
     */
    public void addTask(String task)
    {
        readTasksFromFile();
        tasks.add(new Task(task, false));
        writeTasksToFile();
    }

    /**
     * This method removes a specified task from the list
     *
     * @param task The task being removed
     */
    public void removeTask(String task)
    {
        readTasksFromFile();
        for (int i = 0; i < tasks.size(); i++)
        {
            if (tasks.get(i).getTask().equals(task))
            {
                tasks.remove(i);
            }
        }
        writeTasksToFile();
    }

    /**
     * This method resets the list of tasks to unchecked
     */
    public void resetTasksToUnchecked()
    {
        readTasksFromFile();
        for (int i = 0; i < tasks.size(); i++)
        {
            tasks.get(i).setChecked(false);
        }
        writeTasksToFile();
    }

    /**
     * This method swaps the checked boolean for a given task
     *
     * @param task The task which the checked status is being changed for
     */
    public void changeChecked(String task)
    {
        readTasksFromFile();
        for (int i = 0; i < tasks.size(); i++)
        {
            if (task.equals(tasks.get(i).getTask()))
            {
                if(tasks.get(i).isChecked())
                {
                    tasks.get(i).setChecked(false);
                }
                else
                {
                    tasks.get(i).setChecked(true);
                }
            }
        }
        writeTasksToFile();
    }

    private void readTasksFromFile()
    {
        try (FileInputStream fileIn = new FileInputStream(new File("files/Tasks.txt"));
             ObjectInputStream objIn = new ObjectInputStream(fileIn)){

            tasks.clear();
            // Read task objects
            while (true)
            {
                Task task = (Task) objIn.readObject();

                tasks.add(task);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (EOFException e) {
            System.out.println("This is fine, end of file.");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeTasksToFile()
    {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("files/Tasks.txt"));
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            // Write Hike objects to file
            for (int i = 0; i < tasks.size(); i++)
            {
                objOut.writeObject(tasks.get(i));
            }

            objOut.close();
            fileOut.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}
