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
import model.MessageReminder;
import model.TaskList;

public class AddMessage
{
    private static MessageReminder message = new MessageReminder();
    private static TextField input = new TextField();

    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        HBox navBox = nav.getNavBar();
        VBox inputBox = new VBox();
        Button addMessage = new Button("Add");

        Label newTask = new Label("Add a New Reminder:");

        inputBox.setPadding(new Insets(0, 20, 0, 20));
        inputBox.setSpacing(10);

        addMessage.setPrefHeight(20);
        addMessage.setPrefWidth(60);
        addMessage.setStyle("-fx-background-color: cadetblue;" +
                "-fx-font-family: 'Lucida Console';" +
                "-fx-font-size: 10px;");

        addMessage.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                message.addMessage(input.getText());
                input.setText("");
            }
        });

        inputBox.getChildren().addAll(navBox, newTask, input, addMessage);


        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
