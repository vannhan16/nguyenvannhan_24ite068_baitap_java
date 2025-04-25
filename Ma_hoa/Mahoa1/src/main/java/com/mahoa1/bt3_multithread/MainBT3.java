package com.mahoa1.bt3_multithread;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainBT3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/mahoa1/bt3_multithread/MainBT3.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Multi-threaded Encryption");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
