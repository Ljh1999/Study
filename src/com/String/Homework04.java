package com.String;

public class Homework04 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
//        int a = 10;
//        int b = 5;
//        System.out.println("交换前：" + a + "," + b);
//        a = a + b;
//        b = a - b;
//        a = a - b;
//        System.out.println("交换后：" + a + "," + b);
        String s = "Hello 5201314 Ljh";
        char[] chars = s.toCharArray();
        int num = 0;
        int z = 0;
         int Z = 0;
        int c = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                num++;
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                z++;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                Z++;
            } else {
                c++;
            }
        }
        System.out.println("数字为：" + num + "小写字母为：" + z + "大写字母为：" + Z + "其他字符有：" + c);
    }
}
