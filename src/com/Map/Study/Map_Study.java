package com.Map.Study;

import java.util.HashMap;
import java.util.Map;

public class Map_Study {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("001","罗嘉豪");
        map.put("002","彭帅");
        map.put("003","谢祥聪");
        map.put("003","张力鹏");
        map.put("004","张力鹏");
        map.put(null,null);
        map.put(null,"zzz");
        map.put("005",null);
        map.put("006",null);
        map.put(new Object(),"ccc");
        System.out.println(map.get("001"));
        System.out.println(map);
    }
}
