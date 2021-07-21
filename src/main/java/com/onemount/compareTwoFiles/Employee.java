package com.onemount.compareTwoFiles;

public class Employee {
    private String fullName;
    private int age;
    private int idEmployee;
    private String position;
    private String address;
    private String phoneNumber;
    private String email;

    public Employee(String fullName, int age, int idEmployee, String position, String address, String phoneNumber, String email) {
        this.fullName = fullName;
        this.age = age;
        this.idEmployee = idEmployee;
        this.position = position;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", idEmployee=" + idEmployee +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
