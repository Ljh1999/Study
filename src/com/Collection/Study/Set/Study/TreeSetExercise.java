package com.Collection.Study.Set.Study;

import java.util.TreeSet;

public class TreeSetExercise {
    public static void main(String[] args) {
        //TreeSet treeSet = new TreeSet();
//        TreeSet treeSet = new TreeSet(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                //return ((String)o2).length()-((String)o1).length();
//                return ((String)o1).compareTo(((String)o2));
//            }
//        });
        TreeSet treeSet = new TreeSet();
        treeSet.add("我的心太乱");
        treeSet.add("搁浅");
        treeSet.add("爱上你");
        treeSet.add("爱上你");
        System.out.println(treeSet);
    }
}
