package ru.geekbrains.homework.Lesson7Homework.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public ChatClient() {
        try {
            Socket socket = new Socket("localhost", 8080);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while(true) {
                    try {
                        outputStream.writeUTF(scanner.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            })
                    .start();

            while (true) {
                System.out.println(inputStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
