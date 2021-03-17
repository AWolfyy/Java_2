package ru.geekbrains.homework.Lesson2Homework;

public class Lesson2HomeworkMain {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "0", "1", "2"},
                {"3", "4", "5", "o"}
        };

        System.out.println(sumUp(arr));
    }

    public static int sumUp(String[][] arr) {
        if (arr.length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4 на 4");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4 на 4");
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException ex) {
                    String msg = String.format("Массив должен содержать только цифры, проверьте ячейку [%d][%d]", i, j);
                    throw new MyArrayDataException(msg, ex);
                }
            }
        }
        return sum;
    }
}
