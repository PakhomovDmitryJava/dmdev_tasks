package com.dmdev.hometask6;

/**
 * Создать класс, описывающий банкомат.
 * Банкомат задается тремя свойствами: количеством купюр номиналом 20, 50 и 100.
 * Сделать методы для добавления денег в банкомат.
 * Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение - успешность выполнения операции.
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 */
public class Atm {
    private int note20;
    private int note50;
    private int note100;

    public Atm(int note100, int note50, int note20) {
        this.note20 = note20;
        this.note50 = note50;
        this.note100 = note100;
    }

    public void addNote20(Atm atm, int numberOfTwenties) {
        atm.setNote20(atm.getNote20() + numberOfTwenties);
    }

    public void addNote50(Atm atm, int numberOfFifties) {
        atm.setNote20(atm.getNote50() + numberOfFifties);
    }

    public void addNote100(Atm atm, int numberOfHundred) {
        atm.setNote20(atm.getNote100() + numberOfHundred);
    }

    public boolean cashWithdrawal(int cashToWithdrawal) {
        int cash = cashToWithdrawal;

        if (cashToWithdrawal > countMoneyInAtm() || cashToWithdrawal % 10 != 0 || cashToWithdrawal == 0) {
            return false;
        }

        int note100ToWithdrawal = cash / 100;
        if (note100ToWithdrawal <= note100) {
            cash = cash % 100;
            setNote100(note100 - note100ToWithdrawal);
        }

        int note50ToWithdrawal = cash / 50;
        if (note50ToWithdrawal <= getNote50() && cash % 20 != 0) {
            cash %= 50;
            setNote50(note50 - note50ToWithdrawal);
        } else {
            return false;
        }

        int note20ToWithdrawal = cash / 20;
        if (note20ToWithdrawal <= getNote20()) {
            System.out.println("20  - " + note20ToWithdrawal);
            cash %= 20;
            setNote20(note20 - note20ToWithdrawal);
        }

        return true;
    }

    public int countMoneyInAtm() {
        return getNote20() * 20 + getNote50() * 50 + getNote100() * 100;
    }

    public int getNote20() {
        return note20;
    }

    public void setNote20(int note20) {
        this.note20 = note20;
    }

    public int getNote50() {
        return note50;
    }

    public void setNote50(int note50) {
        this.note50 = note50;
    }

    public int getNote100() {
        return note100;
    }

    public void setNote100(int note100) {
        this.note100 = note100;
    }
}
