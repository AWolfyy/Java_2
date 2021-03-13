package ru.geekbrains.homework.Lesson1Homework.Participant;

import ru.geekbrains.homework.Lesson1Homework.Obstacle.Jump;
import ru.geekbrains.homework.Lesson1Homework.Obstacle.Run;

public class Cat implements Participant, Run, Jump {
    private final float maxHeight;
    private final int maxLength;
    private final String name;

    public Cat(float maxHeight, int maxLength, String name) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.name = name;
    }


    @Override
    public boolean run(float length) {
        System.out.println("Кот " + name + " пытается пробежать...");
        return maxLength <= length;
    }

    @Override
    public boolean jump(float height) {
        System.out.println("Кот " + name + " пытается перепрыгнуть...");
        return maxHeight <= height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
