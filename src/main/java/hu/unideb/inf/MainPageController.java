package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private TableColumn vehicleTypeColumn;
    @FXML
    private TableColumn makeColumn;
    @FXML
    private TableColumn modelColumn;
    @FXML
    private TableColumn yearColumn;
    @FXML
    private TableColumn engineColumn;
    @FXML
    private TableColumn fuelTypeColumn;
    @FXML
    private TableColumn seatingCapacityColumn;


    @FXML
    private TextField vehicleTypeTF;
    @FXML
    private TextField makeTF;
    @FXML
    private TextField modelTF;
    @FXML
    private TextField yearTF;
    @FXML
    private TextField engineTF;
    @FXML
    private TextField fuelTypeTF;
    @FXML
    private TextField seatingCapacityTF;

    private void addVehicleBt(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
