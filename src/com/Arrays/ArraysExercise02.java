package com.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysExercise02 {
    public static void main(String[] args) {
        Book[] book = new Book[5];
        book[0] = new Book("ab", 32);
        book[1] = new Book("bzxv", 315);
        book[2] = new Book("casdas", 23);
        book[3] = new Book("dzc", 3235);
        book[4] = new Book("d", 455);

          Arrays.sort(book, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                int i1 = (int)(o1.getName().length());
                int i2 = (int)(o2.getName().length());
                return i2 - i1;
            }
         });
//        Book.sort(book, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                int i1 = (int) (o1.getPrice());
//                int i2 = (int) (o2.getPrice());
//                return i2 - i1;
//            }
//        });
        System.out.println(Arrays.toString(book));
    }
}

class Book {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
   public static int aa(){
        return 1;
   }
    //定制排序
    public static void sort(Book[] books, Comparator c) {
        Book temp = null;
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                //if (c.compare(books[j], books[j + 1]) > 0) {
                if (books[j].getName().length() < books[j + 1].getName().length()) {
                    temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }
}