package com.Map.Study;

import java.util.HashMap;
import java.util.Map;

public class Mapexercise01 {
    public static void main(String[] args) {
    //Map常用方法
        Map map = new HashMap();
        map.put("VN","暗夜猎手");
        map.put("卡莎","虚空之女");
        map.put("霞","逆羽");
        map.put("韦鲁斯","惩戒之箭");
        System.out.println(map);
        map.remove("韦鲁斯");
        System.out.println(map);
        Object vn = map.get("VN");
        System.out.println(vn);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.containsKey("霞"));
        map.clear();
        System.out.println(map);
    }
}
