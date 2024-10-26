module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens hu.unideb.inf to javafx.fxml;
    exports hu.unideb.inf;
}
