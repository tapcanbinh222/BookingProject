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
import java.sql.ResultSet;
import javafx.application.Platform;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<String> roleChoiceBox;
    
    @FXML
    private void initialize() {
        // Add event filters to handle the Enter key press for both fields
        usernameField.setOnAction(this::handleLoginAction);
        passwordField.setOnAction(this::handleLoginAction);

        // Add role options to the ChoiceBox
        roleChoiceBox.getItems().addAll("Manager", "User");
    }

    @FXML
    private void handleLoginAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = roleChoiceBox.getValue();

        if (username.isEmpty() || password.isEmpty() || role == null) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter username, password and select a role");
            return;
        }

        if (authenticate(username, password, role)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful!", "Welcome " + username);
            try {
                URL url;
                Parent root;
                // Load appropriate FXML based on selected role
                if (role.equals("Manager")) {
                    url = new File("src/project/Project.fxml").toURI().toURL();
                    root = FXMLLoader.load(url);
                } else {
                    url = new File("src/project/UserHome.fxml").toURI().toURL();
                    root = FXMLLoader.load(url);
                }
                
                // Create the scene with the loaded FXML root
                Scene scene = new Scene(root);

                // Get the current stage
                Stage stage = (Stage) usernameField.getScene().getWindow();
                 if (role.equals("Manager") || role.equals("User") ) {
                    Platform.runLater(() -> stage.setMaximized(true));
                }
                // Set the scene to the stage and display the stage
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Navigation Error", "Failed to load the home page.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed!", "Incorrect username, password, or role");
        }
    }

    private boolean authenticate(String username, String password, String role) {
        ConnectDB connectDB = new ConnectDB();
        Connection connection = connectDB.GetConnectDB();

        if (connection == null) {
            showAlert(Alert.AlertType.ERROR, "Database Error!", "Cannot connect to the database");
            return false;
        }

        String query = "SELECT * FROM Users WHERE username = ? AND password = ? AND role = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true; // Authentication successful
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
        return false; // Authentication failed
    }

    @FXML
    private void handleRegister(ActionEvent event) {
        try {
            URL url = new File("src/project/Register.fxml").toURI().toURL();
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
            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Failed to load the registration page.");
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
