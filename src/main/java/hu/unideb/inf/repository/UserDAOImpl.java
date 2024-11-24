package hu.unideb.inf.repository;

import hu.unideb.inf.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public UserDAOImpl(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManager;
    }

    @Override
    public void insertUser(User user) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<User> getUsers() {
        this.entityManager.getTransaction().begin();
        return this.entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
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
