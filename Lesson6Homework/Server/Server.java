package ru.geekbrains.homework.Lesson6Homework.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Сервер готов...");
            System.out.println("Ожидание подключения клиента...");

            Socket accept = serverSocket.accept();

            System.out.println("Соединение установлено.");

            DataInputStream inputStream = new DataInputStream(accept.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(accept.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            new Thread(() -> {
                while (true) {
                    try {
                        outputStream.writeUTF(scanner.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            while (true) {
                System.out.println(inputStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
