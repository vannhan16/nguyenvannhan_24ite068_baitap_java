package com.example.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Optional;
import com.example.gui.Book;

public class LibraryController {

    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, String> titleColumn, authorColumn, publisherColumn, genreColumn, isbnColumn;
    @FXML
    private TableColumn<Book, Integer> yearColumn, pagesColumn;
    @FXML
    private TableColumn<Book, Double> priceColumn;
    @FXML
    private Button addButton, editButton, deleteButton;

    private final ObservableList<Book> bookList = FXCollections.observableArrayList();
    private final File xmlFile = new File("library_data.xml");

    @FXML
    public void initialize() {
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
        publisherColumn.setCellValueFactory(cellData -> cellData.getValue().publisherProperty());
        pagesColumn.setCellValueFactory(cellData -> cellData.getValue().pagesProperty().asObject());
        genreColumn.setCellValueFactory(cellData -> cellData.getValue().genreProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        isbnColumn.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());

        tableView.setItems(bookList);

        loadBooksFromXML();

        // Gán sự kiện cho các nút
        addButton.setOnAction(e -> addBook());
        editButton.setOnAction(e -> editBook());
        deleteButton.setOnAction(e -> deleteBook());
    }

    // Đọc dữ liệu từ XML vào TableView
    private void loadBooksFromXML() {
        bookList.clear();
        if (!xmlFile.exists()) return;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element bookElement = (Element) nodeList.item(i);
                Book book = new Book(
                        bookElement.getElementsByTagName("title").item(0).getTextContent(),
                        bookElement.getElementsByTagName("author").item(0).getTextContent(),
                        Integer.parseInt(bookElement.getElementsByTagName("year").item(0).getTextContent()),
                        bookElement.getElementsByTagName("publisher").item(0).getTextContent(),
                        Integer.parseInt(bookElement.getElementsByTagName("pages").item(0).getTextContent()),
                        bookElement.getElementsByTagName("genre").item(0).getTextContent(),
                        Double.parseDouble(bookElement.getElementsByTagName("price").item(0).getTextContent()),
                        bookElement.getElementsByTagName("isbn").item(0).getTextContent()
                );
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Thêm sách mới
    private void addBook() {
        BookDialog dialog = new BookDialog();
        Optional<Book> result = dialog.showAndWait();
        result.ifPresent(book -> {
            bookList.add(book);
            saveBooksToXML();
        });
    }

    // Sửa sách đã chọn
    private void editBook() {
        Book selectedBook = tableView.getSelectionModel().getSelectedItem();
        if (selectedBook == null) {
            showAlert("Chọn sách để sửa!", AlertType.WARNING);
            return;
        }

        BookDialog dialog = new BookDialog(selectedBook);
        Optional<Book> result = dialog.showAndWait();
        result.ifPresent(book -> {
            bookList.set(bookList.indexOf(selectedBook), book);
            saveBooksToXML();
        });
    }

    // Xóa sách đã chọn
    private void deleteBook() {
        Book selectedBook = tableView.getSelectionModel().getSelectedItem();
        if (selectedBook == null) {
            showAlert("Chọn sách để xóa!", AlertType.WARNING);
            return;
        }

        Alert confirm = new Alert(AlertType.CONFIRMATION, "Bạn có chắc chắn muốn xóa?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = confirm.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            bookList.remove(selectedBook);
            saveBooksToXML();
        }
    }

    // Lưu dữ liệu vào XML
    private void saveBooksToXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("books");
            doc.appendChild(rootElement);

            for (Book book : bookList) {
                Element bookElement = doc.createElement("book");

                Element title = doc.createElement("title");
                title.appendChild(doc.createTextNode(book.getTitle()));

                Element author = doc.createElement("author");
                author.appendChild(doc.createTextNode(book.getAuthor()));

                Element year = doc.createElement("year");
                year.appendChild(doc.createTextNode(String.valueOf(book.getYear())));

                Element publisher = doc.createElement("publisher");
                publisher.appendChild(doc.createTextNode(book.getPublisher()));

                Element pages = doc.createElement("pages");
                pages.appendChild(doc.createTextNode(String.valueOf(book.getPages())));

                Element genre = doc.createElement("genre");
                genre.appendChild(doc.createTextNode(book.getGenre()));

                Element price = doc.createElement("price");
                price.appendChild(doc.createTextNode(String.valueOf(book.getPrice())));

                Element isbn = doc.createElement("isbn");
                isbn.appendChild(doc.createTextNode(book.getIsbn()));

                bookElement.appendChild(title);
                bookElement.appendChild(author);
                bookElement.appendChild(year);
                bookElement.appendChild(publisher);
                bookElement.appendChild(pages);
                bookElement.appendChild(genre);
                bookElement.appendChild(price);
                bookElement.appendChild(isbn);

                rootElement.appendChild(bookElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hiển thị thông báo
    private void showAlert(String message, AlertType type) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.show();
    }
}