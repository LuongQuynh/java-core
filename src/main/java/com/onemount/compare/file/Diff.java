package com.onemount.compare.file;

import com.onemount.compare.Employee;
import com.onemount.compare.file.model.Result;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Diff {
    private List<String> listA;
    private List<String> listB;

    public Diff(String file1, String file2) {
        listA = extracted(file1);
        listB = extracted(file2);

    }

    private List<String> extracted(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return lines;
    }

    public File withFormat(Class<Employee> employeeClass) {
        List<Employee> employeesA = getEmployee(listA);
        List<Employee> employeesB = getEmployee(listB);
        String result = compare(employeesA, employeesB);
        File file = writeToFile(result);
        return file;


    }

    private File writeToFile(String result) {
        File file = new File("result.csv");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(result);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private String compare(List<Employee> listA, List<Employee> listB) {
        // muon 2 cai list
        // so sanh
        // lay kich thuoc 2 ds a,b
        // so sanh tung object trong ds
        // lay mnv cua row trong ds 1 so sanh vs tat ca cac rows trong b
        String ketqua="hello";
        for (Employee e1 : listA) {
            for (Employee e2 : listB) {
                ketqua= compareTwoEmployee(e2,e1);
            }
        }
        return ketqua;

    }

    private String compareTwoEmployee(Employee e2, Employee e1) {
        String ketQua = "These are the same";
//        System.out.println(e1.getIdEmployee());
//        System.out.println(e2.getIdEmployee());

        if (e2.getIdEmployee().equals(e1.getIdEmployee())){
            System.out.println("I'm here");
            if (!e2.compareTwoEmployees(e1)){
                ketQua = e1.toString() + "\n" + e2.toString() + "\n-------------";
            }
        }
        return ketQua;

    }


    private List<Employee> getEmployee(List<String> rows) {
        List<Employee> employeesA = new ArrayList<>();
        for (String row : rows) {
            String[] columns = row.split(",");
            Employee employee = creatEmployee(columns);
//            System.out.println(employee);
            employeesA.add(employee);

        }
        return employeesA;
    }

    private Employee creatEmployee(String[] metadata) {
        int id = Integer.parseInt(metadata[0].trim());
        String fullName = metadata[1].trim();
        int age = Integer.parseInt(metadata[2].trim());
        String idEmployee = metadata[3].trim();
        String position = metadata[4].trim();
        String address = metadata[5].trim();
        String phoneNumber = metadata[6].trim();
        String email = metadata[7].trim();
        return new Employee(id, fullName, age, idEmployee, position, address, phoneNumber, email);

    }
}
