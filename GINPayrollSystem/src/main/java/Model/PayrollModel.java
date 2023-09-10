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
    private long id;
    private double salary;
    private double tax;
    private double superannuation;
    
    public void PayrollModel(long id, double salary, double tax, double superannuation){
        this.id = id;
        this.salary = salary;
        this.tax = tax;
        this.superannuation = superannuation;
    }
}
