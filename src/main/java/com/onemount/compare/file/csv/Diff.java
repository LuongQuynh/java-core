package com.onemount.compare.file.csv;

import com.onemount.compare.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Diff {
    private List<String> listA;
    private List<String> listB;
    private static List<String> listResult;

    public Diff(String file1, String file2) {
        listA = readFile(file1);
        listB = readFile(file2);

    }

    private List<String> readFile(String fileName) {
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
        List<String> result = compareTwoList(employeesA, employeesB);
        File file = writeToFile(result);
        return file;


    }


    private List<String> compareTwoList(List<Employee> listA, List<Employee> listB) {
        List<String> diffList = new ArrayList<>();
        String ketQua = "hello";
        for (Employee e1 : listA) {
            for (Employee e2 : listB) {
                ketQua = compareTwoEmployee(e2, e1);
                if (!ketQua.isEmpty()) {
                    diffList.add(ketQua);
                }
            }
        }
        return diffList;

    }

    private String compareTwoEmployee(Employee e1, Employee e2) {
        String ketQua = "";
        if (e1.getIdEmployee().equals(e2.getIdEmployee())) {
            if (!e1.compareTwoEmployees(e2)) {
                ketQua = e1.toString() + "\n" + e2.toString() + "\n-------------";
            }
        }
        return ketQua;

    }

    private File writeToFile(List<String> result) {
        File mFile = new File("resources/writer.csv");
        try {
            FileWriter fw = new FileWriter(mFile);
            for (String str : result) {
                fw.write(str + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mFile;
    }


    private List<Employee> getEmployee(List<String> rows) {
        List<Employee> employees = new ArrayList<>();
        for (String row : rows) {
            String[] columns = row.split(",");
            Employee employee = createEmployee(columns);
            employees.add(employee);

        }
        return employees;
    }

    private Employee createEmployee(String[] metadata) {
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
