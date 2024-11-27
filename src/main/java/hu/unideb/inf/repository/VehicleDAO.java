package hu.unideb.inf.repository;

import hu.unideb.inf.model.Vehicle;
import hu.unideb.inf.model.VehicleType;

import java.util.List;

public interface VehicleDAO extends AutoCloseable {
    void insertVehicle(Vehicle vehicle);
    List<Vehicle> getVehicles();
    List<VehicleType> getAllVehicleTypes();
    void deleteVehicle(long VehicleID);

    @Override
    void close();
}
