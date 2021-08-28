package com.Interface.study;

public class Testinterface {
    public static void main(String[] args) {
        DBinterface dBinterface = new Mysql();
        DBinterface dBinterface1 = new Sqlserver();
        c c = new c();
        c.imp(dBinterface1);
        Mysql mysql = new Mysql();
        System.out.println(mysql.n);
        System.out.println(DBinterface.n);
        System.out.println(Mysql.n);
    }
}
class c {

    public void imp(DBinterface dBinterface) {
        dBinterface.connect();
        dBinterface.close();
    }
}
