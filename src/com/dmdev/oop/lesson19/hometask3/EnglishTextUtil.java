package com.dmdev.oop.lesson19.hometask3;

import java.util.*;

/**
 * Задан текст на английском языке.
 * Выделить все различные слова.
 * Для каждого слова подсчитать частоту его встречаемости.
 * Слова, отличающиеся регистром букв, считать различными.
 */
public final class EnglishTextUtil {
    private final String text;

    public EnglishTextUtil(String text) {
        this.text = text;
    }

    public static List<String> textAsList(String string)   {
        String s = string.replaceAll("[\\p{Punct}\r\n]", " ").replaceAll("  ", " ");
        return Arrays.asList(s.split(" "));
    }

    public static LinkedHashSet<String> uniqueWords(List<String> words) {
        return new LinkedHashSet<>(words);
    }

    public static void wordsCounter(List<String> words) {
        for (String word : uniqueWords(words)) {
            System.out.println(word + " - " + Collections.frequency(words, word) + " times");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnglishTextUtil that = (EnglishTextUtil) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "EnglishTextUtil{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }
}
