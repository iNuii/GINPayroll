/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Employee;
import Model.User;
import java.util.LinkedList;

/**
 *
 * @author nuii
 */

public interface IPersist {
  // public void createDatabase();
  public  void addUsers(LinkedList<User> userList);
  public  void addEmployee(LinkedList<Employee> EmployeeList);
  public  LinkedList<Employee> selectEmployee();
  
  public void updateEmployeeInfo(Employee updatedEmployee);
  public void saveWorkedHours(Employee totalWorkedHour);
}
