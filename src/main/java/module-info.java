module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens hu.unideb.inf to javafx.fxml;
    exports hu.unideb.inf;
}
