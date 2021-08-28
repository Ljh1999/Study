package com.String;

public class Homework03 {
    public static void main(String[] args) {
        String s = "Han shun Ping";
        pringname(s);

    }
    public static void pringname(String str) {
        String[] s = str.split(" ");
        String format = String.format("%s,%s .%c", s[2], s[0], s[1].toUpperCase().charAt(0));
        System.out.println(format);
    }

}
