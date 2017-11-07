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

public class DeleteTask
{
    private static TaskList task = new TaskList();
    private static TextField input = new TextField();
    private static Text confirm;

    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        HBox navBox = nav.getNavBar();
        VBox inputBox = new VBox();
        Button deleteTask = new Button("Delete");

        Label newTask = new Label("Enter the task you would like to delete:");


        inputBox.setPadding(new Insets(0, 20, 0, 20));
        inputBox.setSpacing(10);

        deleteTask.setPrefHeight(20);
        deleteTask.setPrefWidth(60);
        deleteTask.setStyle("-fx-background-color: cadetblue;" +
                "-fx-font-family: 'Lucida Console';" +
                "-fx-font-size: 10px;");

        deleteTask.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                task.removeTask(input.getText());
                confirm = new Text("'" + input.getText() + "'" + " has been deleted from the task list.");
                confirm.setWrappingWidth(350);
                input.setText("");
                inputBox.getChildren().add(confirm);
            }
        });

        inputBox.getChildren().addAll(navBox, newTask, input, deleteTask);

        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
