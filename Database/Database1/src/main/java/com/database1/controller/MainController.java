package com.database1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class MainController {

    @FXML
    public void handleAddOrder(ActionEvent event) {
        loadView("/com/database1/add-order-view.fxml", "Thêm đơn hàng", event);
    }

    @FXML
    public void handleOrderHistory(ActionEvent event) {
        loadView("/com/database1/order-history-view.fxml", "Lịch sử đơn hàng", event);
    }

    private void loadView(String fxmlPath, String title, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load(), 600, 400);
            scene.getStylesheets().add(getClass().getResource("/com/database1/style.css").toExternalForm());

            // Lấy stage từ sự kiện hiện tại
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
