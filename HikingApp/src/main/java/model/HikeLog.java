/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/1/2017
 * HikeLog.java
 * This class stores all of the individual hikes
 */
package model;

import java.io.*;
import java.util.ArrayList;

/**
 * This class stores all of the individual hikes.
 * Also, reads and writes the hike objects to/from a text file.
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class HikeLog
{
    private ArrayList<Hike> logOfHikes = new ArrayList<>();

    /**
     * Getter for logOfHikes
     *
     * @return Hike[] logOfHikes
     */
    public Hike[] getArrayOfHikes()
    {
        readHikes();
        return logOfHikes.toArray(new Hike[0]);
    }

    /**
     * Adds a hike to the hike log and saves it to the file
     *
     * @param hike The hike being added
     */
    public void addHike(Hike hike)
    {
        readHikes();
        logOfHikes.add(hike);
        writeHikes();
    }

    /**
     * Gets the names of all hikes you've been on.
     *
     * @return String[] hikeNames A String array representation of the hike names
     */
    public String[] getHikeNames()
    {
        readHikes();
        String[] hikeNames = new String[logOfHikes.size()];

        for (int i = 0; i < hikeNames.length; i++)
        {
            hikeNames[i] = logOfHikes.get(i).getHikeName();
        }

        return hikeNames;
    }

    /**
     * This method updates a already present hike with updated information
     *
     * @param ID The unique identifier for the hike to be updated
     * @param hike The new Hike object information
     */
    public void updateHike(int ID, Hike hike)
    {
        readHikes();
        for (int i = 0; i < logOfHikes.size(); i++)
        {
            if(logOfHikes.get(i).getID() == ID)
            {
                logOfHikes.set(i, hike);
            }
        }

        writeHikes();
    }

    /**
     * Getter for the number of hikes
     *
     * @return An int representation of the number of hikes
     */
    public int getNumberOfHikes()
    {
        readHikes();
        return logOfHikes.size();
    }

    /**
     * Reads Hike objects from a file and loads them into an array.
     *
     * @return Hike[]
     */
    private Hike[] readHikes()
    {
        ArrayList<Hike> hikeList = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(new File("files/Hikes.txt"));
             ObjectInputStream objIn = new ObjectInputStream(fileIn)){

            // Read Hike objects
            while (true)
            {
                Hike hike = (Hike) objIn.readObject();

                hikeList.add(hike);

                System.out.println(hike.toString());
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

        logOfHikes = hikeList;

        return hikeList.toArray(new Hike[0]);
    }

    /**
     * Takes the Hike objects currently in the logOfHikes array
     *
     * and saves them to a file.
     */
    private void writeHikes()
    {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("files/Hikes.txt"));
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            // Write Hike objects to file
            for (int i = 0; i < logOfHikes.size(); i++)
            {
                objOut.writeObject(logOfHikes.get(i));
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
