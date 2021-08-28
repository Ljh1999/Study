package com.zuoye.demo.demo8;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(int balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount-1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount+1);
    }
}
