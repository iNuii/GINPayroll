/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.EmployeePersister;
import Model.User;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author nuii
 */
public class RegisterFormController implements Initializable {


    @FXML
    private Button clearButton;
    @FXML
    private Button exitButton;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private PasswordField CFpasswordTF;
    @FXML
    private TextField emailTF;
    @FXML
    private Button registerButton;
    
    private EmployeePersister employeePersister;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        employeePersister = new EmployeePersister();
        employeePersister.establishDatabaseConnection();
    }    
    
    @FXML
    private void clearButtonClick(ActionEvent event) {
        // Clear the input fields
        nameTF.clear();
        usernameTF.clear();
        passwordTF.clear();
        CFpasswordTF.clear();
        emailTF.clear();
    }

    @FXML
    private void exitButtonClick(ActionEvent event) {
        // Close the registration form window
        loadLoginPage();
    }

    @FXML
    private void registerButtonClick(ActionEvent event) {
    // Perform registration logic here
        String name = nameTF.getText();
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String confirmPassword = CFpasswordTF.getText();
        String email = emailTF.getText();

        // Check if any field is empty
        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        // Check if the passwords match
        if (!password.equals(confirmPassword)) {
            showAlert("Error", "Passwords do not match. Please try again.");
            return;
        }
        
           // Create a User object with the registration data
            User newUser = new User(name, username, password, email);

            // Create an instance of EmployeePersister (if not done already)
            EmployeePersister employeePersister = new EmployeePersister();

            // Add the new user to the database
            LinkedList<User> userList = new LinkedList<>();
            userList.add(newUser);
            employeePersister.addUsers(userList);

            // Optionally, you can show a success message or navigate to a different scene
            showAlert("Success", "Registration successful!");

            // Clear the input fields
            nameTF.clear();
            usernameTF.clear();
            passwordTF.clear();
            CFpasswordTF.clear();
            emailTF.clear();
}

    @FXML
        private void loadLoginPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login Page.fxml"));
            LoginController loginController = new LoginController(new EmployeePersister());
            loader.setController(loginController);
            Parent loginPage = loader.load();
            Scene scene = new Scene(loginPage);

            // Get the current stage (your registration form stage)
            Stage registrationStage = (Stage) nameTF.getScene().getWindow();

            // Set the new scene on the current stage
            registrationStage.setScene(scene);
            registrationStage.setTitle("Login Page");
            registrationStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load the login page.");
        }
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
    

}
