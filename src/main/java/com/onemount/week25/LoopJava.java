package com.onemount.week25;

import java.util.Scanner;

public class LoopJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i){
            case 0:
                System.out.println(" i is zero");
                break;
            case 1:
                System.out.println("i is one");
                break;
            case 2:
                System.out.println("i is two");
                break;
            default:
                System.out.println("i less than or greater than two3");
        }
        int a = 0;
        do {
            a++;
            System.out.println(a);
        }while (a<5);

    }


}
