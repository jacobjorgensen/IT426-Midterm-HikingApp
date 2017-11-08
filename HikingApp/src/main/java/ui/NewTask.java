/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * NewTask.java
 * This class is the scene for adding a task
 */
package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.TaskList;

/**
 * This class contains the functionality for building the add task scene
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class NewTask
{
    private static TaskList task = new TaskList();
    private static TextField input = new TextField();
    private static Text confirm;

    /**
     * This method builds the New Task scene
     *
     * @return A Scene object representation of the Add Task form UI
     */
    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        HBox navBox = nav.getNavBar();
        VBox inputBox = new VBox();
        Button addTask = new Button("Add");

        Label newTask = new Label("Add a New Task:");

        inputBox.setStyle("-fx-background-color: lightblue");

        inputBox.setPadding(new Insets(0, 20, 0, 20));
        inputBox.setSpacing(10);

        addTask.setPrefHeight(20);
        addTask.setPrefWidth(60);
        addTask.setStyle("-fx-background-color: cadetblue;" +
                        "-fx-font-family: 'Lucida Console';" +
                        "-fx-font-size: 10px;");

        addTask.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                task.addTask(input.getText());
                confirm = new Text("'" + input.getText() + "'" + " has been added as a task.");
                confirm.setWrappingWidth(350);
                input.setText("");
                inputBox.getChildren().add(confirm);
            }
        });

        inputBox.getChildren().addAll(navBox, newTask, input, addTask);

        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
