package com.Date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class LocalDateTimeExercise {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(dateTime);
        System.out.println(format);
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getMonth());
        System.out.println(dateTime.getMonthValue());
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getHour());
        System.out.println(dateTime.getMinute());
        System.out.println(dateTime.getSecond());

        Instant instant = Instant.now();
        System.out.println("" + instant);
        Date date = Date.from(instant);
        System.out.println("" + date);
        Instant instant1 = date.toInstant();
        System.out.println("" + instant1);
    }
}
