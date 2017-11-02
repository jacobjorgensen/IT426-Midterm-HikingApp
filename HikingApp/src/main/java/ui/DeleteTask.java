package ui;

import controller.Dashboard;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class DeleteTask
{
    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        HBox navBox = nav.getNavBar();

        return new Scene(navBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
