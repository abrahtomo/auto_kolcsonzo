package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class RegisterPageController {
    @FXML
    private TextField emailTf;
    @FXML
    private TextField firstNameTf;
    @FXML
    private TextField lastNameTf;
    @FXML
    private TextField passwordTf;
    @FXML
    private Button registerBt;
    @FXML
    private TextField usernameTf;


    @FXML
    void registerBtClicked(ActionEvent event) {

        String username = usernameTf.getText();
        String firstName = firstNameTf.getText();
        String lastName = lastNameTf.getText();
        String email = emailTf.getText();
        String password = passwordTf.getText();

        if(username.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showError("Hiba!", "Kérlek töltsd ki az összes mezőt.");
        }

    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
