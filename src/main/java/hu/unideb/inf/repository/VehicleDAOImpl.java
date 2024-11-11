package hu.unideb.inf.repository;

import hu.unideb.inf.model.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class VehicleDAOImpl implements VehicleDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public VehicleDAOImpl(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManager;
    }

    @Override
    public void insertVehicle(Vehicle vehicle) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(vehicle);
        entityManager.getTransaction().commit();
        entityManager.close();
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
