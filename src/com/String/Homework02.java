package com.String;

import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("请输入用户名：");
            String name = scanner.next();
            if (!(name.length() >= 2 && name.length() <= 4)) {
                throw new RuntimeException("用户名长度不正确");
            }
            System.out.println("请输入密码：");
            String password = scanner.next();
            if (!(password.length() == 6)) {
                throw new RuntimeException("长度必须为6");
            }
            for (int i = 0; i < password.length(); i++) {
                if (!(Character.isDigit(password.charAt(i)))) {
                    throw new RuntimeException("密码需要全为数字");
                }
            }
            System.out.println("请输入邮箱：");
            String email = scanner.next();
            int i = email.indexOf("@");
            int i1 = email.indexOf(".");

            if (!(i != -1 && i1 != -1 & i < i1)) {
                throw new RuntimeException("必须包含@和.，并且@要在.的前面");
            }
            System.out.println("注册成功！");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
