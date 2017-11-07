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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Task;
import model.TaskList;

public class ShowTasks
{
    private final static int BUTTON_HEIGHT = 10;
    private final static int BUTTON_WIDTH = 120;
    private static TaskList tasks = new TaskList();


    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        VBox taskBox = new VBox();
        HBox navBox = nav.getNavBar();
        HBox settings = new HBox();
        Label title = new Label("Task List");
        Button reset = createButton("Reset Tasks");

        Task[] taskList = tasks.getArrayOfTasks();
        String[] buttons = {"Add Task", "Edit", "Delete Task"};

        title.setPadding(new Insets(0, 0, 0, 150));
        title.setStyle("-fx-font-size: 20px;" +
                "-fx-font-family: 'Arial Black'");


        navBox.setPadding(new Insets(Dashboard.PANEL_PADING));
        taskBox.getChildren().addAll(navBox, title, settings);

        settings.setPadding(new Insets(0, 10, 0, 10));
        settings.setAlignment(Pos.CENTER);
        taskBox.setSpacing(10);

        // add checkboxes
        for (int i = 0; i < taskList.length; i++)
        {
            CheckBox checkBox = new CheckBox(taskList[i].getTask());
            checkBox.setPadding(new Insets(0,0,0, 20));

            checkBox.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Task task = new Task(checkBox.getText(), true);
                task.setChecked(true);
            }
        });

            taskBox.getChildren().addAll(checkBox);
        }

        for (int i = 0; i < buttons.length; i++)
        {
            Button taskButton = createButton(buttons[i]);
            settings.getChildren().addAll(taskButton);
        }

        return new Scene(taskBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }

    public static Button createButton(String buttonName)
    {
        Button button = new Button();

        button.setText(buttonName);
        button.setPrefHeight(BUTTON_HEIGHT);
        button.setPrefWidth(BUTTON_WIDTH);

        button.setStyle("-fx-background-color: transparent;" +
                "-fx-font-family: 'Lucida Console';" +
                "-fx-font-size: 10px;" +
                "-fx-text-fill: cadetblue");
        button.setUnderline(true);

        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Dashboard.switchScenes(buttonName);
            }
        });

        return button;
    }
}
