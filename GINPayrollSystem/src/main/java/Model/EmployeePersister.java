/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Employee;
import Model.User;
import View.IPersist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nuii
 */
public class EmployeePersister implements IPersist {
    private  final String MYSQL_URL;
    private  final String DB_URL;
    private  final String USERNAME;
    private  final String PASSWORD;
    private Connection sqlConnection;
    private Connection dbConnection;
    private PreparedStatement createDBPayroll;
    private PreparedStatement createTableUser;
    private PreparedStatement createTableEmployee;
    private PreparedStatement insertUser;
    private PreparedStatement insertEmployee;
    private PreparedStatement selectEmployee;
    
    private List<User> userList;
    public EmployeePersister(){
   
   // public void createDatabase() {   
    MYSQL_URL = "jdbc:mysql://localhost:3306";
        DB_URL = MYSQL_URL + "/payroll_db";
    /** 
     * The username and password should be changed to the username 
     * ad password for your MySql server.
     */
        USERNAME = "root";
        PASSWORD = "password";
        this.userList = new LinkedList<>();
        this.userList.add(new User("tom","tomm", "tomM123","tom@GIN.com.au"));
        this.userList.add(new User("hol","hols", "holS453","hols@GIN.com.au"));
        establishDatabaseConnection();
        addUsers((LinkedList<User>) this.userList);
    }
    
    public void establishDatabaseConnection(){
        try {
            //Connects to the SQL instance
            sqlConnection = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD); 
            //Creates the database if not exists
            createDBPayroll = sqlConnection.prepareStatement("create database if not exists payroll_db");
            createDBPayroll.executeUpdate();
            if (sqlConnection != null) {
               sqlConnection.close();
            }
           //Connects to database
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); 
            createTableUser = dbConnection.prepareStatement(""
                    + "create table if not exists user(\n"
                    + "employeeID int not null auto_increment,\n"
                    + "name varchar(50) not null, \n"
                    + "username varchar(50) not null,\n"
                    + "password varchar(10) not null,\n"
                    + "email varchar(50) not null, \n"
                    + "primary key (employeeID))");
            createTableEmployee = dbConnection.prepareStatement(""
                    + "create table if not exists employee(\n"
                    + "employeeID int not null auto_increment,\n"
                    + "firstname varchar(50) not null,\n"
                    + "lastname varchar(50) not null,\n"
                    + "address varchar(80) not null,\n"
                    + "contactnumber varchar(20) not null,\n"
                    + "birthdate varchar(12) not null,\n"
                    + "startdate varchar(12) not null,\n"
                    + "jobtitle varchar(20) not null,\n"
                    + "bankname varchar(50) not null,\n"
                    + "bsb varchar(12) not null,\n"
                    + "accountname varchar(50) not null,\n"
                    + "accountnumber varchar(50),\n"
                    + "primary key (employeeID))");
            createTableUser.executeUpdate();
            createTableEmployee.executeUpdate();
            insertEmployee = dbConnection.prepareStatement("insert into employee" 
                    + "(firstname, lastname, address, contactnumber, birthdate, startdate, jobtitle, bankname, bsb, accountname, accountnumber)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)");
            insertUser = dbConnection.prepareStatement("insert into user"
                    + "(name, username, password, email)"
                    + "values (?,?,?,?)");
            selectEmployee = dbConnection.prepareStatement("select * from employee");
            
        }catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }
    public boolean authenticateUser(String username, String password){
        try{
            PreparedStatement selectUser = dbConnection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            selectUser.setString(1,username);
            selectUser.setString(2, password);
            ResultSet results = selectUser.executeQuery();
            return results.next();
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
  //  @Override
    public void addUsers(LinkedList<User> userList)  {
        try {
            for (User oneUser : userList) {
                insertUser.setString(1, oneUser.getName());
                insertUser.setString(2, oneUser.getUsername());
                insertUser.setString(3, oneUser.getPassword());
                insertUser.setString(4, oneUser.getEmail());
                insertUser.executeUpdate();
            }
        }catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }
     public  void addEmployee(LinkedList<Employee> employeeList)  {
         try {
            for (Employee oneEmployee : employeeList) {
                insertEmployee.setString(1, oneEmployee.getFirstName());
                insertEmployee.setString(2, oneEmployee.getLastName());
                insertEmployee.setString(3, oneEmployee.getAddress());
                insertEmployee.setString(4, oneEmployee.getBirthDate());
                insertEmployee.setString(5, oneEmployee.getStartDate());
                insertEmployee.setString(6, oneEmployee.getBankName());
                insertEmployee.setString(7, oneEmployee.getBSB());
                insertEmployee.setString(8, oneEmployee.getAccountName());
                insertEmployee.setString(9, oneEmployee.getAccountNumber());

                insertEmployee.executeUpdate();
            }
        }catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }
    //Synchronised select of all records from residence needful table 
    public  LinkedList<Employee> selectEmployee()  {
        
        LinkedList<Employee> employeeList = new LinkedList<>();
        try{
           ResultSet results =  selectEmployee.executeQuery();
        while (results.next()) {
            employeeList.add(new Employee(
                    results.getLong("employeeid"),
                    results.getString("firstname"),
                    results.getString("lastname"),
                    results.getString("address"),
                    results.getString("contractnumber"),
                    results.getString("birthdate"),
                    results.getString("startdate"),
                    results.getString("jobtitle"),
                    results.getString("bankname"),
                    results.getString("bsb"),
                    results.getString("accountname"),
                    results.getString("accountnumber"),
                    results.getDouble("hourlyrate")));

                    }
        
        
        }catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
        return employeeList;
    }

}
