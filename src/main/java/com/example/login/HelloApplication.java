package com.example.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static event.OnClose.close;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws IOException {

        final FXMLLoader fxmlLoaderHome = new FXMLLoader(HelloApplication.class.getResource("login-scene.fxml"));
        final Parent root = fxmlLoaderHome.load();


        Scene scene = new Scene(root);


        stage.setOnCloseRequest(e -> {
            e.consume();
            close(stage);
        });
        stage.setTitle("Hello!");
        stage.setScene(scene);
//        stage.sceneProperty().addListener((observable, oldScene, newScene) -> {
//
//            if (newScene.getRoot().equals(PROGRESS_SCENE)) {
//
//                try {
//                    PROGRESS_LOADER.load();
//                    ProgressBarController progressBarController = PROGRESS_LOADER.getController();
//
//
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//
//        });
        stage.show();
    }
}