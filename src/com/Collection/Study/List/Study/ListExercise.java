package com.Collection.Study.List.Study;

import java.util.ArrayList;
import java.util.List;

public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 12; i++) {
           list.add("hello" + i);
        }
        list.add(1,"污渍yyds");
        System.out.println(list.get(4));
        list.remove(5);
        list.set(6,"暗夜猎手");
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            Object obj = iterator.next();
//            System.out.println(obj);
//        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
