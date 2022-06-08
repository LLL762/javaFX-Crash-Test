package com.example.login.controller;

import com.example.login.HelloApplication;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.example.login.scene.SceneList.CUSTOM;


/**
 * 07/06/2022.
 *
 * @author Laurent Lamiral
 */
public class ProgressBarController implements Initializable, PropertyChangeListener {

    private final FXMLLoader fxmlLamp = new FXMLLoader(HelloApplication.class.getResource("lamp.fxml"));


    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button button;
    private Stage stage;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final TimerTask fillProgress = new TimerTask() {
        public void run() {
            makeProgress(0.1);

            System.out.println("run");

        }
    };


    public ProgressBarController() throws IOException {
        //42
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progressBar.setStyle("-fx-accent: #00FF00;");


        progressBar.sceneProperty().addListener((observableValue, aBoolean, t1) -> {

            try {
                start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        progressBar.addEventHandler(CUSTOM, e -> {

            executor.shutdown();
            Platform.runLater(this::goToLamp);

        });


    }


    public void makeProgress(Double d) {

        final double progress = progressBar.getProgress() + d;

        if (progress >= 1) {

            progressBar.fireEvent(new Event(CUSTOM));
            pcs.firePropertyChange("barFilled", progressBar.getProgress(), 1);
        }


        progressBar.setProgress(progress);


    }


    public void start() throws InterruptedException {


        executor.scheduleAtFixedRate(fillProgress, 1000, 100, TimeUnit.MILLISECONDS);


    }


    public void goToLamp() {

        final Parent lampRoot;
        try {
            lampRoot = fxmlLamp.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) button.getScene().getWindow();
        stage.setScene(new Scene(lampRoot));
        stage.show();
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        executor.shutdown();


    }


    public Button getButton() {
        return button;
    }
}
