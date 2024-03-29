/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * AddHike.java
 * This class is the scene for adding a hike
 */
package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Hike;
import model.HikeLog;

import java.time.LocalDate;

/**
 * This class contains the functionality for building the add hike scene
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class AddHike
{
    private static HikeLog hikes = new HikeLog();
    private static Text confirm;

    /**
     * This method builds the Add Hike scene
     *
     * @return A Scene object representation of the Add hike form UI
     */
    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        HBox navBox = nav.getNavBar();
        VBox inputBox = new VBox();
        Button submit = new Button("Submit");

        inputBox.setStyle("-fx-background-color: lightblue");

        //going to have to copy paste and make redundant because they will all require specific input types.
        Label location = new Label("Location");
        TextField locationInput = new TextField();

        Label name = new Label("Hike Name");
        TextField nameInput = new TextField();

        Label start = new Label("Start Time");
        DatePicker startInput = new DatePicker(LocalDate.now());

        Label end = new Label("End Time");
        DatePicker endInput = new DatePicker(LocalDate.now());

        Label steps = new Label("Steps");
        TextField stepsInput = new TextField("0");

        Label heart = new Label("Avg. Heart Rate");
        TextField heartInput = new TextField("0");

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
                Hike hike = new Hike(hikes.getNumberOfHikes(), locationInput.getText(), nameInput.getText(),
                        startInput.getValue(), endInput.getValue(), Integer.parseInt(stepsInput.getText()),
                        Integer.parseInt(heartInput.getText()));
                hikes.addHike(hike);
                locationInput.setText("");
                nameInput.setText("");
                stepsInput.setText("");
                heartInput.setText("");

                confirm = new Text("Hike has been added to log.");
                confirm.setWrappingWidth(350);
                inputBox.getChildren().add(confirm);
            }
        });

        inputBox.getChildren().addAll(navBox, location, locationInput,
                name, nameInput, start, startInput, end, endInput,steps, 
                stepsInput, heart, heartInput, submit);


        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
