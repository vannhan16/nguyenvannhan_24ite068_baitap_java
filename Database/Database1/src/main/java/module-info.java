module com.database1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;

    opens com.database1 to javafx.fxml;
    exports com.database1;
}