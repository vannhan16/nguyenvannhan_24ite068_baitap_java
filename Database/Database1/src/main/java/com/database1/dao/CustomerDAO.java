package com.database1.dao;
import com.database1.database.DatabaseConnector;
import com.database1.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private Connection getConnection() throws SQLException {
        // TODO: Implement logic to establish database connection
        // Replace with your database connection details
        // Example using DriverManager (you might want to use a connection pool in a real application)
        // return DriverManager.getConnection("jdbc:your_db_url", "username", "password");
        return null; // Placeholder
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT id, name FROM customers";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors appropriately
        }
        return customers;
    }

    public Customer getCustomerById(int id) {
        Customer customer = null;
        String sql = "SELECT id, name FROM customers WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors appropriately
        }
        return customer;
    }

    // Add other methods as needed (e.g., addCustomer, updateCustomer, deleteCustomer)
}