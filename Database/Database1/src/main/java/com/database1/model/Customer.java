package com.database1.model;

public class Customer {
    private int id;
    private String name;

    // Constructor
    public Customer() {}

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter - Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Để hiển thị trong ComboBox
    @Override
    public String toString() {
        return name;
    }
}
