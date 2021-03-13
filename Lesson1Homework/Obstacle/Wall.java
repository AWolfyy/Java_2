package ru.geekbrains.homework.Lesson1Homework.Obstacle;

import ru.geekbrains.homework.Lesson1Homework.Participant.Participant;

public class Wall implements Obstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean isPass(Participant participant) {
        if (participant instanceof Jump) {
            return ((Jump) participant).jump(height);
        }
        System.out.println("Участник не может прыгать...");
        return false;
    }
}
