package com.Collections.Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsExercise {
    public static void main(String[] args) {
        //Collection工具类常用方法
        /*
           reverse（list）：反转List中的元素的顺序
           shuffle（List）：对List集合元素进行随机排序
           sort（List）：根据元素的自然顺序对指定List集合元素按升序排序
           sort（List，Comparator）：根据指定的Comparator产生的顺序对List集合元素进行排序
           swap（List,int,int）:将指定list集合中的i处元素和j处元素进行交换
         */
        ArrayList list = new ArrayList();
        list.add("对的时间点");
        list.add("将故事写成我们");
        list.add("幸存者");
        list.add("生生");
        list.add("交换余生");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println(list);
        Collections.swap(list, 0, 4);
        System.out.println(list);
        /*
    Object max(Collection):根据元素的自然排序，返回给定集合中的最大元素
    Object max(Collection,Comparator):根据Comparator指定的排序，返回给定集合中的最大元素
    Object min(Collection)：根据元素的自然排序，返回给定集合中的最小元素
    Object min(Collection,Comparator)：根据Comparator指定的排序，返回给定集合中的最小元素
       int frequency(Collection,Object):返回指定集合中指定元素的出现次数
      void copy(List dest,List str):将src中的内容复制到dest中
   boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换List对象的所有旧值
         */
        System.out.println("最大值="+Collections.max(list));
        System.out.println("最大长度="+Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length()-((String)o2).length();
            }
        }));
        System.out.println(Collections.frequency(list,"生生"));
        ArrayList dest = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
          dest.add(i);
        }
        System.out.println(dest);
        Collections.copy(dest,list);
        System.out.println(dest);
        Collections.replaceAll(list,"生生","修炼爱情");
        System.out.println(list);
    }
}
