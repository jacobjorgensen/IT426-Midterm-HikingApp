package ui;

import controller.Dashboard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ShowHikes
{
    public static Scene getScene()
    {
        Text text = new Text("Hike History");
        NavBar nav = new NavBar();
        HBox box = nav.getNavBar();

        // center the vBox and add some padding
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(Dashboard.PANEL_PADING));

        box.getChildren().addAll(text); // add as many controls as needed

        return new Scene(box, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
