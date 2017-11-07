package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Hike;
import model.HikeLog;

public class AddHike
{
    private static HikeLog hikes = new HikeLog();

    public static Scene getScene()
    {
        NavBar nav = new NavBar();
        HBox navBox = nav.getNavBar();
        VBox inputBox = new VBox();
        Button submit = new Button("Submit");
        String[] fields = new String[]{"Location", "Hike Name", "Start Time", "End Time", "Steps", "Avg. Heart Rate"};

        //going to have to copy paste and make redundant because they will all require specific input types.
        Label location = new Label("Location");
        TextField locationInput = new TextField();

        Label name = new Label("Hike Name");
        TextField nameInput = new TextField();

        Label start = new Label("Start Time");
        DatePicker startInput = new DatePicker();

        Label end = new Label("End Time");
        DatePicker endInput = new DatePicker();

        Label steps = new Label("Steps");
        TextField stepsInput = new TextField();

        Label heart = new Label("Avg. Heart Rate");
        TextField heartInput = new TextField();

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
                Hike hike = new Hike(locationInput.getText(), nameInput.getText(),
                        startInput.getValue(), endInput.getValue(), Integer.parseInt(stepsInput.getText()),
                        Integer.parseInt(heartInput.getText()));
                hikes.addHike(hike);
                locationInput.setText("");
                nameInput.setText("");
                stepsInput.setText("");
                heartInput.setText("");
            }
        });

        inputBox.getChildren().addAll(navBox, location, locationInput,
                name, nameInput, start, startInput, end, endInput,steps, 
                stepsInput, heart, heartInput, submit);


        return new Scene(inputBox, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }
}
