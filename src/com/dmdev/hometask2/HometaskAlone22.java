package com.dmdev.hometask2;

import java.util.Scanner;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * Примечание: для решения может понадобиться функция возведение числа в степень: Math.pow(число, степень)
 */
public class HometaskAlone22 {
    public static void main(String[] args) {
        reverseNumber();
    }

    public static void reverseNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number. The number mustn't be equals to zero!");
        int number = scanner.nextInt();
        if (number == 0) {
            System.out.println("The number mustn't be equals to zero! Input correct number.");
            number = scanner.nextInt();
        }
        int reversedNumber;
        while (number != 0) {
            if (number % 10 != 0) {
                reversedNumber = number % 10;
                System.out.print(reversedNumber);
            } else if (number % 10 == 0) {
                reversedNumber = 0;
                System.out.print(reversedNumber);
            }
            number /= 10;
        }
    }
}
