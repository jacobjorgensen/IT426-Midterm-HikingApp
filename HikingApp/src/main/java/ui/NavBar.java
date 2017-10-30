package ui;

import controller.Dashboard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class NavBar
{
    private String[] buttons = new String[] {"Home", "Hikes", "Tasks", "Messages"};

    public HBox getNavBar()
    {
        HBox box = new HBox();

        //add buttons
        for (int i = 0; i < buttons.length; i++) {
            final String buttonText = buttons[i];
            Button button = new Button(buttons[i]);

            //set handler
            button.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    Dashboard.switchScenes(buttonText);
                }
            });

            box.getChildren().add(button);
        }


        // center the vBox and add some padding
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(Dashboard.PANEL_PADING));

         // add as many controls as needed

        return box;
    }

}
