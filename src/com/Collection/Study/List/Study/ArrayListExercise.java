package com.Collection.Study.List.Study;

import java.util.ArrayList;

public class ArrayListExercise {
    public static void main(String[] args) {
        //看源码，底层扩容机制

        ArrayList list = new ArrayList();
//      ArrayList list1 = new ArrayList(8);
        for (int i = 0; i < 10 ; i++) {
            list.add(i);
        }
        for (int i = 11; i <= 15 ; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
        for (Object o : list) {
            System.out.println(o);
        }

    }
}
