package hu.unideb.inf;

import hu.unideb.inf.model.Vehicle;
import hu.unideb.inf.model.VehicleType;
import hu.unideb.inf.repository.VehicleDAO;
import hu.unideb.inf.repository.VehicleDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserPageController implements Initializable {

    @FXML
    private Button dieselBt;
    @FXML
    private Button gasolineBt;
    @FXML
    private Button hybridBt;
    @FXML
    private Button rentBt;

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
    private TableColumn<Vehicle, String> priceColumn;
    @FXML
    private TableColumn<Vehicle, Integer> TypeIDColumn;

    private ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();

    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        entityManager = entityManagerFactory.createEntityManager();

        vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        engineColumn.setCellValueFactory(new PropertyValueFactory<>("engine"));
        fuelTypeColumn.setCellValueFactory(new PropertyValueFactory<>("fuelType"));
        seatingCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("seatingCapacity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        TypeIDColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        loadDataFromDatabase();
    }


    private void loadDataFromDatabase() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        VehicleDAO vehicleDAO = new VehicleDAOImpl(entityManagerFactory, entityManager);

        List<Vehicle> vehicles = vehicleDAO.getVehicles();
        vehicleList.setAll(vehicles);

        entityManager.getTransaction().commit();
        entityManager.close();

        vehicleTable.setItems(vehicleList);
    }

    @FXML
    void dieselBtClicked(ActionEvent event) {

    }

    @FXML
    void gasolineBtClicked(ActionEvent event) {

    }

    @FXML
    void hybridBtClicked(ActionEvent event) {

    }

    @FXML
    void rentBtClicked(ActionEvent event) {

    }

}
