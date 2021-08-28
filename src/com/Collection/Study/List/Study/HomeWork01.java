package com.Collection.Study.List.Study;

import java.util.ArrayList;

public class HomeWork01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Journalism("新闻一：新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧"));
        list.add(new Journalism("新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));
        for (int i = list.size()-1; i >= 0; i--) {
            Journalism j = (Journalism) list.get(i);
            if(j.getTitle().length()>15){
                String substring = j.getTitle().substring(0,15) + "...";
                System.out.println(substring);
            }
        }

    }
}

class Journalism {
    private String title;
    private String data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Journalism{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Journalism(String title) {
        this.title = title;
    }
}