module hu.unideb.inf {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.persistence;

    opens hu.unideb.inf to javafx.fxml;
    exports hu.unideb.inf;
}