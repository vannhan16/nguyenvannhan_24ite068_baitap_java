package com.database1.controller;

import com.database1.model.Customer;
import com.database1.model.OrderItem;
import com.database1.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddOrderController implements Initializable {

    @FXML
    private ComboBox<Customer> customerComboBox;

    @FXML
    private ComboBox<Product> productComboBox;

    @FXML
    private TextField quantityTextField;

    @FXML
    private TableView<OrderItem> orderItemTableView;

    @FXML
    private TableColumn<OrderItem, String> productNameColumn;

    @FXML
    private TableColumn<OrderItem, Integer> quantityColumn;

    @FXML
    private TableColumn<OrderItem, Double> priceColumn;

    @FXML
    private TableColumn<OrderItem, Double> totalColumn;

    @FXML
    private Label totalAmountLabel;

    private ObservableList<OrderItem> orderItems = FXCollections.observableArrayList();

    // Giả định có các DAO để lấy dữ liệu (bạn cần triển khai chúng)
    // private CustomerDAO customerDAO = new CustomerDAO();
    // private ProductDAO productDAO = new ProductDAO();
    // private OrderDAO orderDAO = new OrderDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Tạm thời thêm dữ liệu giả định cho ComboBox (thay bằng lấy từ DB)
        ObservableList<Customer> customers = FXCollections.observableArrayList(
                new Customer(1, "Nguyễn Văn A"),
                new Customer(2, "Trần Thị B")
        );
        customerComboBox.setItems(customers);

        ObservableList<Product> products = FXCollections.observableArrayList(
                new Product(1, "Laptop", 12000000.0),
                new Product(2, "Chuột máy tính", 150000.0),
                new Product(3, "Bàn phím", 300000.0)
        );
        productComboBox.setItems(products);

        // Cấu hình TableView
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        orderItemTableView.setItems(orderItems);

        // Thêm cột nút xóa (tùy chọn)
        // ...
    }

    @FXML
    public void addProductToOrder() {
        Product selectedProduct = productComboBox.getValue();
        String quantityText = quantityTextField.getText();

        if (selectedProduct != null && !quantityText.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityText);
                if (quantity > 0) {
                    OrderItem newItem = new OrderItem();
                    newItem.setProductId(selectedProduct.getId());
                    newItem.setProductName(selectedProduct.getName());
                    newItem.setUnitPrice(selectedProduct.getPrice());
                    newItem.setQuantity(quantity);
                    newItem.setTotalPrice(selectedProduct.getPrice() * quantity);
                    orderItems.add(newItem);
                    updateTotalAmount();
                    quantityTextField.clear();
                } else {
                    showAlert("Lỗi", "Số lượng phải lớn hơn 0.");
                }
            } catch (NumberFormatException e) {
                showAlert("Lỗi", "Vui lòng nhập số lượng hợp lệ.");
            }
        } else {
            showAlert("Lỗi", "Vui lòng chọn sản phẩm và nhập số lượng.");
        }
    }

    @FXML
    public void saveOrder() {
        Customer selectedCustomer = customerComboBox.getValue();
        if (selectedCustomer != null && !orderItems.isEmpty()) {
            // Tạo đối tượng Order và OrderItem, sau đó gọi OrderDAO để lưu vào DB
            // Order newOrder = new Order();
            // newOrder.setCustomerId(selectedCustomer.getId());
            // newOrder.setOrderDate(new Date());
            // List<OrderItem> itemsToSave = new ArrayList<>(orderItems);
            // orderDAO.saveOrder(newOrder, itemsToSave);
            showAlert("Thông báo", "Đơn hàng đã được lưu!");
            closeAddOrderView();
        } else {
            showAlert("Lỗi", "Vui lòng chọn khách hàng và thêm sản phẩm vào đơn hàng.");
        }
    }

    @FXML
    public void closeAddOrderView() {
        Stage stage = (Stage) quantityTextField.getScene().getWindow();
        stage.close();
    }

    private void updateTotalAmount() {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getTotalPrice();
        }
        totalAmountLabel.setText(String.format("%.2f VNĐ", total));
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}