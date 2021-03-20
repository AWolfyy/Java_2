package ru.geekbrains.homework.Lesson3Homework;

import java.util.*;

public class Phonebook {
    private final Map<String, Set<String>> book;

    public Phonebook() {
        book = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        if (book.containsKey(surname)) {
            book.get(surname).add(phoneNumber);
        } else {
            Set<String> numbers = new HashSet<>();
            numbers.add(phoneNumber);
            book.put(surname, numbers);
        }
    }

    public Set<String> get(String surname) {
        return book.getOrDefault(surname, Collections.emptySet());

        /*
        if (book.containsKey(surname)){
            return book.get(surname);
        } else {
            return Collections.emptySet();
        }

         */
    }
}
