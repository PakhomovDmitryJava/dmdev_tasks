package com.dmdev.hometask10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * 1. Средняя оценка студентов этого курса, количество оценок у которых больше 3-х;
 * 2. Список студентов данного курса, но только с полями Имя и Фамилия. Список должен быть отсортированы по этим двум полям;
 * 3. Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */
public final class StudentUtil {

    public static Map<Integer, List<Student>> sortStudentsByCoursesAndFullNames(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName))
                .collect(Collectors.groupingBy(Student::getCourse));
    }

    public static Map<Integer, Double> getAllAverageScore(List<Student> students) {
        return sortStudentsByCoursesAndFullNames(students)
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        integerListEntry -> integerListEntry.getValue()
                                .stream()
                                .collect(Collectors.averagingDouble(Student::getAverageScore)), (a, b) -> b));
    }

    public static Map<Integer, List<Student>> getSortedListWithFullNames(List<Student> students) {
        return sortStudentsByCoursesAndFullNames(students)
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        v -> v.getValue().stream()
                                .map(student -> new Student(student.getFirstName(), student.getLastName()))
                                .collect(Collectors.toList())));
    }
        // Объект с двумя полями:
        // * - Отсортированный список студентов с пункта 2
        // * - Средняя оценка этих студентов
//    public static Map<Integer, StudentsAverageScore> getListWithFistAndLastNames(List<Student> students) {
//        Map<Integer, StudentsAverageScore> result = sortStudentsByCoursesAndFullNames(students)
//                .entrySet()
//                .stream()
//                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().stream()
//                        .map(newObject -> new StudentsAverageScore(getSortedListWithFullNames(students)
//                                .entrySet()
//                                .stream()
//                                .map(courseAverage->courseAverage.getValue()))))
//
//        return result;
//    }

    public static ArrayList<Integer> getListOfRandomScores() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < threadLocalRandom.nextInt(1, 10); i++) {
            list.add(ThreadLocalRandom.current().nextInt(1, 11));

        }
        return list;
    }

}
