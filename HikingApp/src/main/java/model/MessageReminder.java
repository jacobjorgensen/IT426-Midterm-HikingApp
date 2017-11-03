package model;

import java.io.*;
import java.util.ArrayList;

public class MessageReminder
{
    private ArrayList<String> messages = new ArrayList<>();

    /**
     * Reads message stringd from a file and loads them into an array.
     * @return String[]
     */
    public void readMessagesFromFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("files/Messages.txt")))
        {
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

    /**
     * Takes the message strings currently in the array and places them in the file
     */
    public void writeMessagesToFile()
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

    /**
     * getter for messages array
     * @return String[] logOfHikes
     */
    public String[] getArrayOfMessages()
    {
        String[] messageArray = new String[messages.size()];
        messageArray = messages.toArray(new String[0]);
        return messageArray;
    }

    public void addMessage(String message)
    {
        messages.add(message);
        writeMessagesToFile();
    }

    public void removeMessage(int index)
    {
        messages.remove(index);
        writeMessagesToFile();
    }
}
