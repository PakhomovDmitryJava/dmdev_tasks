package com.dmdev.hometask8.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

/**
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * Задача:
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */
public final class ChatUtil {
    private static final int COUNTER = 1000;

    public static ArrayList<Chat> deleteLessThan1000(ArrayList<Chat> chats) {
        ListIterator<Chat> listIterator = chats.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getUsersCount() < COUNTER) {
                listIterator.remove();
            }
        }
        return chats;
    }

    public static ArrayList<Chat> compareCountOfUsersAndNames(ArrayList<Chat> chats) {
        chats.sort(Comparator.comparing(Chat::getUsersCount).reversed().thenComparing(Chat::getName));
        return chats;
    }

    public static ArrayList<Chat> compareNames(ArrayList<Chat> chats) {
        chats.sort(Comparator.comparing(Chat::getName));
        return chats;
    }
}
