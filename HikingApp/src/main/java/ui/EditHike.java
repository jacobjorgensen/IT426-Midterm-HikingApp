/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * EditHike.java
 * This class is the scene for editing a hike
 */
package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Hike;
import model.HikeLog;

/**
 * This class contains the functionality for building the edit hike scene
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class EditHike
{
    private static HikeLog hikes = new HikeLog();

    /**
     * This method builds the Edit hike scene
     *
     * @return A Scene object representation of the Edit Hike form UI
     */
    public static Scene getScene(Hike hike)
    {
        NavBar nav = new NavBar();
        HBox navBox = nav.getNavBar();
        VBox inputBox = new VBox();
        Button submit = new Button("Submit");
        String[] fields = new String[]{"Location", "Hike Name", "Start Time", "End Time", "Steps", "Avg. Heart Rate"};

        //going to have to copy paste and make redundant because they will all require specific input types.
        Label location = new Label("Location");
        TextField locationInput = new TextField(hike.getLocation());

        Label name = new Label("Hike Name");
        TextField nameInput = new TextField(hike.getHikeName());

        Label start = new Label("Start Time");
        DatePicker startInput = new DatePicker(hike.getStartTime());

        Label end = new Label("End Time");
        DatePicker endInput = new DatePicker(hike.getEndTime());

        Label steps = new Label("Steps");
        TextField stepsInput = new TextField(String.valueOf(hike.getSteps()));

        Label heart = new Label("Avg. Heart Rate");
        TextField heartInput = new TextField(String.valueOf(hike.getAvgHeartRate()));

        inputBox.setPadding(new Insets(0, 20, 0, 20));
        inputBox.setSpacing(10);


        submit.setPrefHeight(20);
        submit.setPrefWidth(60);
        submit.setStyle("-fx-background-color: cadetblue;" +
                "-fx-font-family: 'Lucida Console';" +
                "-fx-font-size: 10px;");

        submit.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hike.setLocation(locationInput.getText());
                hike.setHikeName(nameInput.getText());
                hike.setStartTime(startInput.getValue());
                hike.setEndTime(endInput.getValue());
                hike.setSteps(Integer.parseInt(stepsInput.getText()));
                hike.setAvgHeartRate(Integer.parseInt(heartInput.getText()));
                hikes.updateHike(hike.getID(), hike);
            }
        });

        inputBox.getChildren().addAll(navBox, location, locationInput,
                name, nameInput, start, startInput, end, endInput,steps,
                stepsInput, heart, heartInput, submit);


        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
