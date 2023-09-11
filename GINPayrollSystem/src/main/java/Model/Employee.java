/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nuii
 */
public class Employee {
    private String id;
    private String name;
    private String address;
    private String contactPhone;
    private String dob;
    private String bankName;
    private String BSB;
    private String accountName;
    private String accountNumber;
    private String tfn;
    private Double workedHours;


    public Employee() {
    }

    public Employee(String id, String name, String address, String contactPhone, String dob, String bankName, String BSB, String accountName, String accountNumber, String tfn, Double workedHours) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactPhone = contactPhone;
        this.dob = dob;
        this.bankName = bankName;
        this.BSB = BSB;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.tfn = tfn;
        this.workedHours = workedHours;
    }

    public Employee(String id, String name, String address, String contactPhone, String dob, String bankName, String BSB, String accountName, String accountNumber, String tfn) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactPhone = contactPhone;
        this.dob = dob;
        this.bankName = bankName;
        this.BSB = BSB;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.tfn = tfn;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBSB() {
        return BSB;
    }

    public void setBSB(String BSB) {
        this.BSB = BSB;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTfn() {
        return tfn;
    }

    public void setTfn(String tfn) {
        this.tfn = tfn;
    }

    public Double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Double workedHours) {
        this.workedHours = workedHours;
    }

    
    
    
}
