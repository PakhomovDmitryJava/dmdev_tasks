package com.dmdev.hometask3;

import com.dmdev.lesson7.hometask.Hometask1;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы
 * (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции. main - только для тестирования написанного функционала.
 */
public class HometaskAlone31 {
    public static void main(String[] args) {
        int[] numbers = {3, 5, -6, 3, 2, -9, 0, -123,3, 5, -6, 3, 2, -9, 0, -1233, 5, -6, 3, 2, -9, 0, -1233, 5, -6, 3, 2, -9, 0, -123 };
        Hometask1.printArray(creatingNewArray(numbers));
    }

    public static int positiveNumbersCounting(int[] array) {
        int positiveNumbersCounter = 0;
        for (int i : array) {
            if (i >= 0) {
                positiveNumbersCounter++;
            }
        }
        return positiveNumbersCounter;
    }

    public static int[] creatingNewArray(int[] array) {
        int resultArrayLength = positiveNumbersCounting(array);
        int[] result = new int[resultArrayLength];
        for (int i = 0, k = 0; i < array.length; i++) {
            array[i] *= resultArrayLength;
            if (array[i] >= 0) {
                result[k++] = array[i];
            }
        }
        return result;
    }
}
