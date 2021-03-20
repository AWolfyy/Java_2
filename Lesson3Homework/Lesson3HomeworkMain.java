package ru.geekbrains.homework.Lesson3Homework;

import java.util.*;

public class Lesson3HomeworkMain {
    public static void main(String[] args) {
        doTask1();
        System.out.println();

        doTask2();
    }

    public static void doTask2() {
        Phonebook pb = new Phonebook();
        pb.add("Волков", "8-911-111-1111");
        System.out.println(pb.get("Волков"));
        System.out.println(pb.get("Баранов"));
    }

    public static void doTask1() {
        String[] fruits = {
                "яблоко",
                "груша",
                "банан",
                "яблоко",
                "апельсин",
                "мандарин",
                "ананас",
                "банан",
                "киви",
                "манго",
                "яблоко",
                "банан",
                "мандарин",
                "банан"
        };

        System.out.println(Arrays.toString(fruits));
        System.out.println();

        Set<String> fruitsUnique = new HashSet<>(Arrays.asList(fruits));
        Iterator<String> iterator = fruitsUnique.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
        System.out.println();

        Map<String, Integer> fruitsRepetitive = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            if (fruitsRepetitive.containsKey(fruits[i])) {
                fruitsRepetitive.put(fruits[i], fruitsRepetitive.get(fruits[i]) + 1);
            } else {
                fruitsRepetitive.put(fruits[i], 1);
            }
        }

        System.out.println(fruitsRepetitive);
    }
}
