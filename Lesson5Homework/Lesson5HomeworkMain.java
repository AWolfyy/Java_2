package ru.geekbrains.homework.Lesson5Homework;

import java.util.Arrays;

public class Lesson5HomeworkMain {
    public static void main(String[] args) {
        doWithoutThreads();

        doWithThreads();
    }

    public static void doWithoutThreads() {
        final int SIZE = 10000000;
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1);

        long start = System.currentTimeMillis();

        calc(arr);

        long time = System.currentTimeMillis() - start;
        System.out.println("Время выполнения doWithoutThreads(): " + time);
    }

    public static void doWithThreads() {
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        Arrays.fill(arr, 1);

        long start = System.currentTimeMillis();

        //System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника,
        //массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread t1 = new Thread(() -> calc(arr1));
        Thread t2 = new Thread(() -> calc(arr2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        long time = System.currentTimeMillis() - start;
        System.out.println("Время выполнения doWithThreads(): " + time);
    }

    public static void calc(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (float)i / 5) *
                    Math.cos(0.2f + (float)i / 5) * Math.cos(0.4f + (float)i / 2));
        }
    }
}
