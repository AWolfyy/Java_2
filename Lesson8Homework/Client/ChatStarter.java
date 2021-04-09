package ru.geekbrains.homework.Lesson8Homework.Client;

public class ChatStarter {
    public static void run(String host, int port) {
        new Chat(host, port);
    }

    public static void run() {
        run("localhost", 8080);
    }
}
