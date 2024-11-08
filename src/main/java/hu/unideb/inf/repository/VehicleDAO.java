package hu.unideb.inf.repository;

import hu.unideb.inf.model.Vehicle;

public interface VehicleDAO extends AutoCloseable {
    void insertVehicle(Vehicle vehicle);

    @Override
    void close();
}
