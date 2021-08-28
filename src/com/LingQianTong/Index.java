package com.LingQianTong;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ispass = true;
        double money = 0;//入账金额
        double yue = 0;//余额
        Date date = null;//消费日期
        String deitls = "";//入账明细打印，字符串拼接
        //消费功能
        String name = "";//消费名
        double xmoney = 0;//消费金额
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String isclose = "";

        do {
            System.out.println("------------零钱通菜单---------- ");
            System.out.println("1 零钱通明细");
            System.out.println("2 收益入账");
            System.out.println("3 消费");
            System.out.println("4 退 出");
            System.out.println("请选择（1-4）：");
            int lable = scanner.nextInt();
            switch (lable) {
                case 1:
                    System.out.println("----------零钱通明细----------");
                    System.out.println(deitls);
                    break;
                case 2:
                    System.out.println("----------收益入账----------");

                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
                    if (money <= 0) {
                        System.out.println("入账的金额不能小于等于0");
                        break;
                    } else {
                        yue += money;
                        date = new Date();
                        System.out.println("\n收益入账" + "\t" + "+" + money + "\t" + simpleDateFormat.format(date) + "\t" + yue);
                        deitls += "\n收益入账" + "\t" + "+" + money + "\t" + simpleDateFormat.format(date) + "\t" + yue;
                        break;
                    }
                case 3:
                    System.out.println("----------消费----------");
                    System.out.print("商品名：");
                    name = scanner.next();
                    System.out.print("消费金额：");
                    xmoney = scanner.nextDouble();
                    if (xmoney > yue || xmoney <= 0) {
                        System.out.println("您的消费金额应该在0-" + yue);
                        break;
                    } else {
                        yue -= xmoney;
                        date = new Date();
                        deitls += "\n" + name + "\t" + "-" + xmoney + "\t" + simpleDateFormat.format(date) + "\t" + yue;
                        System.out.println("\n" + name + "\t" + "-" + xmoney + "\t" + simpleDateFormat.format(date) + "\t" + yue);
                        break;
                    }
                case 4:

                    while (true) {
                        System.out.println("你确认要退出吗：（y/n）");
                        isclose = scanner.next();
                        if ("y".equals(isclose) || "n".equals(isclose)) {
                            break;
                        }
                    }
                    if (isclose.equals("y")) {
                        ispass = false;
                        break;
                    } else {
                        break;
                    }
                default:
                    System.out.println("您的选择有误！");
            }
        } while (ispass);

        System.out.println("退出了零钱通项目！");

    }
}
