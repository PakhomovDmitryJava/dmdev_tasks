package com.dmdev.hometask3;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: ['a', '6', 'y', 'P', 'T', 'q', '9', '+'] -> [97, 54, 121, 80, 84, 113, 57, 43]
 *
 * Далее определить среднее арифметическое всех элементов целочисленного массива
 * и вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class HometaskAlone32 {
    public static void main(String[] args) {
        char[] letters = {'d', 'q', 'z', 'Q', 's', 'C', 'L', '!'};
        replaceLetters(letters);
    }

    public static void replaceLetters(char[] values) {
        int[] results = new int[values.length];
        int average = 0;
        for (int i = 0; i < values.length; i++) {
            results[i] = values[i];
            average += results[i];
        }

        System.out.println("Average is: " + average / results.length);

        for (int result : results) {
            if (result > average / results.length) {
                System.out.print(result + " ");
            }

        }
    }


}
