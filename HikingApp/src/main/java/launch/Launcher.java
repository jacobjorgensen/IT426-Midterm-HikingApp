/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 10/26/2017
 * Launcher.java
 * This class is the entry point for the program
 */
package launch;

import controller.Dashboard;
import javafx.application.Application;

/**
 * This class is the entry point for the program. The main method
 * handles user input accordingly
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class Launcher
{
    /**
     * This is the entry point to the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) { Application.launch(Dashboard.class, args); }// end main()
}// end Launcher.class
