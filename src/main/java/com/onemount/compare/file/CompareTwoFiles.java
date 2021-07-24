package com.onemount.compare.file;

import com.onemount.compare.Employee;

import java.io.File;

public class CompareTwoFiles {
    public static void main(String[] args) {
        File result = new Diff("fileA.csv", "fileB.csv").withFormat(Employee.class);
        System.out.println(result.getAbsoluteFile());
    }
}
