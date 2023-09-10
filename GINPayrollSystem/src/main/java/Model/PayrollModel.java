/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nuii
 */
public class PayrollModel {
    private long employeeId;
    private double salary;
    private double tax;
    private double superannuation;
    
    public void PayrollModel(long employeeId, double salary, double tax, double superannuation){
        this.employeeId = employeeId;
        this.salary = salary;
        this.tax = tax;
        this.superannuation = superannuation;
    }
}
