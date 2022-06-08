package com.example.login.component.builder;

import com.example.login.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * 08/06/2022.
 *
 * @author Laurent Lamiral
 */
public class ImageViewBuilder {

    private ImageViewBuilder() {
    }

    public static ImageView buildIcon(String relativePath) {

        ImageView output =
                new ImageView(
                        new Image(
                                Objects.requireNonNull(
                                                HelloApplication.class.getResource(relativePath))
                                        .toExternalForm()));

        output.setPreserveRatio(true);
        output.setFitHeight(16);
        output.setFitWidth(16);


        return output;


    }


}
