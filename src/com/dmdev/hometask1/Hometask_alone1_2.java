package com.dmdev.hometask1;

/**
 * Даны 3 переменные:
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */

public class Hometask_alone1_2 {
    public static void main(String[] args) {
        calculation(232,5,'+');
        calculation(5,10,'-');
        calculation(1231.2323,3333.3,'*');
        calculation(6565,0.5,'/');
    }

    public static void calculation(double x, double y, char mathSign) {
        switch (mathSign) {
            case '+' -> System.out.println(Double.toString(x) + " + " + Double.toString(y) + " = " + (x + y));
            case '-' -> System.out.println(Double.toString(x) + " - " + Double.toString(y) + " = " + (x - y));
            case '*' -> System.out.println(Double.toString(x) + " * " + Double.toString(y) + " = " + (x * y));
            case '/' -> System.out.println(Double.toString(x) + " / " + Double.toString(y) + " = " + (x / y));
        }
    }
}
