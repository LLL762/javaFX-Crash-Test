package com.example.login.action;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 07/06/2022.
 *
 * @author Laurent Lamiral
 */
public class SceneChange {

    private SceneChange() {
    }

    public static void goTo(Stage stage, Parent sceneToGo) {


        stage.setScene(new Scene(sceneToGo));

        stage.show();


    }


}
