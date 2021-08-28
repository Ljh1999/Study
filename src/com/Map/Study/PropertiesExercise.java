package com.Map.Study;

import java.util.Properties;

public class PropertiesExercise {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("aaa",100);
        properties.put("bbb",100);
        properties.put("ccc",100);
        properties.put("aaa",50);
        System.out.println(properties);

        System.out.println(properties.get("aaa"));
        System.out.println(properties.getProperty("aaa"));

    }
}
