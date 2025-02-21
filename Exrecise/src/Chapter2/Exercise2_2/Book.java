package Chapter2.Exercise2_2;

import java.util.Collection;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }
    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }
    public String getName() {
        return name;
    }
    public Author[] getAuthors() {
        return authors;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public int getQty(){
        return qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
    public String getAuthorNames(){
        return Arrays.stream(authors)
                .map(Author::getName)
                .collect(Collectors.joining(","));
    }
    @Override
    public String toString() {
        return "Book[name=" + name + ", authors={" + Arrays.toString(authors) + "}, price=" + price + ", qty=" + qty + "]";
    }
}
