package com.mycompany.ginpayrollsystem;

import Controller.LoginController;
import Model.EmployeePersister;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    @Override
    public void start(Stage Stage) throws Exception {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login Page.fxml"));
            LoginController loginController = new LoginController(new EmployeePersister());
            loader.setController(loginController);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage.setScene(scene);
            Stage.setTitle("Login Page");
            Stage.show();
        }
    
    public static void main(String[] args) {
        launch(args);

    }


}