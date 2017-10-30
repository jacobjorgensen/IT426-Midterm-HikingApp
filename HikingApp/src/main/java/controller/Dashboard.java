package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.Messages;
import ui.HomePage;
import ui.ShowHikes;
import ui.ShowTasks;

public class Dashboard extends Application
{
    public static final int WIN_WIDTH = 400;
    public static final int WIN_HEIGHT = 400;
    public static final int PANEL_PADING = 10;
    private static final int FONT_SIZE = 24;
    private static Stage stage;

    @Override
    public void start(Stage stage)
    {
        // save the stage for later
        this.stage = stage;

        // show the waiting screen
        stage.setScene(HomePage.getScene());

        stage.show();

    }

    public static void switchScenes(String buttonName)
    {
        switch (buttonName) {
            case "Home": stage.setScene(HomePage.getScene()); break;

            case "Hikes": stage.setScene(ShowHikes.getScene()); break;

            case "Tasks": stage.setScene(ShowTasks.getScene()); break;

            case "Messages": stage.setScene(Messages.getScene()); break;
        }
        stage.show();
    }





}
