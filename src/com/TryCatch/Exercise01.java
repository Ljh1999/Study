package com.TryCatch;


import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        while (true) {
            String res = scanner.next();
            try {
                int temp = Integer.parseInt(res);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是整数，请重新输入：");
            }
        }
        System.out.println("程序退出...");
    }
}
