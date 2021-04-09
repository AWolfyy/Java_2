package ru.geekbrains.homework.Lesson8Homework.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatCommunication {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public ChatCommunication(String host, int port) {
        try {
            Socket socket = new Socket(host, port);

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException("Ошибка подключения.", e);
        }
    }

    public void transmit(String data) {
        try {
            outputStream.writeUTF(data);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка отправки.", e);
        }
    }

    public String receive() {
        try {
            return inputStream.readUTF();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка получения.", e);
        }
    }
}
