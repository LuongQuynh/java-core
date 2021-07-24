package com.onemount.compare;

import java.util.*;

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

    public void compareTwoFiles() {
        int sizeA = employeeListA.size();
        int sizeB = employeeListB.size();
        Collections.sort(employeeListB);
//        Iterator<Employee> it = employeeListB.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
        boolean isCheck = true;
        if (sizeA == sizeB) {
            for (int i = 0; i < sizeA; i++) {
                for (int j = 0; j < sizeB; j++) {
                    if (employeeListA.get(i).getId() == employeeListB.get(j).getId()) {
                        if (!employeeListA.get(i).compareTwoEmployees(employeeListB.get(j))) {
                            isCheck = false;
                            System.out.println("Different employee\n" + employeeListB.get(j).toString());
                        }

                    }
                }

            }
        }
        if (isCheck) {
            System.out.println("These files are the same");
        } else {
            System.out.println("These files are not the same");
        }
    }


}
