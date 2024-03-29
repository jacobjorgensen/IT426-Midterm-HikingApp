/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * ShowHikes.java
 * This class is the scene for showing a hike
 */
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Hike;
import model.HikeLog;

/**
 * This class contains the functionality for building the show all hikes scene
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class ShowHikes
{
    private final static int BUTTON_HEIGHT = 10;
    private final static int BUTTON_WIDTH = 120;
    private static HikeLog hikeLog = new HikeLog();

    /**
     * This method builds the Show Hikes scene
     *
     * @return A Scene object representation of the Show Hike UI
     */
    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        VBox hikeBox = new VBox();
        HBox navBox = nav.getNavBar();
        HBox settings = new HBox();
        Label title = new Label("Hike List");

        Hike[] hikes = hikeLog.getArrayOfHikes();
        String[] buttons = {"Add Hike"};

        hikeBox.setStyle("-fx-background-color: lightblue");

        title.setPadding(new Insets(0, 0, 0, 150));
        title.setStyle("-fx-font-size: 20px;" +
                "-fx-font-family: 'Arial Black'");



        navBox.setPadding(new Insets(Dashboard.PANEL_PADING));
        hikeBox.getChildren().addAll(navBox, title, settings);

        settings.setPadding(new Insets(0, 10, 0, 10));
        settings.setAlignment(Pos.CENTER);
        hikeBox.setSpacing(10);

        // add checkboxes
        for (int i = 0; i < hikes.length; i++)
        {
            final Hike hike = hikes[i];
            Button msg = new Button((hikes[i].getHikeName() + ", in " + hikes[i].getLocation()));
            msg.setAlignment(Pos.CENTER);
            msg.setStyle("-fx-background-color: transparent;" +
                    "-fx-font-family: 'Lucida Console';" +
                    "-fx-font-size: 15px;" +
                    "-fx-text-fill: darkgreen");

            msg.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    Dashboard dash = new Dashboard();
                    dash.stage.setScene(EditHike.getScene(hike));
                }
            });

            hikeBox.getChildren().add(msg);
        }

        for (int i = 0; i < buttons.length; i++)
        {
            Button hikeButton = createButton(buttons[i]);
            settings.getChildren().addAll(hikeButton);
        }

        return new Scene(hikeBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }

    private static Button createButton(String buttonName)
    {
        Button button = new Button();

        button.setText(buttonName);
        button.setPrefHeight(BUTTON_HEIGHT);
        button.setPrefWidth(BUTTON_WIDTH);

        button.setStyle("-fx-background-color: transparent;" +
                "-fx-font-family: 'Lucida Console';" +
                "-fx-font-size: 13px;" +
                "-fx-text-fill: royalblue");
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
