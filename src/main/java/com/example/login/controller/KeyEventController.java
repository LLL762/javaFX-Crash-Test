package com.example.login.controller;

import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.animation.Interpolator.LINEAR;
import static javafx.animation.TranslateTransition.INDEFINITE;

/**
 * 09/06/2022.
 *
 * @author Laurent Lamiral
 */
public class KeyEventController implements Initializable {

    private final FadeTransition fade = new FadeTransition();

    private final ScaleTransition scale = new ScaleTransition();
    @FXML
    private Circle movingCircle;
    @FXML
    private ImageView shark;
    @FXML
    private Arc pacman;
    private Parent circleParent;


    private double increments = 5;
    private final EventHandler<KeyEvent> keyEventHandler = e -> {

        switch (e.getCode()) {
            case UP -> moveUp();
            case DOWN -> moveDown();
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
            default -> {
            }
        }


    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initFadeTransition();
        initScale();

    }


    public void sharkTranslate() {

        circleParent = movingCircle.getParent();

        final TranslateTransition translateShark = new TranslateTransition();
        translateShark.setNode(shark);
        translateShark.setDuration(Duration.millis(2000));
        translateShark.setCycleCount(INDEFINITE);
        translateShark.setAutoReverse(true);


        translateShark.setByX(circleParent.getBoundsInLocal().getWidth()
                + shark.getBoundsInLocal().getWidth() / 2);
        translateShark.play();


    }

    public void rotatePackman() {

        final RotateTransition rotate = new RotateTransition();
        rotate.setNode(pacman);
        rotate.setDuration(Duration.millis(1500));
        rotate.setCycleCount(INDEFINITE);
        rotate.setInterpolator(LINEAR);
        rotate.setAxis(Rotate.X_AXIS);
        rotate.setByAngle(360);


        rotate.play();


    }

    private void initFadeTransition() {

        fade.setNode(movingCircle);
        fade.setDuration(Duration.millis(1500));
        fade.setCycleCount(1);
        fade.setInterpolator(LINEAR);
        fade.setFromValue(0.2);
        fade.setToValue(1);

    }

    private void initScale() {
        scale.setNode(movingCircle);
        scale.setDuration(Duration.millis(1500));
        scale.setCycleCount(1);
        scale.setInterpolator(LINEAR);

        scale.setFromX(0.5);
        scale.setFromY(0.5);
        scale.setToX(1);
        scale.setToY(1);


    }


    private void circleTouchBorder() {


        if (fade.getStatus().equals(Animation.Status.RUNNING)) {
            fade.jumpTo(Duration.ZERO);
            scale.jumpTo(Duration.ZERO);
            return;
        }

        scale.play();
        fade.play();


    }


    private void moveUp() {

        final double newPosY = movingCircle.getCenterY() - increments;

        if (newPosY - movingCircle.getRadius() <= -circleParent.getBoundsInLocal().getHeight() / 2) {

            movingCircle.setCenterY(newPosY + 2 * increments);
            circleTouchBorder();
            return;

        }

        movingCircle.setCenterY(newPosY);

    }

    private void moveDown() {

        final double newPosY = movingCircle.getCenterY() + increments;

        if (newPosY + movingCircle.getRadius() >= circleParent.getBoundsInLocal().getHeight() / 2) {

            movingCircle.setCenterY(newPosY - 2 * increments);
            circleTouchBorder();
            return;

        }


        movingCircle.setCenterY(newPosY);

    }

    private void moveLeft() {

        final double newPosX = movingCircle.getCenterX() - increments;


        if (newPosX - movingCircle.getRadius() <= -circleParent.getBoundsInLocal().getWidth() / 2) {

            movingCircle.setCenterX(newPosX + 2 * increments);
            circleTouchBorder();
            return;

        }

        movingCircle.setCenterX(newPosX);

    }

    private void moveRight() {

        final double newPosX = movingCircle.getCenterX() + increments;

        if (newPosX + movingCircle.getRadius() >= circleParent.getBoundsInLocal().getWidth() / 2) {

            movingCircle.setCenterX(newPosX - 2 * increments);
            circleTouchBorder();
            return;

        }

        movingCircle.setCenterX(newPosX);


    }


    public EventHandler<KeyEvent> getKeyEventHandler() {
        return keyEventHandler;
    }


}
