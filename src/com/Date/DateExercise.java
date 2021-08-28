package com.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExercise {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        String s = "1999年5月16日 20:33:30 星期四";
        Date parse = simpleDateFormat.parse(s);
        String format1 = simpleDateFormat.format(parse);
        System.out.println(format1);
    }
}
