package com.example.gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import java.util.Optional;

public class BookDialog extends Dialog<Book> {

    private final TextField titleField = new TextField();
    private final TextField authorField = new TextField();
    private final TextField yearField = new TextField();
    private final TextField publisherField = new TextField();
    private final TextField pagesField = new TextField();
    private final TextField genreField = new TextField();
    private final TextField priceField = new TextField();
    private final TextField isbnField = new TextField();

    public BookDialog() {
        this(null);
    }

    public BookDialog(Book book) {
        setTitle(book == null ? "Thêm sách mới" : "Chỉnh sửa sách");
        setHeaderText(book == null ? "Nhập thông tin sách mới" : "Chỉnh sửa thông tin sách");

        ButtonType saveButtonType = new ButtonType("Lưu", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        grid.add(new Label("Tên sách:"), 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(new Label("Tác giả:"), 0, 1);
        grid.add(authorField, 1, 1);
        grid.add(new Label("Năm xuất bản:"), 0, 2);
        grid.add(yearField, 1, 2);
        grid.add(new Label("Nhà xuất bản:"), 0, 3);
        grid.add(publisherField, 1, 3);
        grid.add(new Label("Số trang:"), 0, 4);
        grid.add(pagesField, 1, 4);
        grid.add(new Label("Thể loại:"), 0, 5);
        grid.add(genreField, 1, 5);
        grid.add(new Label("Giá sách:"), 0, 6);
        grid.add(priceField, 1, 6);
        grid.add(new Label("Mã sách (ISBN):"), 0, 7);
        grid.add(isbnField, 1, 7);

        getDialogPane().setContent(grid);

        if (book != null) {
            titleField.setText(book.getTitle());
            authorField.setText(book.getAuthor());
            yearField.setText(String.valueOf(book.getYear()));
            publisherField.setText(book.getPublisher());
            pagesField.setText(String.valueOf(book.getPages()));
            genreField.setText(book.getGenre());
            priceField.setText(String.valueOf(book.getPrice()));
            isbnField.setText(book.getIsbn());
        }

        setResultConverter(new Callback<ButtonType, Book>() {
            @Override
            public Book call(ButtonType buttonType) {
                if (buttonType == saveButtonType) {
                    return new Book(
                            titleField.getText(),
                            authorField.getText(),
                            Integer.parseInt(yearField.getText()),
                            publisherField.getText(),
                            Integer.parseInt(pagesField.getText()),
                            genreField.getText(),
                            Double.parseDouble(priceField.getText()),
                            isbnField.getText()
                    );
                }
                return null;
            }
        });
    }
}
