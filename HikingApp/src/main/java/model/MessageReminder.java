/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * MessageReminder.java
 * This class controls message reminders for the app
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class contains the functionality for File IO and
 * list management for the list of reminders
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class MessageReminder implements Serializable
{
    private ArrayList<String> messages = new ArrayList<>();

    /**
     * Getter for an array of message
     *
     * @return A String array of all the messages
     */
    public String[] getArrayOfMessages()
    {
        readMessagesFromFile();
        return messages.toArray(new String[0]);
    }

    /**
     * Thos method adds a new message to the list
     *
     * @param message The message being added
     */
    public void addMessage(String message)
    {
        readMessagesFromFile();
        messages.add(message);
        writeMessagesToFile();
    }

    /**
     * This method removes a given message from the list
     *
     * @param message The message being removed
     */
    public void removeMessage(String message)
    {
        readMessagesFromFile();
        for (int i = 0; i < messages.size(); i++)
        {
            if (messages.get(i).equals(message))
            {
                messages.remove(i);
            }
        }
        writeMessagesToFile();
    }

    /**
     * This method retrieves a random message from the list
     *
     * @return A String representation of a random message
     */
    public String getRandomMessage()
    {
        readMessagesFromFile();
        Random random = new Random();
        return messages.get(random.nextInt(messages.size()));
    }

    private void readMessagesFromFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("files/Messages.txt")))
        {
            messages.clear();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                messages.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
            System.out.println("File not found");
        } catch (IOException e) {
            e.getMessage();
            System.out.println("Error initializing stream");
        }
    }

    private void writeMessagesToFile()
    {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("files/Messages.txt"));

            // Write Hike objects to file
            for (int i = 0; i < messages.size(); i++)
            {
                writer.println(messages.get(i));

            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.getMessage();
            System.out.println("File not found");
        }
    }
}
