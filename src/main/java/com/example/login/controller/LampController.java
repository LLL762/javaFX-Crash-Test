package com.example.login.controller;

import com.example.login.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

/**
 * 02/06/2022.
 *
 * @author Laurent Lamiral
 */
public class LampController {

    private final Image lampOnImg = new Image(requireNonNull(getClass().getResourceAsStream("/images/lampON.png")));
    private final Image lampOffImg = new Image(requireNonNull(getClass().getResource("/images/lampOFF.png")).toExternalForm());

    private final FXMLLoader fxmlLoaderHome = new FXMLLoader(HelloApplication.class.getResource("login-scene.fxml"));
    private final Parent homeRoot = fxmlLoaderHome.load();


    private Stage stage;
    @FXML
    private ImageView lampView;

    @FXML
    private CheckBox lampCheckbox;

    private MenuItem goToHomeMenuItem;

    public LampController() throws IOException {
    }


    public void goToHome() throws IOException {


        stage = (Stage) lampCheckbox.getScene().getWindow();
        stage.setScene(new Scene(homeRoot));
        stage.show();

    }


    public void turnOnOff() {

        if (lampCheckbox.isSelected()) {

            lampView.setImage(lampOnImg);
        } else {
            lampView.setImage(lampOffImg);

        }


    }


}
