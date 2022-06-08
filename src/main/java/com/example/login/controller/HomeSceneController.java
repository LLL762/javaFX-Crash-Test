package com.example.login.controller;

import com.example.login.HelloApplication;
import com.example.login.validation.UsernameValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static event.OnClose.close;
import static javafx.scene.control.Alert.AlertType.ERROR;

/**
 * 02/06/2022.
 *
 * @author Laurent Lamiral
 */
public class HomeSceneController implements Initializable {


    final FXMLLoader fxmlProfile = new FXMLLoader(HelloApplication.class.getResource("profile-scene.fxml"));
    final FXMLLoader fxmlSpinner = new FXMLLoader(HelloApplication.class.getResource("spinner.fxml"));


    final Parent profileRoot = fxmlProfile.load();

    private final FXMLLoader fxmlLoaderProgressBar = new FXMLLoader(HelloApplication.class.getResource("progress-bar.fxml"));

    private final Parent progressBar = fxmlLoaderProgressBar.load();

    private final FXMLLoader fxmlLamp = new FXMLLoader(HelloApplication.class.getResource("lamp.fxml"));


    private final String[] countries = {"FR", "UK", "US"};
    @FXML
    private TextField usernameTextField;
    @FXML
    private AnchorPane loginAnchorPane;
    @FXML
    private DatePicker birthDatePick;
    @FXML
    private Label birthDateLabel;
    @FXML
    private ChoiceBox<String> countriesChoiceBox;

    @FXML
    private Slider slider;

    @FXML
    private Label sliderLabel;


    private Stage stage;

    public HomeSceneController() throws IOException {
        // S
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        countriesChoiceBox.getItems().setAll(countries);
        countriesChoiceBox.setOnAction(this::showCountry);

        sliderLabel.setText(Integer.toString((int) slider.getValue()) + "°C");

        slider.valueProperty().addListener((observableValue, number, t1) -> {
            sliderLabel.setText(Integer.toString((int) slider.getValue()) + "°C");

        });


    }

    public void showCountry() {

        birthDateLabel.setText(countriesChoiceBox.getValue());

    }


    public void toProfile(ActionEvent e) throws IOException {

        final String username = usernameTextField.getText().trim();
        final ProfileSceneController profileController = fxmlProfile.getController();
        final UsernameValidator validator = new UsernameValidator();
        final Alert alert;

        if (!validator.validate(username)) {
            alert = new Alert(ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username is invalid !!!!!!!");
            alert.showAndWait();


            return;
        }


        profileController.displayName(username);


        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        stage.setScene(new Scene(profileRoot));

        stage.show();


    }

    public void goToLamp() throws IOException {

        final Parent lampRoot = fxmlLamp.load();

        stage = (Stage) loginAnchorPane.getScene().getWindow();
        stage.setScene(new Scene(lampRoot));

    }


    public void goToSpinner() throws IOException {

        final Parent spinnerRoot = fxmlSpinner.load();

        stage = (Stage) loginAnchorPane.getScene().getWindow();
        stage.setScene(new Scene(spinnerRoot));

    }


    public void goToProgress() throws IOException {


        stage = (Stage) loginAnchorPane.getScene().getWindow();
        stage.setScene(new Scene(progressBar));
        stage.show();


    }


    public void getBirthDate(ActionEvent event) {
        LocalDate birthDate = birthDatePick.getValue();
        Alert alert;
        String formattedBirthDate;


        if (birthDate.isAfter(LocalDate.now())) {

            alert = new Alert(ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid date");
            alert.showAndWait();

            return;
        }

        formattedBirthDate = birthDate.format(DateTimeFormatter.ofPattern(" EEE dd  MMM yyyy"));

        birthDateLabel.setText(formattedBirthDate);


    }


    public void exit(ActionEvent e) {

        stage = (Stage) loginAnchorPane.getScene().getWindow();


        close(stage);

    }


    private void showCountry(ActionEvent event) {
        showCountry();
    }
}
