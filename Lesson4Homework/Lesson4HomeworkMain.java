package ru.geekbrains.homework.Lesson4Homework;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lesson4HomeworkMain {
    public static void main(String[] args) {
        doTask1();

        doTask2();

        doTask3();

        doTask4();
    }

    static void doTask4() {
        System.out.println(findAllChars("ccch", 'c').get());
        System.out.println(findAllChars("ccch", 'c'));
        System.out.println(findAllChars("ccchh", 'g'));
    }

    static void doTask3() {
        Supplier<Integer> supplier = () -> 2;
        System.out.println(doubleUp(24, supplier));
        System.out.println();
    }

    static void doTask2() {
        Set<String> set = new HashSet<>(Arrays.asList("банан", "вишня", "клубника", "мандарин", "банан"));
        forItem(set, string -> System.out.println(string));
        System.out.println();
    }

    static void doTask1() {
        List<Integer> val = new ArrayList<>(Arrays.asList(0, 9, 2));
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            val.add(rnd.nextInt(100));
        }
        val.add(3);

        val.forEach(integer -> System.out.println(integer));
        System.out.println();
    }

    static Optional<String> findAllChars(String target, char toFind) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == toFind) {
                sb.append(toFind);
            }
        }
        if (sb.length() > 0) {
            return Optional.of(sb.toString());
        }
        return Optional.empty();
    }

    static int doubleUp(int i, Supplier<Integer> supplier) {
        return i * supplier.get();
    }

    static void forItem(Set<String> set, Consumer<String> consumer) {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            consumer.accept(str);
        }
    }
}
