package com.fengzhuang.study;

public class demo2 {
    public static void main(String[] args) {
        Account account = new Account();
        account.setName("罗嘉豪ad");
        account.setYe(10);
        account.setPasswd("12345612");
        account.info();
    }
}

class Account {
    public String name;
    private double ye;

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        if(passwd.length()==6){
        this.passwd = passwd;}
        else {
            System.out.println(" 密码必须是6位，给默认密码");
            this.passwd="123456";
        }
    }

    private String passwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()>=2 && name.length()<=4){
        this.name = name;}
        else {
            System.out.println(" 长度不合法,给默认值");
            this.name = "zzz";
        }
    }

    public double getYe() {
        return ye;
    }

    public void setYe(double ye) {
        if(ye>20){
        this.ye = ye;}
        else {
            System.out.println(" 余额必须大于20，给默认值");
            this.ye = 50;
        }
    }



    public void info() {
        System.out.println(" name=" + name + " ye=" + ye + " passwd=" + passwd);
    }
}