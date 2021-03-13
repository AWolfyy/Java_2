package ru.geekbrains.homework.Lesson1Homework.Obstacle;

import ru.geekbrains.homework.Lesson1Homework.Participant.Team;

public class Course {
    private final Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < team.getParticipants().length; j++) {
                System.out.println(obstacles[i].isPass(team.getParticipants()[j]));
            }
        }
    }
}
