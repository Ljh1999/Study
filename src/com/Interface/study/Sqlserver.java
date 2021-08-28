package com.Interface.study;

public class Sqlserver implements DBinterface {
    @Override
    public void connect() {
        System.out.println(" 连接sqlserver");
    }

    @Override
    public void close() {
        System.out.println(" 关闭sqlserver");
    }
}
