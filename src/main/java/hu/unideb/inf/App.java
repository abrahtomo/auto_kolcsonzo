package hu.unideb.inf;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        scene = new Scene(loadFXML("MainPage"), 1280, 720);
        stage.setTitle("SFM Autókölcsönző");
        stage.setScene(scene);
        stage.show();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("auto_kolcsonzo");
        EntityManager em = emf.createEntityManager();

        Vehicle vehicle1 = new Vehicle("asd", "sdf", "fsd", 2010, "e", "b", 4);

        Vehicle vehicle2 = new Vehicle("asd", "sdf", "fsd", 2010, "e", "b", 4);

        em.getTransaction().begin();
        em.persist(vehicle1);
        em.persist(vehicle2);
        em.getTransaction().commit();

        var vehicles = em.createQuery("from Vehicle", Vehicle.class).getResultList();
        vehicles.forEach(System.out::println);

        em.close();
        emf.close();

        System.out.println("Database connected successfully!");
    }


    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}