package com.example.login.controller;

import com.example.login.component.builder.CharacterTreeBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.AQUA;
import static javafx.scene.paint.Color.WHITE;

/**
 * 08/06/2022.
 *
 * @author Laurent Lamiral
 */
public class SpinnerController implements Initializable {


    private final String[] food = {"pizza", "sushi", "ramen"};


    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private Label spinnerLabel;

    @FXML
    private ListView<String> listView;

    @FXML
    private Label listViewLabel;

    @FXML
    private TreeView<String> treeView;

    @FXML
    private Label treeViewLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setUpSpinner();
        setUpListView();
        setUpTreeView();

    }


    public void selectItem() {

        final TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();

        if (item == null || item.getParent() == null) {
            return;
        }

        treeViewLabel.setText(item.getValue());

        if (item.getParent().getValue().equals("Mage")) {
            treeViewLabel.setTextFill(AQUA);

        } else {

            treeViewLabel.setTextFill(WHITE);
        }


    }


    private void setUpTreeView() {

        CharacterTreeBuilder.build(treeView);


    }


    private void setUpListView() {
        listView.getItems().addAll(food);
        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) ->
                listViewLabel.setText(
                        listView.getSelectionModel().getSelectedItem())
        );
    }


    private void setUpSpinner() {

        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);

        valueFactory.setValue(1);
        spinner.setValueFactory(valueFactory);

        spinnerLabel.setText(Integer.toString(spinner.getValue()));

        spinner.valueProperty().addListener((observableValue, integer, t1) -> {
            spinnerLabel.setText(Integer.toString(spinner.getValue()));
        });


    }


}
