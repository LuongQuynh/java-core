package com.onemount.compareTwoFiles;

import java.util.List;

public class EmployeeList {
    private final static String fileA = "data/fileA.csv";
    private final static String fileB = "data/fileB.csv ";

    List<Employee> employeeListA;
    List<Employee> employeeListB;

    public void readFileCSV() {
        CSVReader readEmployee = new CSVReader();
        employeeListA = readEmployee.fromFileCSV(fileA);
        employeeListB = readEmployee.fromFileCSV(fileB);

    }
    public void compareTwoFiles(){
        int sizeA = employeeListA.size();
        int sizeB = employeeListB.size();
        boolean isCheck = false;
        if (sizeA == sizeB) {
            isCheck = true;
            for (int i = 0; i < sizeA; i++) {
                if (!employeeListA.get(i).toString().equals(employeeListB.get(i).toString())) {
                    isCheck = false;
                    break;
                }
            }
        }
        if (isCheck) {
            System.out.println("These two files are equal");
        } else {
            System.out.println("These two files are not equal");
        }
    }


}
