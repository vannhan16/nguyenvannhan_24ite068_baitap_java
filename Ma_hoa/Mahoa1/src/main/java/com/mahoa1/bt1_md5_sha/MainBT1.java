package com.mahoa1.bt1_md5_sha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainBT1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/mahoa1/bt1_md5_sha/MainBT1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MD5/SHA Encryption");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
