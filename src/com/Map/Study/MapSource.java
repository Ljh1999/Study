package com.Map.Study;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSource {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("VN","暗夜猎手");
        map.put("卡莎","虚空之女");
        map.put("霞","逆羽");


        Set set = map.entrySet();
        System.out.println(set.getClass());
        for (Object obj :set) {
            System.out.println(obj.getClass());
              Map.Entry entry = (Map.Entry)obj;
              System.out.println(entry);
        }
        Set set1 = map.keySet();
        System.out.println(set1.getClass());
        Collection values = map.values();
        System.out.println(values.getClass());
    }
}
