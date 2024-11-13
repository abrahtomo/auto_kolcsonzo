package hu.unideb.inf.repository;

import hu.unideb.inf.model.Vehicle;

import java.util.List;

public interface VehicleDAO extends AutoCloseable {
    void insertVehicle(Vehicle vehicle);
    List<Vehicle> getVehicles();
    void deleteVehicle(long VehicleID);

    @Override
    void close();
}
