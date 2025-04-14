module com.database1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;
    requires java.sql; // Thêm dòng này

    opens com.database1 to javafx.fxml;
    exports com.database1;
    opens com.database1.controller to javafx.fxml; // Nếu bạn sử dụng controller trong FXML
    exports com.database1.controller; // Nếu bạn sử dụng controller ở nơi khác
    exports com.database1.model; // Nếu bạn sử dụng model ở nơi khác
}