package com.example.login.controller;

import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * 14/06/2022.
 *
 * @author Laurent Lamiral
 */
public class MediaViewController implements Initializable {

    @FXML
    MediaView mediaView;
    private File file;

    @FXML
    private Slider sliderTime;

    private Media media;
    private MediaPlayer mediaPlayer;

    private final InvalidationListener videoTimeListener = observable ->
            sliderTime.setValue(mediaPlayer.getCurrentTime().toMinutes());


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initMedia();
        initSlider();

    }


    private void initMedia() {

        media = new Media(Objects.requireNonNull(
                getClass().getResource("/video/mario-kart.mp4")).toExternalForm());

        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);


        mediaPlayer.currentTimeProperty().addListener(videoTimeListener);

        mediaPlayer.setOnReady(this::initSlider);

    }

    private void initSlider() {

        sliderTime.setMin(0);
        sliderTime.setMax(mediaPlayer.getTotalDuration().toMinutes());
        sliderTime.setValue(0);


        sliderTime.setOnMousePressed(e -> sliderTimeOnMousePressed());
        sliderTime.setOnMouseReleased(e -> changeMediaCurrentTime());


    }


    private void sliderTimeOnMousePressed() {

        mediaPlayer.currentTimeProperty().removeListener(videoTimeListener);
    }

    private void changeMediaCurrentTime() {

        final MediaPlayer.Status status = mediaPlayer.getStatus();


        if (!status.equals(MediaPlayer.Status.PAUSED)) {
            mediaPlayer.pause();
        }
        mediaPlayer.seek(Duration.minutes(sliderTime.getValue()));

        mediaPlayer.currentTimeProperty().addListener(videoTimeListener);

    }


    public void playMedia() {
        mediaPlayer.play();
    }

    public void pauseMedia() {

        mediaPlayer.pause();
    }

    public void resetMedia() {
        mediaPlayer.seek(Duration.ZERO);
    }


}
