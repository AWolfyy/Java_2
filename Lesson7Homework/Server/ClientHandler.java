package ru.geekbrains.homework.Lesson7Homework.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

public class ClientHandler {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private ChatServer chatServer;
    private String name;

    public ClientHandler(Socket socket, ChatServer chatServer) {
        this.socket = socket;
        this.chatServer = chatServer;
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new ChatServerException("Ошибка подключения клиента.", e);
        }

        doAuthentication();
        new Thread(() -> listen()).start();
    }

    public void listen() {
        receiveMessage();
    }

    private void doAuthentication() {
        sendMassage("Добро пожаловать в чат!");
        while (true) {
            try {
                sendMassage("Введите строку аутентификации по схеме: -auth your_login your_password");

                String message = inputStream.readUTF();

                if (message.startsWith("-auth")) {
                    String[] credentialsStruct = message.split("\\s");
                    String login = credentialsStruct[1];
                    String password = credentialsStruct[2];

                    Optional<AuthenticationService.Entry> mayBeCredentials = chatServer.getAuthenticationService()
                            .findEntryByCredentials(login, password);

                    if (mayBeCredentials.isPresent()) {
                        AuthenticationService.Entry credentials = mayBeCredentials.get();
                        if (!chatServer.isLoggedIn(credentials.getName())) {
                            name = credentials.getName();
                            chatServer.broadcast(String.format("Пользователь [%s] вошел в чат", name));
                            chatServer.subscribe(this);
                            return;
                        } else {
                            sendMassage(String.format("Пользователь с именем %s уже залогинен.", credentials.getName()));
                        }
                    } else {
                        sendMassage("Неверный логин или пароль.");
                    }
                } else {
                    sendMassage("Неверная строка аутентификации.");
                }
            } catch (IOException e) {
                throw new ChatServerException("Ошибка аутентификации клиента.", e);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void receiveMessage() {
        while (true) {
            try {
                String message = inputStream.readUTF();
                if (message.startsWith("-quit")) {
                    chatServer.unsubscribe(this);
                } else chatServer.broadcast(String.format("[%s]: %s", name, message));
            } catch (IOException e) {
                throw new ChatServerException("Ошибка получения сообщения.", e);
            }
        }
    }

    public void sendMassage(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            throw new ChatServerException("Ошибка отправки сообщения.", e);
        }
    }
}
