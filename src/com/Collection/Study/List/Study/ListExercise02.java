package com.Collection.Study.List.Study;

import java.util.ArrayList;
import java.util.List;

public class ListExercise02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("西游记", 55, "吴承恩"));
        list.add(new Book("三国演义", 88, "罗贯中"));
        list.add(new Book("红楼梦", 33, "施耐庵"));
        Pricesort(list);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void Pricesort(List list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
    }
}

class Book {
    private String name;
    private int price;
    private String author;

    @Override
    public String toString() {
        return "名称：" + name + "\t\t" + "价格：" + price + "\t\t" + "作者：" + author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }
}