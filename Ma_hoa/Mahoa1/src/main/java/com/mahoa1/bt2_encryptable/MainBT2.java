package com.mahoa1.bt2_encryptable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainBT2 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/mahoa1/bt2_encryptable/MainBT2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Encryptable AES & RSA");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
