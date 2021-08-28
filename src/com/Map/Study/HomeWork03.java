package com.Map.Study;

import java.util.*;

public class HomeWork03 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);
        System.out.println(hashMap);
        hashMap.put("jack",2600);
        System.out.println(hashMap);
        Set set = hashMap.keySet();
        for (Object o :set) {
            Object o1 = hashMap.get(o);
            hashMap.put(o,(Integer)o1+100);
        }
     System.out.println(hashMap);

        Set set1 = hashMap.entrySet();
        Iterator iterator = set1.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "-" +entry.getValue());
        }
        Collection values = hashMap.values();
        for (Object o :values) {
            System.out.println(o);
        }

    }
}