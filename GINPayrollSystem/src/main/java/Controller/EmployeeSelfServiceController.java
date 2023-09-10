/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Employee;
import Model.EmployeePersister;


/**
 *
 * @author nuii
 */
public class EmployeeSelfServiceController {
    private Employee employee;
    private EmployeePersister empPersister;

    public void EmployeeSelfServiceController(EmployeePersister empPersister){
        this.empPersister = empPersister;
    }
    

       
}
