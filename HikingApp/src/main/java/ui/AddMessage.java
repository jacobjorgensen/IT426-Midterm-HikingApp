/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * AddMessage.java
 * This class is the scene for adding a message
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
import model.MessageReminder;

/**
 * This class contains the functionality for building the add message scene
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class AddMessage
{
    private static MessageReminder message = new MessageReminder();
    private static TextField input = new TextField();
    private static Text confirm;

    /**
     * This method builds the Add Message scene
     *
     * @return A Scene object representation of the Add message form UI
     */
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

        inputBox.getChildren().addAll(navBox, newTask, input, addMessage);

        addMessage.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                message.addMessage(input.getText());
                confirm = new Text("'" + input.getText() + "'" + " has been added as a reminder.");
                confirm.setWrappingWidth(350);
                input.setText("");
                inputBox.getChildren().add(confirm);
            }
        });
        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
