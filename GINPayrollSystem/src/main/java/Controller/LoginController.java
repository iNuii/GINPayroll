/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.EmployeePersister;
import java.io.IOException;
import java.net.URL;
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
 *
 * @author nuii
 */
public class LoginController implements Initializable {
    @FXML
    private TextField userTF;
    
    @FXML
    private PasswordField passTF;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Button registerButton;
    
    private EmployeePersister employeePersister;
    
    public LoginController(EmployeePersister employeePersister){
        this.employeePersister = employeePersister;
    }
    
    @FXML
    public void loginButtonClick(ActionEvent event){
        String username = userTF.getText();
        String password = passTF.getText();
        
        boolean isAuthenticated = employeePersister.authenticateUser(username, password);
        
        if (isAuthenticated) {
            try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Menu Page.fxml"));
                    Parent menuPage = loader.load();
                    Scene scene = new Scene(menuPage);
                    
                    // Get the current stage (your login stage)
                    Stage loginStage = (Stage) loginButton.getScene().getWindow();
                    
                    // Set the new scene on the current stage
                    loginStage.setScene(scene);
                    loginStage.setTitle("Menu Page");
                    loginStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                    showAlert("Error", "Failed to load the menu page.");
                }
        } else{
            showAlert("Authentication Error", "Invalid username or password. Please try again.");
        }
    }
  
    @FXML
    public void registerButtonClick(ActionEvent event){
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegisterForm.fxml"));
        Parent registrationForm = loader.load();
        Scene scene = new Scene(registrationForm);

        // Get the current stage (your login stage)
        Stage loginStage = (Stage) registerButton.getScene().getWindow();

        // Set the new scene on the current stage
        loginStage.setScene(scene);
        loginStage.setTitle("Registration");
        loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load the registration form.");
        }
    }
    private void showAlert(String title, String message){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        
        alert.showAndWait();
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
