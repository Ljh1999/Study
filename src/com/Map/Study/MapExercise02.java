package com.Map.Study;

import java.util.*;

@SuppressWarnings({"all"})
public class MapExercise02 {
    public static void main(String[] args) {
        //Map遍历方式
        Map map = new HashMap();
        map.put("VN", "暗夜猎手");
        map.put("卡莎", "虚空之女");
        map.put("霞", "逆羽");
        map.put("韦鲁斯", "惩戒之箭");
        System.out.println("---根据entryset第一种---");
        Set set = map.entrySet();
        for (Object o : set) {
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println("---根据entryset第二种---");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }
        System.out.println("---根据key---");
        Set set1 = map.keySet();
        for (Object o : set1) {
            System.out.println(o + "=" + map.get(o));
        }
        System.out.println("---根据value---");
        Collection values = map.values();
        for (Object o : values) {
            Object o1 = map.get(map.keySet());
            System.out.println(map.get(o1) + "=" + o);
        }

    }
}
