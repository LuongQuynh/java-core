package com.onemount.compareTwoFiles;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        employeeList.readFileCSV();
        employeeList.compareTwoFiles();
    }
}
