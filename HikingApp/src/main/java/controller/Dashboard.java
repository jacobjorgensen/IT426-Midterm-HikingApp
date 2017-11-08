/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * Dashboard.java
 * This class has the functionality for switching scenes
 */
package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.*;

import java.io.File;
import java.net.MalformedURLException;

/**
 * This class contains the functionality for switching scenes
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class Dashboard extends Application
{
    public static final int WIN_WIDTH = 400;
    public static final int WIN_HEIGHT = 600;
    public static final int PANEL_PADING = 10;
    public static Stage stage;

    /**
     * This method starts the GUI application
     *
     * @param stage The stage being set up for the application
     */
    @Override
    public void start(Stage stage)
    {
        // save the stage for later
        this.stage = stage;
        stage.setTitle("Hiking App");
        // show the waiting screen
        stage.setScene(HomePage.getScene());

        stage.show();
    }

    /**
     * This method decides which scene to load based off the button pressed
     *
     * @param buttonName The button that was pressed elsewhere in the program
     */
    public static void switchScenes(String buttonName)
    {
        switch (buttonName)
        {
            case "Home": stage.setScene(HomePage.getScene()); break;

            case "Hikes": stage.setScene(ShowHikes.getScene()); break;

            case "Add Hike": stage.setScene(AddHike.getScene()); break;

            case "Tasks": stage.setScene(ShowTasks.getScene()); break;

            case "Messages": stage.setScene(Messages.getScene()); break;

            case "Add Task": stage.setScene(NewTask.getScene()); break;

            case "Delete Task": stage.setScene(DeleteTask.getScene()); break;

            case "Add Reminder": stage.setScene(AddMessage.getScene()); break;

            case "Delete Reminder": stage.setScene(DeleteMessage.getScene()); break;
        }

        stage.show();
    }
}
