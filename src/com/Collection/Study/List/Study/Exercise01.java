package com.Collection.Study.List.Study;

import java.util.ArrayList;
import java.util.Collection;

public class Exercise01 {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add("VN");
        col.add("卡莎");
        col.add("逆羽");
//        Iterator iterator = col.iterator();
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//            System.out.println(next);
//        }
        for (Object obj:col) { 
            System.out.println(obj);
        }
    }
}
