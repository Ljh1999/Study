package com.StringBuffer.Study;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品名称：");
        String name = scanner.next();
        System.out.println("请输入商品价格：");
        String price = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(name);
        StringBuffer stringBuffer1 = new StringBuffer(price);
        for (int i = stringBuffer1.lastIndexOf(".") - 3; i > 0; i -= 3) {
            stringBuffer1.insert(i - 3, ",");
        }
        System.out.println("商品名" + "\t商品价格");
        System.out.println(stringBuffer + "\t" + stringBuffer1);
    }
}
