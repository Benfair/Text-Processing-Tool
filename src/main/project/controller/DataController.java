package main.project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonType;
import main.project.DataManagement;

import java.util.Optional;

public class DataController {

    @FXML private ListView<DataManagement> listView;
    @FXML private TextField inputField;

    private ObservableList<DataManagement> dataList;

    @FXML private void initialize() {
        dataList = FXCollections.observableArrayList();
        listView.setItems(dataList);
    }

    public void handleAdd() {
        String value = inputField.getText().trim();
        if (!value.isEmpty()) {
            DataManagement newData = new DataManagement(value);
            if (!dataList.contains(newData)) {
                dataList.add(newData);
                inputField.clear();
            } else {
                showAlert(Alert.AlertType.WARNING, "Duplicate Entry", "This entry already exists.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Please enter a valid value.");
        }
    }

    public void handleUpdate() {
        String newValue = inputField.getText().trim();
        DataManagement selectedItem = listView.getSelectionModel().getSelectedItem();

        if (selectedItem != null && !newValue.isEmpty()) {
            if (!dataList.contains(new DataManagement(newValue))) {
                selectedItem.setValue(newValue);
                listView.refresh();
                inputField.clear();
            } else {
                showAlert(Alert.AlertType.WARNING, "Duplicate Entry", "This entry already exists.");
            }
        } else if (selectedItem == null) {
            showAlert(Alert.AlertType.INFORMATION, "Selection Error", "Please select an item to update.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Please enter a valid value.");
        }
    }

    public void handleDelete() {
        DataManagement selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            dataList.remove(selectedItem);
        } else {
            showAlert(Alert.AlertType.WARNING, "Selection Error", "Please select an item to delete.");
        }
    }

    public void handleClear() {
        if (!dataList.isEmpty()) {
            // Confirmation dialog
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirm Clear All");
            confirmationAlert.setContentText("Are you sure you want to clear all items?");
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                dataList.clear();
            }
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Action Error", "The list is already empty.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
