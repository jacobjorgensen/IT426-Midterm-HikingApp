package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageReminder
{
    private ArrayList<String> messages;

    /**
     * Reads message stringd from a file and loads them into an array.
     * @return String[]
     */
    public void readMessages()
    {
        ArrayList<String> messageList = new ArrayList<>();

        try (Scanner fileIn = new Scanner(new File("Messages.txt")); ){

            String message = null;
            // Read Messages objects
            while (fileIn.hasNext())
            {
                message = fileIn.nextLine();
                messageList.add(message);
            }
            fileIn.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    /**
     * Takes the message strings currently in the array and places them in the file
     */
    public void writeMessages()
    {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("Messages.txt"));

            // Write Hike objects to file
            for (int i = 0; i < messages.size(); i++)
            {
                writer.write(messages.get(i));
            }
            writer.close();

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
    public String[] getLogOfMessages()
    {
        String[] messageArray = new String[messages.size()];
        messageArray = messages.toArray(new String[0]);
        return messageArray;
    }

    public void addMessage(String message)
    {
        messages.add(message);
        writeMessages();
    }

    public void removeMessage(int index)
    {
        messages.remove(index);
    }
}
