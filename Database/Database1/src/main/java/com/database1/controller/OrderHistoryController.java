package com.database1.controller;

import com.database1.dao.CustomerDAO;
import com.database1.dao.OrderDAO;
import com.database1.model.Customer;
import com.database1.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class OrderHistoryController implements Initializable {

    @FXML
    private ComboBox<Customer> customerComboBox;

    @FXML
    private TableView<Order> orderTableView;

    @FXML
    private TableColumn<Order, Integer> orderIdColumn;

    @FXML
    private TableColumn<Order, Date> orderDateColumn;

    @FXML
    private TableColumn<Order, Double> totalAmountColumn;

    private CustomerDAO customerDAO = new CustomerDAO();
    private OrderDAO orderDAO = new OrderDAO();
    private ObservableList<Order> orderList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Load danh sách khách hàng vào ComboBox khi giao diện được khởi tạo
        loadCustomers();

        // Cấu hình các cột của TableView
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

        // Đặt dữ liệu cho TableView
        orderTableView.setItems(orderList);
    }

    private void loadCustomers() {
        List<Customer> customers = customerDAO.getAllCustomers();
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList(customers);
        customerComboBox.setItems(customerObservableList);
    }

    @FXML
    public void loadOrderHistory() {
        Customer selectedCustomer = customerComboBox.getValue();
        if (selectedCustomer != null) {
            List<Order> orders = orderDAO.getOrdersByCustomerId(selectedCustomer.getId());
            orderList.clear();
            orderList.addAll(orders);
        }
    }

    @FXML
    public void closeOrderHistoryView() {
        Stage stage = (Stage) customerComboBox.getScene().getWindow();
        stage.close();
    }
}