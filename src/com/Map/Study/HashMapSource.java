package com.Map.Study;

import java.util.HashMap;

public class HashMapSource {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("java", 10);
        hashMap.put("php", 10);
        hashMap.put("java", 20);
        System.out.println(hashMap);

        HashMap hashMap1 = new HashMap();
        for (int i = 0; i < 24; i++) {
            hashMap1.put(i, "Uzi");
        }
        for (int i = 1; i < 12; i++) {
            hashMap1.put(new A(i), "Uzi");
        }
        System.out.println(hashMap1);
    }
}

class A {
    private int num;

    public A(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }

    @Override
    public int hashCode() {
        return 100;
    }
}