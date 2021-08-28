package com.Collection.Study.List.Study.LinkedList.Study;

import java.util.LinkedList;

public class LinkedListExercise02 {
    public static void main(String[] args) {
        //看源码，LinkedList  add(),remove()底层机制
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.addFirst(0);
        System.out.println(linkedList);
        linkedList.remove();
        //linkedList.remove(1);
        System.out.println(linkedList);
    }
}
