module com.mahoa1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;
    requires javafx.swing;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.mahoa1.bt1_md5_sha to javafx.fxml;
    opens com.mahoa1.bt2_encryptable to javafx.fxml;
    opens com.mahoa1.bt3_multithread to javafx.fxml;

    exports com.mahoa1.bt1_md5_sha;
    exports com.mahoa1.bt2_encryptable;
    exports com.mahoa1.bt3_multithread;
}
