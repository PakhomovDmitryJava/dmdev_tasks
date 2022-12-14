package hometask6;
/**
 * Создать класс, описывающий банкомат.
 * Банкомат задается тремя свойствами: количеством купюр номиналом 20, 50 и 100.
 * Сделать методы для добавления денег в банкомат.
 * Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение - успешность выполнения операции.
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 */
public class AtmRunner {
    public static void main(String[] args) {
        Atm atm = new Atm(0, 0, 0);
        atm.addNote20(1000);
        atm.addNote50(1000);
        atm.addNote100(1000);
        atm.cashWithdrawal(230);
    }
}
