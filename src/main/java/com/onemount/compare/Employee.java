package com.onemount.compare;

public class Employee implements Comparable<Employee> {
    private int id;
    private String fullName;
    private int age;
    private String idEmployee;
    private String position;
    private String address;
    private String phoneNumber;
    private String email;
    public Employee(int id, String fullName, int age, String idEmployee, String position, String address, String phoneNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.idEmployee = idEmployee;
        this.position = position;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public boolean compareTwoEmployees(Employee employee) {
        return this.id == employee.id
                && this.fullName.equals(employee.fullName)
                && this.age == employee.age
                && this.idEmployee.equals(employee.idEmployee)
                && this.position.equals(employee.position)
                && this.address.equals(employee.address)
                && this.phoneNumber.equals(employee.phoneNumber)
                && this.email.equals(employee.email);

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", idEmployee=" + idEmployee +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        if (age == employee.age)
            return 0;
        else if (age > employee.age)
            return 1;
        else
            return -1;
    }
}

