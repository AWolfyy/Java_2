package ru.geekbrains.homework.Lesson7Homework.Server;

public class ChatServerException extends RuntimeException{
    public ChatServerException(String message) {
        super(message);
    }

    public ChatServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
