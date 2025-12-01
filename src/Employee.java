/**
 * The Employee class inherits from the Person class and represents employee information
 * Extend employee-specific attributes: employee ID and position
 */
public class Employee extends Person {
    // Employee ID, used to uniquely identify each employee
    private String employeeId;
    private String jobTitle;

    public Employee() {
    }

    /**
     * A parameter constructor that initializes all properties of the Employee object
     *
     * @param name The employee's name, passed to the parent Person class
     * @param age The age of the employee, passed to the parent Person class
     * @param gender The gender of the employee, passed to the parent Person class
     * @param employeeId Employee ID
     * @param jobTitle Employee job title
     */
    public Employee(String name, int age, String gender, String employeeId, String jobTitle) {
        // Call the constructor of the parent class Person to initialize the underlying properties
        super(name, age, gender);
        // Initialize employee-specific attributes
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
    }

    // The getter and setter methods are used to access and modify properties in the same way as in the Person class
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}