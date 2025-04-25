module com.mahoa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens Exercise1.Controller to javafx.fxml;
    opens Exercise1 to javafx.fxml;
    exports Exercise1;
}