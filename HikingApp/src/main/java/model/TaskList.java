package model;

import java.io.*;
import java.util.ArrayList;

public class TaskList implements Serializable
{
    private ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Reads message stringd from a file and loads them into an array.
     * @return String[]
     */
    public void readTasksFromFile()
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

    /**
     * Takes the message strings currently in the array and places them in the file
     */
    public void writeTasksToFile()
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

    /**
     * getter for messages array
     * @return String[] logOfHikes
     */
    public Task[] getArrayOfTasks()
    {
        readTasksFromFile();
        return tasks.toArray(new Task[0]);
    }

    public void addTask(String task)
    {
        readTasksFromFile();
        tasks.add(new Task(task, false));
        writeTasksToFile();
    }

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
}
