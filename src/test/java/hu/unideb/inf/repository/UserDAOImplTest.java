package hu.unideb.inf.repository;

import hu.unideb.inf.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDAOImplTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private UserDAOImpl userDAOImpl;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test-pu");
        entityManager = entityManagerFactory.createEntityManager();
        userDAOImpl = new UserDAOImpl(entityManagerFactory, entityManager);
    }

    @AfterEach
    void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testUserQueries() {
        User user = new User("UserName", "pw", "Kand", "Úr", "valami@valami.valami", 0);

        userDAOImpl.insertUser(user);

        List<User> users = userDAOImpl.getUsers();

        assertEquals(1, users.size());
        assertTrue(userDAOImpl.isusernameTaken("UserName"));
    }
}
