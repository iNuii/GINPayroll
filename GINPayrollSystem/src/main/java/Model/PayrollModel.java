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

    public PayrollModel(long id, double salary, double tax, double superannuation) {
        this.id = id;
        this.salary = salary;
        this.tax = tax;
        this.superannuation = superannuation;
    }

    /**
     * Calculate the gross salary based on total worked hours and hourly rate.
     *
     * @param totalWorkedHours The total hours worked by the employee.
     * @param hourlyRate       The hourly rate of the employee.
     * @return The calculated gross salary.
     */
    public double calculateGrossSalary(double totalWorkedHours, double hourlyRate) {
        return totalWorkedHours * hourlyRate;
    }

    // Getter and setter methods for other fields (id, salary, tax, superannuation)
    // ...

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getSuperannuation() {
        return superannuation;
    }

    public void setSuperannuation(double superannuation) {
        this.superannuation = superannuation;
    }
}

