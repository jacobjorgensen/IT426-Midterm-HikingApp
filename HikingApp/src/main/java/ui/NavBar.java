/*
 * Jacob Laqua, Mackenzie Larson, Kenny Still
 * 11/05/2017
 * NavBar.java
 * This class is contains the logic for building the navbar
 */
package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * This class contains the functionality for building the navbar
 *
 * @author Jacob Laqua, Mackenzie Larson, Kenny Still
 * @version 1.0
 */
public class NavBar
{
    private String[] buttons = new String[] {"Home", "Hikes", "Tasks", "Messages"};
    private static final int BUTTON_HEIGHT = 30;
    private static final int BUTTON_WIDTH = 70;

    /**
     * Getter for a navbar
     *
     * @return An HBox representation of the navbar
     */
    public HBox getNavBar()
    {
        HBox nav = new HBox();
        nav.setSpacing(10);

        //add buttons
        for (int i = 0; i < buttons.length; i++)
        {
            Button button = createButton(buttons[i]);
            nav.getChildren().add(button);
        }

        nav.setAlignment(Pos.TOP_CENTER);
        nav.setPadding(new Insets(Dashboard.PANEL_PADING));

        return nav;
    }

    private Button createButton(String buttonName)
    {
        Button button = new Button();

        button.setText(buttonName);
        button.setPrefHeight(BUTTON_HEIGHT);
        button.setPrefWidth(BUTTON_WIDTH);

        button.setStyle("-fx-background-color: #81BEF7;" +
                "-fx-font-family: 'Lucida Console';" +
                "-fx-font-size: 10px;");

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
