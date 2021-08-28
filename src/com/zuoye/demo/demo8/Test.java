package com.zuoye.demo.demo8;

public class Test {
    public static void main(String[] args) {
//        BankAccount bankAccount = new BankAccount(1000);
//        bankAccount.deposit(100);
//        bankAccount.withdraw(300);
//        System.out.println(bankAccount.getBalance());
//        CheckingAccount checkingAccount = new CheckingAccount(1000);
//        checkingAccount.deposit(500);//1499
//        checkingAccount.withdraw(300);
//        System.out.println(checkingAccount.getBalance());
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.withdraw(99);
        savingsAccount.earnMonthly();//1299*0.01 12.99
        savingsAccount.deposit(300);
        savingsAccount.withdraw(200);
        savingsAccount.deposit(100);
        savingsAccount.withdraw(10);
        System.out.println(savingsAccount.getBalance());
    }
}
