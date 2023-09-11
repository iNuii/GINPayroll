/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nuii
 */
public class MenuPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private MenuItem employeeInfo;

    @FXML
    private MenuItem timeSheet;
    
    @FXML
    private MenuItem payslip;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void emInfoClick() throws IOException {
        // TODO
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EmployeeInfo.fxml"));
        Parent addEmployeeParent = loader.load();
        Scene scene = new Scene(addEmployeeParent);

        // Get the current stage (your login stage)
        Stage currentStage = (Stage) employeeInfo.getParentPopup().getOwnerWindow();
        // Set the new scene on the current stage
        currentStage.setScene(scene);
        currentStage.setTitle("Employee Information");
        currentStage.show();
    }

    public void timeSheetClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TimeSheet.fxml"));
        Parent timeSheetParent = loader.load();
        Scene scene = new Scene(timeSheetParent);

        // Get the current stage (your login stage)
        Stage currentStage = (Stage) timeSheet.getParentPopup().getOwnerWindow();
        // Set the new scene on the current stage
        currentStage.setScene(scene);
        currentStage.setTitle("Working Time Sheet");
        currentStage.show();
    }
    
        public void payslipClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaymentReport.fxml"));
        Parent payslipParent = loader.load();
        Scene scene = new Scene(payslipParent);

        // Get the current stage (your login stage)
        Stage currentStage = (Stage) payslip.getParentPopup().getOwnerWindow();
        // Set the new scene on the current stage
        currentStage.setScene(scene);
        currentStage.setTitle("Payslip Report");
        currentStage.show();
    }
    

}
