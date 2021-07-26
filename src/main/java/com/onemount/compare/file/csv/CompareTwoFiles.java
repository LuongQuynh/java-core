package com.onemount.compare.file.csv;

import com.onemount.compare.Employee;

import java.io.File;

public class CompareTwoFiles {
    public static void main(String[] args) {
        File result = new Diff("resources/fileA.csv", "resources/fileB.csv").withFormat(Employee.class);
    }
}
