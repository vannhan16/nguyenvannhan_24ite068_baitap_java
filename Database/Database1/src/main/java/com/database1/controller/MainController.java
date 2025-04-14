package com.database1.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    public void openAddOrderView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.database1/views/add-order-view.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage addOrderStage = new Stage();
            addOrderStage.setTitle("Thêm Đơn hàng Mới");
            Scene scene = new Scene(page);
            addOrderStage.setScene(scene);
            addOrderStage.show();
            // Bạn có thể truyền dữ liệu hoặc controller nếu cần
            // AddOrderController controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openOrderHistoryView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.database1/views/order-history-view.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage orderHistoryStage = new Stage();
            orderHistoryStage.setTitle("Lịch sử Đơn hàng");
            Scene scene = new Scene(page);
            orderHistoryStage.setScene(scene);
            orderHistoryStage.show();
            // Bạn có thể truyền dữ liệu hoặc controller nếu cần
            // OrderHistoryController controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
