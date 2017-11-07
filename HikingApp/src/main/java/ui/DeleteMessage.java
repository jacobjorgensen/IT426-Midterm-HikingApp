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

public class DeleteMessage
{
    private static MessageReminder message = new MessageReminder();
    private static TextField input = new TextField();
    private static Text confirm;

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
                input.setText("");
                inputBox.getChildren().add(confirm);
            }
        });

        inputBox.getChildren().addAll(navBox, newMessage, input, deleteMessage);

        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
