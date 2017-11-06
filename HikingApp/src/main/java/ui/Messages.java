package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.MessageReminder;

public class Messages
{
    private static MessageReminder reminders = new MessageReminder();

    // Scene which shows messages
    // perhaps a toast type alert
    // if so this class can probably be removed,
    // using MessageReminder directly from the Dashboard
    // However, this would break MVC
    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        HBox navBox = nav.getNavBar();
        VBox messages = new VBox();
        Label title = new Label("Message Reminders");


        title.setPadding(new Insets(0, 0, 0, 90));
        title.setStyle("-fx-font-size: 20px;" +
                "-fx-font-family: 'Arial Black'");

        navBox.setPadding(new Insets(Dashboard.PANEL_PADING));
        messages.getChildren().addAll(navBox, title);

        String[] messageReminders =  reminders.getArrayOfMessages();

        for (int i = 0; i < messageReminders.length; i++)
        {
            Text msg = new Text(messageReminders[i]);
            System.out.println(msg);
            messages.getChildren().add(msg);

        }

        messages.setSpacing(10);

        return new Scene(messages, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }


}
