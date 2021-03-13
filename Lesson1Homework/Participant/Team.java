package ru.geekbrains.homework.Lesson1Homework.Participant;

public class Team {
    private final String name;
    private final Participant[] participants;

    public Team(String name, Participant... participants) {
        this.name = name;
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void showParticipant() {
        System.out.println("Участники команды " + name + ": ");
        for (int i = 0; i <participants.length ; i++) {
            System.out.println(participants[i]);
        }
    }
}
