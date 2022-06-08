package com.example.login.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * 02/06/2022.
 *
 * @author Laurent Lamiral
 */
public class ProfileSceneController {

    private final Image[] images = {
            new Image(getClass().getResource("/images/mage1.jpg").toExternalForm()),
            new Image(getClass().getResource("/images/mage2.jpg").toExternalForm()),
            new Image(getClass().getResource("/images/mage3.jpg").toExternalForm())
    };
    private final Map<Integer, RadioButton> rdMapping = new HashMap<>();
    private int index = 0;
    @FXML
    private ImageView imageView;
    @FXML
    private Label helloLabel;
    @FXML
    private RadioButton rdMage1, rdMage2, rdMage3;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private FlowPane colorPane;


    //@FXML field instanciation happen after constructor call.
    public void initialize() {
        init();
    }


    private void init() {

        rdMapping.put(0, rdMage1);
        rdMapping.put(1, rdMage2);
        rdMapping.put(2, rdMage3);

    }


    public void nextImage() {

        init();
        index = (index + 1) % images.length;
        imageView.setImage(images[index]);
        rdMapping.get(index).setSelected(true);


    }


    public void previousImage() {

        index = (index - 1) % images.length;

        if (index < 0) {
            index = index + images.length;
        }

        imageView.setImage(images[index]);
        rdMapping.get(index).setSelected(true);


    }


    public void mouseEnter() {

        imageView.setScaleX(1.1);
        imageView.setScaleY(1.1);
    }


    public void displayName(String username) {

        helloLabel.setText("Hello : " + username);

    }


    public void getMage(ActionEvent e) {

        if (rdMage1.isSelected()) {
            index = 0;
            imageView.setImage(images[index]);
            return;
        }

        if (rdMage2.isSelected()) {
            index = 1;
            imageView.setImage(images[index]);
            return;
        }

        if (rdMage3.isSelected()) {
            index = 2;
            imageView.setImage(images[index]);

        }


    }

    public void changeBackgroundColor() {

        final Color color = colorPicker.getValue();

        colorPane.setBackground((new Background((new BackgroundFill(color, null, null)))));


    }


}
