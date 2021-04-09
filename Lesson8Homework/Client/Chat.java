package ru.geekbrains.homework.Lesson8Homework.Client;

import ru.geekbrains.homework.Lesson8Homework.Client.GUI.API.Receiver;
import ru.geekbrains.homework.Lesson8Homework.Client.GUI.API.Sender;
import ru.geekbrains.homework.Lesson8Homework.Client.GUI.ChatFrame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Chat {
    private final ChatFrame chatFrame;
    private final ChatCommunication chatCommunication;

    public Chat(String host, int port) {
        chatCommunication = new ChatCommunication(host, port);
        chatFrame = new ChatFrame(data -> chatCommunication.transmit(data));

        new Thread(() -> {
            Receiver receiver = chatFrame.getReceiver();
            while (true) {
                String message = chatCommunication.receive();
                if (!message.isBlank()) {
                    receiver.receive(message);
                }
            }
        })
                .start();

    }
}
