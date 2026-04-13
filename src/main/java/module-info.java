module org.example.app_com_interface {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires atlantafx.base;

    opens org.example.app_com_interface to javafx.fxml;
    exports org.example.app_com_interface;
}