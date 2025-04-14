package com.database1.dao;

import com.database1.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection getConnection() throws SQLException {
        // TODO: Implement logic to establish database connection
        return null; // Placeholder
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id, name, price FROM products";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors appropriately
        }
        return products;
    }

    public Product getProductById(int id) {
        Product product = null;
        String sql = "SELECT id, name, price FROM products WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors appropriately
        }
        return product;
    }

    // Add other methods as needed
}