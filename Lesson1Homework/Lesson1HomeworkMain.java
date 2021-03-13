package ru.geekbrains.homework.Lesson1Homework;

import ru.geekbrains.homework.Lesson1Homework.Obstacle.Course;
import ru.geekbrains.homework.Lesson1Homework.Participant.*;
import ru.geekbrains.homework.Lesson1Homework.Obstacle.Track;
import ru.geekbrains.homework.Lesson1Homework.Obstacle.Wall;

public class Lesson1HomeworkMain {
    public static void main(String[] args) {
        Team team = new Team("Бригада",
                new Human(2, 500, "Алекс"),
                new Cat(2, 50, "Бабочка"),
                new Robot(20, "Д23 в1.3"),
                new Human(3, 1000, "Маша")
        );

        Course course = new Course(
                new Wall(2),
                new Track(500)
        );

        team.showParticipant();

        course.doIt(team);
    }
}
