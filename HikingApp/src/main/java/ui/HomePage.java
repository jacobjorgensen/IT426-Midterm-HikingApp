package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class HomePage
{
    private static Text title = new Text("Hello, Jose!");
    private static String[] buttons = {"Hikes", "Tasks", "Messages"};
    private static final int BUTTON_HEIGHT = 75;
    private static final int BUTTON_WIDTH = 200;

    public static Scene getScene()
    {
        BorderPane parentPanel = new BorderPane();

        HBox topTitle = new HBox(); //nested panel
        topTitle.setAlignment(Pos.CENTER);
        parentPanel.setTop(topTitle);
        topTitle.setPadding(new Insets(Dashboard.PANEL_PADING));

        title.setStyle("-fx-font-size: 25px;" +
                        "-fx-font-family: 'Arial Black'");
        topTitle.getChildren().addAll(title);

        for (int i = 0; i < buttons.length; i++)
        {
            Button button = createButton(buttons[i]);

            //parentPanel.setPadding(new Insets(10));
            parentPanel.setCenter(button);
        }

        return new Scene(parentPanel, Dashboard.WIN_WIDTH, Dashboard.WIN_HEIGHT);
    }

    public static Button createButton(String buttonName)
    {
        Button button = new Button();

        button.setText(buttonName);
        button.setPrefHeight(BUTTON_HEIGHT);
        button.setPrefWidth(BUTTON_WIDTH);

        button.setStyle("-fx-background-color: #81BEF7;" +
                "-fx-font-family: 'Lucida Console';" +
                "-fx-font-size: 20px;");

        //button.setPadding(new Insets(10));

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
