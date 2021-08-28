package com.zuoye.demo.demo8;

public class BankAccount {
    private int balance;

    public void  deposit(double amount){
        balance += amount;
    }
    public void  withdraw(double amount){
        balance -= amount;
    }
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }
}
