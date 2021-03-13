package ru.geekbrains.homework.Lesson1Homework.Participant;

import ru.geekbrains.homework.Lesson1Homework.Obstacle.Jump;

public class Robot implements Participant, Jump {
    private final float maxHeight;
    private final String name;

    public Robot(int maxHeight, String name) {
        this.maxHeight = maxHeight;
        this.name = name;
    }

    @Override
    public boolean jump(float height) {
        System.out.println("Робот " + name + " пытается перепрыгнуть...");
        return maxHeight <= height;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}
