/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * DeleteMessage.java
 * This class is the scene for deleting a message
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
 * This class contains the functionality for building the delete message scene
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class DeleteMessage
{
    private static MessageReminder message = new MessageReminder();
    private static TextField input = new TextField();
    private static Text confirm;

    /**
     * This method builds the Delete Message scene
     *
     * @return A Scene object representation of the Delete message form UI
     */
    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        HBox navBox = nav.getNavBar();
        VBox inputBox = new VBox();
        Button deleteMessage = new Button("Delete");

        Label newMessage = new Label("Enter the reminder you would like to delete:");

        inputBox.setPadding(new Insets(0, 20, 0, 20));
        inputBox.setSpacing(10);

        deleteMessage.setPrefHeight(20);
        deleteMessage.setPrefWidth(60);
        deleteMessage.setStyle("-fx-background-color: cadetblue;" +
                "-fx-font-family: 'Lucida Console';" +
                "-fx-font-size: 10px;");

        deleteMessage.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                message.removeMessage(input.getText());
                confirm = new Text("'" + input.getText() + "'" + " has been deleted from your reminders.");
                confirm.setWrappingWidth(350);
                input.setText("");
                inputBox.getChildren().add(confirm);
            }
        });

        inputBox.getChildren().addAll(navBox, newMessage, input, deleteMessage);

        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
