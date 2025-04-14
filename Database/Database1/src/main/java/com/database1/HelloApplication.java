package com.database1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("com.database1/views/main-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            scene.getStylesheets().add(getClass().getResource("com.database1/style.css").toExternalForm());
            stage.setTitle("Ứng dụng Quản lý Đơn hàng");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Không thể tải giao diện chính: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // Nên sử dụng launch(args) để tương thích tốt hơn
    }
}