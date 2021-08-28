package com.Collection.Study.Set.Study;


import java.util.HashSet;

public class HashSetExercise02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
//        for (int i = 1; i <12 ; i++) {
//            hashSet.add(new Dog(i));
//        }
//        System.out.println(hashSet);
//    }
//        for (int i = 0; i < 7; i++) {
////            hashSet.add(new Dog(i));
////        }
////        for (int i = 0; i < 7; i++) {
////            hashSet.add(new B(i));
////        }
        hashSet.add(new String("hsp"));
        hashSet.add(new String("hsp"));
        hashSet.add(new C("tom"));
        hashSet.add(new C("tom"));
        String aaa = new String("aaa");
        String bbb = new String("aab");
        hashSet.add(aaa);
        hashSet.add(bbb);
        System.out.println(aaa.hashCode());
        System.out.println(bbb.hashCode());
        C zzz = new C("zzz");
        C ccc = new C("zzz");
        System.out.println(zzz.hashCode());
        System.out.println(ccc.hashCode());
        System.out.println(hashSet);
    }
}

class C {
    private String name;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public C(String name) {
        this.name = name;
    }
}

class B {
    private int n;

    public B(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}

class Dog {
    private int n;

    public Dog(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}