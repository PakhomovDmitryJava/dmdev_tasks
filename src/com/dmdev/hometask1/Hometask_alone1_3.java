package com.dmdev.hometask1;
/** Даны два прямоугольных треугольника.
  * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
  * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.

  * Для этого понадобится написать 2 функции.
  * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
  * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
  * Учитывать, что площадь может быть вещественным числом.
 * */
public class Hometask_alone1_3 {
    public static void main(String[] args) {
        triangleСomparison(triangleSquare(4.2,5.2), triangleSquare(4.2,5.2) );
    }

    // S triangle = (a × b) / 2
    public static double triangleSquare(double aSide, double bSide) {
        return (aSide * bSide) / 2;
    }
    // Comparsion
    public static void triangleСomparison(double triangleSquare1, double triangleSquare2) {
        if (triangleSquare1 > triangleSquare2) {
            System.out.println("The first triangle is bigger than the second triangle!");
        } else if (triangleSquare1 == triangleSquare2) {
            System.out.println("The triangles are equal!");
        } else if (triangleSquare1 < triangleSquare2) {
            System.out.println("The first triangle is smaller than the second triangle!");
        }
    }
}
