package ru.geekbrains.homework.Lesson1Homework.Obstacle;

import ru.geekbrains.homework.Lesson1Homework.Participant.Participant;

public class Track implements Obstacle {
    private final int length;

    public Track(int length) {
        this.length = length;
    }


    @Override
    public boolean isPass(Participant participant) {
        if (participant instanceof Run) {
            return ((Run) participant).run(length);
        }
        System.out.println("Участник не может бегать...");
        return false;
    }
}
