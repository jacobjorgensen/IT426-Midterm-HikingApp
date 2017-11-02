package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NewTask
{
    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        HBox navBox = nav.getNavBar();
        VBox inputBox = new VBox();

        inputBox.getChildren().add(navBox);

        Label newTask = new Label("Add a New Task:");
        TextField input = new TextField ();

        inputBox.getChildren().addAll(newTask, input);
        inputBox.setSpacing(10);

        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
