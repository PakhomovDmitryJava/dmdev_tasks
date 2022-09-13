package com.dmdev.hometask3;

import com.dmdev.lesson7.hometask.Hometask1;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * Пример:
 * [-4, 0, 1, 9, 0, -18, 3] -> {[-4, -18],[0, 0],[1, 9, 3]}
 */


public class Hometask3_3 {
    public static void main(String[] args) {
        int[] values = {4, 0, 1, -9, 0, 18, 3, -7, 100, -101};

        int[][] result = matrix(findNegativeArray(values), findZeroArray(values), findPositiveArray(values));
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] findPositiveArray(int[] array) {
        int[] resultPositive;
        int resultArrayLength = 0;
        for (int i : array) {
            if (i > 0) {
                resultArrayLength++;
            }
        }
        if (resultArrayLength == 0) {
            return resultPositive = new int[]{};
        } else {
            resultPositive = new int[resultArrayLength];
            for (int i = 0, k = 0; i < array.length; i++) {
                if (array[i] > 0) {
                    resultPositive[k++] = array[i];
                }
            }
            return resultPositive;
        }
    }

    public static int[] findNegativeArray(int[] array) {
        int[] resultNegative;
        int resultArrayLength = 0;
        for (int i : array) {
            if (i < 0) {
                resultArrayLength++;
            }
        }
        if (resultArrayLength == 0) {
            return resultNegative = new int[]{};

        } else {
            resultNegative = new int[resultArrayLength];
            for (int i = 0, k = 0; i < array.length; i++) {
                if (array[i] < 0) {
                    resultNegative[k++] = array[i];
                }
            }
            return resultNegative;
        }
    }

    public static int[] findZeroArray(int[] array) {
        int[] resultZero;
        int resultArrayLength = 0;
        for (int i : array) {
            if (i == 0) {
                resultArrayLength++;
            }
        }
        if (resultArrayLength == 0) {
            return resultZero = new int[]{};
        } else {
            resultZero = new int[resultArrayLength];
            for (int i = 0, k = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    resultZero[k++] = array[i];
                }
            }
            return resultZero;
        }
    }

    public static int[][] matrix(int[] negativeArray, int[] zeroArray, int[] positiveArray) {
        int[][] result = {negativeArray, zeroArray, positiveArray};
        return result;
    }


}
