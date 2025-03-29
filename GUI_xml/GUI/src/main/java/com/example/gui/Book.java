package com.example.gui;

import javafx.beans.property.*;

public class Book {
    private final StringProperty title;
    private final StringProperty author;
    private final IntegerProperty year;
    private final StringProperty publisher;
    private final IntegerProperty pages;
    private final StringProperty genre;
    private final DoubleProperty price;
    private final StringProperty isbn;

    // Constructor
    public Book(String title, String author, int year, String publisher, int pages, String genre, double price, String isbn) {
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.year = new SimpleIntegerProperty(year);
        this.publisher = new SimpleStringProperty(publisher);
        this.pages = new SimpleIntegerProperty(pages);
        this.genre = new SimpleStringProperty(genre);
        this.price = new SimpleDoubleProperty(price);
        this.isbn = new SimpleStringProperty(isbn);
    }

    // Getter cho JavaFX Property
    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty authorProperty() {
        return author;
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public StringProperty publisherProperty() {
        return publisher;
    }

    public IntegerProperty pagesProperty() {
        return pages;
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public StringProperty isbnProperty() {
        return isbn;
    }

    // Getter giá trị thực tế
    public String getTitle() {
        return title.get();
    }

    public String getAuthor() {
        return author.get();
    }

    public int getYear() {
        return year.get();
    }

    public String getPublisher() {
        return publisher.get();
    }

    public int getPages() {
        return pages.get();
    }

    public String getGenre() {
        return genre.get();
    }

    public double getPrice() {
        return price.get();
    }

    public String getIsbn() {
        return isbn.get();
    }

    // Setter
    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public void setPublisher(String publisher) {
        this.publisher.set(publisher);
    }

    public void setPages(int pages) {
        this.pages.set(pages);
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year=" + getYear() +
                ", publisher='" + getPublisher() + '\'' +
                ", pages=" + getPages() +
                ", genre='" + getGenre() + '\'' +
                ", price=" + getPrice() +
                ", isbn='" + getIsbn() + '\'' +
                '}';
    }
}
