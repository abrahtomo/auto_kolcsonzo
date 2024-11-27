package hu.unideb.inf;

import hu.unideb.inf.model.User;
import hu.unideb.inf.repository.UserDAO;
import hu.unideb.inf.repository.UserDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class RegistrationPageController {

    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private PasswordField confirmPasswordTF;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private Button registerBtn;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void initialize() {
        entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @FXML
    private void registerBtnClicked(ActionEvent event) {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String confirmPassword = confirmPasswordTF.getText();
        String firstName = firstNameTF.getText();
        String lastName = lastNameTF.getText();
        String email = emailTF.getText();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
            showError("Hiba!", "Kérlek töltsd ki az összes mezőt.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError("Hiba!", "A jelszavak nem egyeznek!");
            return;
        }

        UserDAO userDAO = new UserDAOImpl(entityManagerFactory, entityManager);
        if (userDAO.isusernameTaken(username)) {
            showError("Hiba!","Ez a felhasználónév már foglalt.");
            return;
        }


        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setIsAdmin(0);

        userDAO.insertUser(user);

        showSuccess("Sikeres regisztráció!", "A regisztráció sikeresen megtörtént.");
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
