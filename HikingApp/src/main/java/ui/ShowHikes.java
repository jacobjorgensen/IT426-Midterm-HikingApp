package ui;

import controller.Dashboard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ShowHikes
{
    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        HBox box = nav.getNavBar();

        box.setPadding(new Insets(Dashboard.PANEL_PADING));

        //Text text = new Text("Hike History");
        //box.getChildren().addAll(text); // add as many controls as needed

        return new Scene(box, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
