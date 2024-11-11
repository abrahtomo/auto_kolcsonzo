package hu.unideb.inf.repository;

import hu.unideb.inf.model.Vehicle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VehicleDAOImplTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private VehicleDAOImpl vehicleDAO;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test-pu");
        entityManager = entityManagerFactory.createEntityManager();
        vehicleDAO = new VehicleDAOImpl(entityManagerFactory, entityManager);
    }

    @AfterEach
    void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testInsertVehicle() {
        Vehicle vehicle = new Vehicle("Sedan", "Toyota", "Camry", 2021, "2.5L I4", "Gasoline", 5, null);

        vehicleDAO.insertVehicle(vehicle);

        Vehicle retrievedVehicle = entityManager.find(Vehicle.class, vehicle.getId());
        assertNotNull(retrievedVehicle, "Vehicle should be inserted and retrievable");
        assertEquals(vehicle.getMake(), retrievedVehicle.getMake(), "Make should match");
        assertEquals(vehicle.getModel(), retrievedVehicle.getModel(), "Model should match");
        assertEquals(vehicle.getYear(), retrievedVehicle.getYear(), "Year should match");
    }
}
