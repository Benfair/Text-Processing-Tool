package main.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            TabPane tabPane = new TabPane();

            // Text Processing Tab
            Tab textProcessingTab = new Tab("Text Processing");
            Parent textProcessingContent = FXMLLoader.load(getClass().getResource("/text-view.fxml"));
            textProcessingTab.setContent(textProcessingContent);

            // Data Management Tab
            Tab dataManagementTab = new Tab("Data Management");
            Parent dataManagementContent = FXMLLoader.load(getClass().getResource("/data-view.fxml"));
            dataManagementTab.setContent(dataManagementContent);

            // Add tabs to the TabPane
            tabPane.getTabs().addAll(textProcessingTab, dataManagementTab);

            // Scene Setup
            Scene scene = new Scene(tabPane, 800, 600);
            primaryStage.setTitle("Text Processing & Data Management Tool");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}