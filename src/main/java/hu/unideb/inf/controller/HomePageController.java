package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import hu.unideb.inf.model.Vehicle;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HomePageController {

    @FXML
    private Button loginBt;
    @FXML
    private Button registerBt;
    @FXML
    private Button searchBt;
    @FXML
    private Button adminPageBt;

    @FXML
    private TextField searchTf;

    @FXML
    private TableView<Vehicle> vehicleTable;

    @FXML
    private TableColumn<Vehicle, String> vehicleTypeColumn;
    @FXML
    private TableColumn<Vehicle, String> makeColumn;
    @FXML
    private TableColumn<Vehicle, String> modelColumn;
    @FXML
    private TableColumn<Vehicle, Integer> yearColumn;
    @FXML
    private TableColumn<Vehicle, String> engineColumn;
    @FXML
    private TableColumn<Vehicle, String> fuelTypeColumn;
    @FXML
    private TableColumn<Vehicle, Integer> seatingCapacityColumn;

    @FXML
    private void adminPageBtClicked() throws IOException {
        MainApp.setRoot("AdminPage");
    }

    @FXML
    private void loginBtClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("LoginPage");
    }

    @FXML
    private void registerBtClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("RegisterPage");
    }

    @FXML
    private void searchBtClicked(ActionEvent event) {
    }
}
