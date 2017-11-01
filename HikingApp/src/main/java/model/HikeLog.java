package model;

import java.io.*;
import java.util.ArrayList;

public class HikeLog
{
    private Hike[] logOfHikes;

    public Hike[] readHikes()
    {
        ArrayList<Hike> hikeList = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(new File("Hikes.txt"));
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

        logOfHikes = hikeList.toArray(new Hike[0]);

        return logOfHikes;
    }

    public void writeHikes()
    {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("Hikes.txt"));
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            // Write Hike objects to file
            for (int i = 0; i < logOfHikes.length; i++)
            {
                objOut.writeObject(logOfHikes[i]);
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
