package com.database1.dao;

import com.database1.model.Order;
import com.database1.model.OrderItem;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class OrderDAO {

    private Connection getConnection() throws SQLException {
        // TODO: Implement logic to establish database connection
        return null; // Placeholder
    }

    public void saveOrder(Order order, List<OrderItem> orderItems) {
        String sqlOrder = "INSERT INTO orders (customer_id, order_date, total_amount) VALUES (?, ?, ?)";
        String sqlOrderItem = "INSERT INTO order_items (order_id, product_id, quantity, unit_price, total_price) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement orderStatement = null;
        PreparedStatement itemStatement = null;
        ResultSet generatedKeys = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false); // Start transaction

            orderStatement = connection.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
            orderStatement.setInt(1, order.getCustomerId());
            orderStatement.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
            orderStatement.setDouble(3, order.getTotalAmount());
            orderStatement.executeUpdate();

            generatedKeys = orderStatement.getGeneratedKeys();
            int orderId;
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
                for (OrderItem item : orderItems) {
                    itemStatement = connection.prepareStatement(sqlOrderItem);
                    itemStatement.setInt(1, orderId);
                    itemStatement.setInt(2, item.getProductId());
                    itemStatement.setInt(3, item.getQuantity());
                    itemStatement.setDouble(4, item.getUnitPrice());
                    itemStatement.setDouble(5, item.getTotalPrice());
                    itemStatement.executeUpdate();
                }
            }

            connection.commit(); // Commit transaction

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback on error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            // Handle database errors appropriately
        } finally {
            try { if (generatedKeys != null) generatedKeys.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (itemStatement != null) itemStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (orderStatement != null) orderStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.setAutoCommit(true); connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT id, order_date, total_amount FROM orders WHERE customer_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setCustomerId(customerId);
                order.setOrderDate(resultSet.getDate("order_date"));
                order.setTotalAmount(resultSet.getDouble("total_amount"));
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors appropriately
        }
        return orders;
    }

    // Method to get order details (including order items) by order ID
    // ...
}