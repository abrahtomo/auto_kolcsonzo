package hu.unideb.inf.repository;

import hu.unideb.inf.model.Vehicle;
import hu.unideb.inf.model.VehicleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public VehicleDAOImpl(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManager;
    }

    @Override
    public void insertVehicle(Vehicle vehicle) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(vehicle);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<VehicleType> getAllVehicleTypes(){
        this.entityManager.getTransaction().begin();
        List<VehicleType> vehicleTypes = this.entityManager.createQuery("SELECT vt FROM VehicleType vt", VehicleType.class).getResultList();
        this.entityManager.getTransaction().commit();
        return vehicleTypes;
    }

    @Override
    public List<Vehicle> getVehicles() {
        this.entityManager.getTransaction().begin();
        return entityManager.createQuery("SELECT v FROM Vehicle v", Vehicle.class).getResultList();
    }

    public void deleteVehicle(long VehicleID) {
        if (!this.entityManager.getTransaction().isActive()) {
            this.entityManager.getTransaction().begin();
        }

        this.entityManager.createQuery("DELETE FROM Vehicle v WHERE v.id = :vehicleID").setParameter("vehicleID", VehicleID).executeUpdate();
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
