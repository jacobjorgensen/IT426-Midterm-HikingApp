/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * HomePage.java
 * This class is the scene for showing the home page
 */
package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.MessageReminder;

/**
 * This class contains the functionality for building the home page scene
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class HomePage
{
    private static Text title = new Text("Hello, Jose!");
    private static String[] buttons = {"Hikes", "Tasks", "Messages"};
    private static final int BUTTON_HEIGHT = 75;
    private static final int BUTTON_WIDTH = 200;

    /**
     * This method builds the Home Page scene
     *
     * @return A Scene object representation of the Home UI
     */
    public static Scene getScene()
    {
        MessageReminder messages = new MessageReminder();
        Label remindText = new Label("Don't forget!");
        Label randomReminder = new Label(messages.getRandomMessage());
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(Dashboard.PANEL_PADING));
        box.setSpacing(10);

        title.setStyle("-fx-font-size: 25px;" +
                "-fx-font-family: 'Arial Black'");

        box.getChildren().addAll(title);

        for (int i = 0; i < buttons.length; i++)
        {
            Button button = createButton(buttons[i]);

            box.getChildren().addAll(button);
        }

        randomReminder.setStyle("-fx-text-fill: cadetblue;" +
                "-fx-font-family: 'Franklin Gothic Medium';" +
                "-fx-font-size: 22px;");

        randomReminder.setTextAlignment(TextAlignment.CENTER);
        randomReminder.setAlignment(Pos.CENTER);
        randomReminder.setPrefWidth(300);
        randomReminder.setWrapText(true);

        remindText.setStyle("-fx-font-family: 'Franklin Gothic Book';" +
                "-fx-font-size: 15px");
        remindText.setPadding(new Insets(20, 0, 0 ,0));

        box.getChildren().addAll(remindText, randomReminder);

        return new Scene(box, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }

    private static Button createButton(String buttonName)
    {
        Button button = new Button();

        button.setText(buttonName);
        button.setPrefHeight(BUTTON_HEIGHT);
        button.setPrefWidth(BUTTON_WIDTH);

        button.setStyle("-fx-background-color: #81BEF7;" +
                "-fx-font-family: 'Lucida Console';" +
                "-fx-font-size: 20px;");

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