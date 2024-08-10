package project;

import Database.ConnectDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<String> roleChoiceBox;

    public void initialize() {
        if (roleChoiceBox != null) {
            // Khởi tạo danh sách các vai trò
            List<String> roles = new ArrayList<>();
            roles.add("Manager");
            roles.add("User");

            // Gán danh sách vào ChoiceBox
            roleChoiceBox.getItems().addAll(roles);
        }
    }

    @FXML
    private void handleRegisterAction(ActionEvent event) {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String role = roleChoiceBox.getValue();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || role == null) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter all fields and select a role");
            return;
        }

            if (register(username, email, password, role)) {
            showAlert(Alert.AlertType.INFORMATION, "Registration Successful!", "Welcome " + username);
            try {
                // Redirect to login page after successful registration
                URL url = new File("src/project/Login.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);

                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Navigation Error", "Failed to load the login page.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Registration Failed!", "Failed to register the user.");
        }
    }

    private boolean register(String username, String email, String password, String role) {
        ConnectDB connectDB = new ConnectDB();
        Connection connection = connectDB.GetConnectDB();

        if (connection == null) {
            showAlert(Alert.AlertType.ERROR, "Database Error!", "Cannot connect to the database");
            return false;
        }

        String query = "INSERT INTO Users (username, email, password, role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, role);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                return true; // Registration successful
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false; // Registration failed
    }

    @FXML
    private void handleLoginAction(ActionEvent event) {
        try {
            URL url = new File("src/project/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);

            // Create the scene with the loaded FXML root
            Scene scene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Set the scene to the stage and display the stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Failed to load the login page.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
