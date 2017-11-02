package ui;

import controller.Dashboard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ShowTasks
{
    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        VBox taskBox = new VBox();
        HBox navBox = nav.getNavBar();



        navBox.setPadding(new Insets(Dashboard.PANEL_PADING));
        taskBox.getChildren().addAll(navBox); // add as many controls as needed

        String[] taskList = {"Find backpack", "Pack food and water", "Compass", "Flashlight", "Binoculars"};
        CheckBox[] boxes = new CheckBox[taskList.length];

        

        //taskBox.setPadding(new Insets(10));
        //taskBox.setAlignment(Pos.CENTER);
        taskBox.setSpacing(10);

        // add checkboxes
        for (int i = 0; i < taskList.length; i++)
        {
            CheckBox checkBox = new CheckBox(taskList[i]);
            boxes[i] = checkBox;
            //checkBox.setPrefWidth(200);
            taskBox.getChildren().add(checkBox);
        }



        return new Scene(taskBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
