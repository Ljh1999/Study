package com.Map.Study;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapExercise {
    public static void main(String[] args) {
//        TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo(((String)o2));
                //return ((String)o2).length()-((String)o1).length();
            }
        });
        treeMap.put("幸存者","林俊杰");
        treeMap.put("将故事写成我们","林俊杰");
        treeMap.put("对的时间点","林俊杰");
        treeMap.put("对的时间点","jj");
        System.out.println(treeMap);
    }
}
