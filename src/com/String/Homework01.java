package com.String;

public class Homework01 {
    public static void main(String[] args) {
        String s = "abcdef";
        String r = null;
        try {
            r = reverse(s, 0, 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(r);
    }

    public static String reverse(String str, int start, int end) {
        if (!(str != null && start >= 0 && end < str.length() && start < end)) {
            throw new RuntimeException("参数不正确！");
        }
        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }
}
