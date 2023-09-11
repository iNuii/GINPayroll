/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.IPersist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author nuii
 */
public class EmployeePersister implements IPersist {

    private final String MYSQL_URL;
    private final String DB_URL;
    private final String USERNAME;
    private final String PASSWORD;
    private Connection sqlConnection;
    private Connection dbConnection;
    private PreparedStatement createDBPayroll;
    private PreparedStatement createTableUser;
    private PreparedStatement createTableEmployee;
    private PreparedStatement createTablePayroll;
    private PreparedStatement insertUser;
    private PreparedStatement insertEmployee;

    public EmployeePersister() {

        // public void createDatabase() {   
        MYSQL_URL = "jdbc:mysql://localhost:3306";
        DB_URL = MYSQL_URL + "/payroll_db";
        /**
         * The username and password should be changed to the username ad
         * password for your MySql server.
         */
        USERNAME = "root";
        PASSWORD = "password";

        establishDatabaseConnection();

        try {
            insertEmployee = dbConnection.prepareStatement(""
                    + "insert into employee (id, name, address, contactphone, birthdate, bankname, bsb, accountname, accountnumber, tfn)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        } catch (SQLException e) {
            System.out.println("PreparedStatement initialization failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }

    }

    public void establishDatabaseConnection() {
        try {
            PreparedStatement replaceUser;
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
                    + "id int not null auto_increment,\n"
                    + "name varchar(50) not null, \n"
                    + "username varchar(50) not null,\n"
                    + "password varchar(10) not null,\n"
                    + "email varchar(50) not null, \n"
                    + "primary key (id))");
            createTableEmployee = dbConnection.prepareStatement(""
                    + "create table if not exists employee(\n"
                    + "id int not null auto_increment,\n"
                    + "name varchar(100) not null,\n"
                    + "address varchar(80) not null,\n"
                    + "contactphone varchar(20) not null,\n"
                    + "birthdate varchar(12) not null,\n"
                    + "bankname varchar(50) not null,\n"
                    + "bsb varchar(12) not null,\n"
                    + "accountname varchar(50) not null,\n"
                    + "accountnumber varchar(50),\n"
                    + "tfn varchar(50), \n"
                    + "primary key (id))");
            createTablePayroll = dbConnection.prepareStatement(""
                    + "create table if not exists payroll(\n"
                    + "id int not null auto_increment,\n"
                    + "workedhour int not null,\n"
                    + "hourlyrate int not null,\n"
                    + "tax int not null,\n"
                    + "paydate date not null,\n"
                    + "periodpay varchar(20) not null, \n"
                    + "primary key (id))");
            createTableUser.executeUpdate();
            createTableEmployee.executeUpdate();
            createTablePayroll.executeUpdate();

            replaceUser = dbConnection.prepareStatement(
                    "replace into user"
                    + "(id, name, username, password, email)"
                    + "values (1, 'tom','tomm','tomM123','tom@GIN.com.au')"
            );
            replaceUser.executeUpdate();
            replaceUser = dbConnection.prepareStatement(
                    "replace into user"
                    + "(id, name, username, password, email)"
                    + "values (2, 'hol','hols','holS453','hols@GIN.com.au')"
            );
            replaceUser.executeUpdate();
            // this.userList = new LinkedList<>();
            // this.userList.add(new User("tom","tomm", "tomM123","tom@GIN.com.au"));
            // this.userList.add(new User("hol","hols", "holS453","hols@GIN.com.au"));
            // for (User oneUser : userList) {
            //     replaceUser.setString(1, oneUser.getName());
            //     replaceUser.setString(2, oneUser.getUsername());
            //     replaceUser.setString(3, oneUser.getPassword());
            //     replaceUser.setString(4, oneUser.getEmail());
            //     replaceUser.executeUpdate();
            // }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(String username, String password) {
        try {
            PreparedStatement selectUser = dbConnection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            selectUser.setString(1, username);
            selectUser.setString(2, password);
            ResultSet results = selectUser.executeQuery();
            return results.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //  @Override

    public void addUsers(LinkedList<User> userList) {
        try {
            for (User oneUser : userList) {
                insertUser.setString(1, oneUser.getName());
                insertUser.setString(2, oneUser.getUsername());
                insertUser.setString(3, oneUser.getPassword());
                insertUser.setString(4, oneUser.getEmail());
                insertUser.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public void addEmployee(LinkedList<Employee> employeeList) {
        try {
            for (Employee oneEmployee : employeeList) {
                insertEmployee.setString(1, oneEmployee.getid());
                insertEmployee.setString(2, oneEmployee.getName());
                insertEmployee.setString(3, oneEmployee.getAddress());
                insertEmployee.setString(4, oneEmployee.getContactPhone());
                insertEmployee.setString(5, oneEmployee.getDob());
                insertEmployee.setString(6, oneEmployee.getBankName());
                insertEmployee.setString(7, oneEmployee.getBSB());
                insertEmployee.setString(8, oneEmployee.getAccountName());
                insertEmployee.setString(9, oneEmployee.getAccountNumber());
                insertEmployee.setString(10, oneEmployee.getTfn());

                insertEmployee.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    //Synchronised select of all records from residence needful table 
    public LinkedList<Employee> selectEmployee() {

        LinkedList<Employee> employeeList = new LinkedList<>();
        try {
            PreparedStatement selectEmployee = dbConnection.prepareStatement("select * from employee");
            ResultSet results = selectEmployee.executeQuery();
            while (results.next()) {
                employeeList.add(new Employee(
                        results.getString("id"),
                        results.getString("name"),
                        results.getString("address"),
                        results.getString("contactphone"),
                        results.getString("birthdate"),
                        results.getString("bankname"),
                        results.getString("bsb"),
                        results.getString("accountname"),
                        results.getString("accountnumber"),
                        results.getString("tfn")));

            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
        return employeeList;
    }

    public void updateEmployeeInfo(Employee updatedEmployee) {
        try {
            // Create an SQL update statement to update the employee record
            String updateQuery = "UPDATE employee "
                    + "SET name=?, address=?, contactphone=?, birthdate=?, bankname=?, bsb=?, accountname=?, accountnumber=?, tfn=? "
                    + "WHERE id=?"; // Assuming 'id' is the primary key column

            PreparedStatement updateStatement = dbConnection.prepareStatement(updateQuery);

            // Set the parameters in the update statement using the updatedEmployee object
            updateStatement.setString(1, updatedEmployee.getName());
            updateStatement.setString(2, updatedEmployee.getAddress());
            updateStatement.setString(3, updatedEmployee.getContactPhone());
            updateStatement.setString(4, updatedEmployee.getDob());
            updateStatement.setString(5, updatedEmployee.getBankName());
            updateStatement.setString(6, updatedEmployee.getBSB());
            updateStatement.setString(7, updatedEmployee.getAccountName());
            updateStatement.setString(8, updatedEmployee.getAccountNumber());
            updateStatement.setString(9, updatedEmployee.getTfn());
            updateStatement.setString(10, updatedEmployee.getid());

            // Execute the update statement to update the employee record
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public void saveWorkedHours(Employee employee) {
        try {
            double workedHours = employee.getWorkedHours();
            // Create an SQL insert statement to save worked hours to the payroll table
            String insertQuery = "INSERT INTO payroll (workedhour) VALUES (?)";

            PreparedStatement insertStatement = dbConnection.prepareStatement(insertQuery);

            // Set the parameter in the insert statement with the worked hours value
            insertStatement.setDouble(2, workedHours);

            // Execute the insert statement to save the worked hours
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insertion of worked hours failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

}
