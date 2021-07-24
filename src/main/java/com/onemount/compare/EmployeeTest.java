package com.onemount.compare;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        employeeList.readFileCSV();
        employeeList.compareTwoFiles();
//        File ketqua = Diff("file1.csv", "file2.csv").withFormat(Employee.class);
    }

}
