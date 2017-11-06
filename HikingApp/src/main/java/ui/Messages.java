package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private final static int BUTTON_HEIGHT = 10;
    private final static int BUTTON_WIDTH = 100;

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
        HBox settings = new HBox();
        Label title = new Label("Message Reminders");
        String[] buttons = {"Add Reminder", "Edit", "Delete"};


        title.setPadding(new Insets(0, 0, 0, 90));
        title.setStyle("-fx-font-size: 20px;" +
                "-fx-font-family: 'Arial Black'");

        navBox.setPadding(new Insets(Dashboard.PANEL_PADING));

        messages.getChildren().addAll(navBox, title, settings);
        messages.setSpacing(10);

        String[] messageReminders =  reminders.getArrayOfMessages();

        for (int i = 0; i < messageReminders.length; i++)
        {
            Text msg = new Text(messageReminders[i]);
            messages.getChildren().add(msg);

        }

        settings.setPadding(new Insets(0, 10, 0, 10));
        settings.setAlignment(Pos.CENTER);

        for (int i = 0; i < buttons.length; i++)
        {
            Button msgButton = createButton(buttons[i]);
            settings.getChildren().addAll(msgButton);
        }

        return new Scene(messages, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
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
