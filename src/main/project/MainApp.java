package main.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("../../resources/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600); // Adjust window size
        primaryStage.setTitle("Text Processing Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
