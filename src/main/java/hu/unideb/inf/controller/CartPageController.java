package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.model.Vehicle;
import hu.unideb.inf.repository.VehicleDAO;
import hu.unideb.inf.repository.VehicleDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class CartPageController {

    public Button homeBt;
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
    private Button deleteBt;
    @FXML
    private Button confirmBt;

    private ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();
    private ObservableList<Vehicle> cartList = FXCollections.observableArrayList();

    @FXML
    private TableView<Vehicle> cartTable;

    @FXML
    private TableColumn<Vehicle, String> cartMakeColumn;
    @FXML
    private TableColumn<Vehicle, String> cartModelColumn;

    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

   @FXML
    public void initialize() {
        // Initialize EntityManager
        entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        entityManager = entityManagerFactory.createEntityManager();

        // Bind columns to Vehicle properties
        vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        engineColumn.setCellValueFactory(new PropertyValueFactory<>("engine"));
        fuelTypeColumn.setCellValueFactory(new PropertyValueFactory<>("fuelType"));
        seatingCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("seatingCapacity"));


        // Load data into the table
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        // Use DAO to fetch data
        VehicleDAO vehicleDAO = new VehicleDAOImpl(entityManagerFactory, entityManager);

        List<Vehicle> vehicles = vehicleDAO.getVehicles();
        vehicleList.setAll(vehicles);

        // Set data to TableView
        vehicleTable.setItems(vehicleList);
    }

    @FXML
    private void adminPageBtClicked() throws IOException {
        MainApp.setRoot("AdminPage");
    }

    @FXML
    private void loginBtClicked(ActionEvent event) {
        // Handle login logic
    }

    @FXML
    private void registerBtClicked(ActionEvent event) {
        // Handle register logic
    }

    @FXML
    private void searchBtClicked(ActionEvent event) {
        // Implement search logic
    }

    public void homeBtClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("HomePage");
    }

    public void availableBtClicked(ActionEvent actionEvent){
        deleteBt.setVisible(false);
        confirmBt.setVisible(false);
       vehicleTable.setItems(vehicleList);
    }

    @FXML
    public void confirmVehicleBtClicked(ActionEvent actionEvent) {
        VehicleDAO vehicleDAO = new VehicleDAOImpl(entityManagerFactory, entityManager);
        for (Vehicle vehicle : cartList) {
            vehicleDAO.confirmRental(vehicle.getId()); // Save rental logic in DAO
        }
        cartList.clear();
        cartTable.getItems().clear();
    }



    public void viewCartBtClicked(ActionEvent actionEvent) {

        vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        engineColumn.setCellValueFactory(new PropertyValueFactory<>("engine"));
        fuelTypeColumn.setCellValueFactory(new PropertyValueFactory<>("fuelType"));
        seatingCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("seatingCapacity"));
        vehicleTable.setItems(cartList);
        deleteBt.setVisible(true);
        confirmBt.setVisible(true);
    }

    public void addCartBtClicked(ActionEvent actionEvent) {
        // Get the selected vehicle from the vehicleTable
        Vehicle selectedVehicle = vehicleTable.getSelectionModel().getSelectedItem();
        if (selectedVehicle != null) {
            // Add the selected vehicle to the cartList
            cartList.add(selectedVehicle);
            // Remove the vehicle from the vehicleList to avoid duplication
            vehicleList.remove(selectedVehicle);

            // Update both tables
            vehicleTable.setItems(vehicleList);
            cartTable.setItems(cartList);
        }
    }

    public void deleteVehicleBtClicked(ActionEvent actionEvent) {
        // Get the selected vehicle from the vehicleTable
        Vehicle selectedVehicle = vehicleTable.getSelectionModel().getSelectedItem();
        if (selectedVehicle != null) {
            // Add the selected vehicle to the cartList
            vehicleList.add(selectedVehicle);
            // Remove the vehicle from the vehicleList to avoid duplication
            cartList.remove(selectedVehicle);

            // Update both tables
            cartTable.setItems(cartList);
            vehicleTable.setItems(vehicleList);

        }
    }

}
