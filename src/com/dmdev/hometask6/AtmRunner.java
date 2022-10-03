package com.dmdev.hometask6;

public class AtmRunner {
    public static void main(String[] args) {
        Atm atm = new Atm(1, 100, 2);
        System.out.println(atm.countMoneyInAtm());
        System.out.println(atm.cashWithdrawal(140));
        System.out.println(atm.countMoneyInAtm());
    }
}
