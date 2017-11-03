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
        Button submit = new Button("Submit");

        Label newTask = new Label("Add a New Task:");
        TextField input = new TextField ();

        inputBox.setPadding(new Insets(0, 20, 0, 20));
        inputBox.setSpacing(10);

        submit.setPrefHeight(20);
        submit.setPrefWidth(60);
        submit.setStyle("-fx-background-color: cadetblue;" +
                        "-fx-font-family: 'Lucida Console';" +
                        "-fx-font-size: 10px;");
        submit.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });

        inputBox.getChildren().addAll(navBox, newTask, input, submit);


        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
