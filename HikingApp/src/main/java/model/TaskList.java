package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList
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

            // Read Hike objects
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
        Task[] tasksArray = new Task[tasks.size()];
        tasksArray = tasks.toArray(new Task[0]);
        return tasksArray;
    }

    public void addTask(String task)
    {
        tasks.add(new Task(task, false));
        writeTasksToFile();
    }

    public void removeTask(int index)
    {
        tasks.remove(index);
        writeTasksToFile();
    }
}
