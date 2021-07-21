package com.onemount.compareTwoFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
    public List<Employee> fromFileCSV(String filename) {
        List<Employee> employees = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                Employee employee = createEmployee(attributes);
                employees.add(employee);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return employees;
    }

    private static Employee createEmployee(String[] metadata) {
        String fullName = metadata[0];
        int age = Integer.parseInt(metadata[1].trim());
        int idEmployee = Integer.parseInt(metadata[2].trim());
        String position = metadata[3].trim();
        String address = metadata[4].trim();
        String phoneNumber = metadata[5].trim();
        String email = metadata[6].trim();
        return new Employee(fullName, age, idEmployee, position, address, phoneNumber, email);
    }
}
