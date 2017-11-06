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
     * Reads Hike objects from a file and loads them into an array.
     * @return Hike[]
     */
    public Hike[] readHikes()
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
     * and saves them to a file.
     */
    public void writeHikes()
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

    /**
     * getter for logOfHikes
     * @return Hike[] logOfHikes
     */
    public Hike[] getArrayOfHikes()
    {
        readHikes();
        return logOfHikes.toArray(new Hike[0]);
    }

    /**
     * Adds a hike to the hike log and saves it to the file
     * @param hike
     */
    public void addHike(Hike hike)
    {
        logOfHikes.add(hike);
        writeHikes();
    }
}
