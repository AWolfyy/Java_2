package ru.geekbrains.homework.Lesson7Homework.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    AuthenticationService authenticationService;
    Set<ClientHandler> loggedClients;

    public ChatServer() {
        authenticationService = new AuthenticationService();
        loggedClients = new HashSet<>();
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Сервер готов.");

            while (true) {
                System.out.println("Ожидание подключения клиентов...");
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket, this);
            }
        } catch (IOException e) {
            throw new ChatServerException("Ошибка сервера", e);
        }
    }

    public void broadcast(String message) {
        /*Iterator<ClientHandler> iterator = loggedClients.iterator();
        while (iterator.hasNext()) {
            iterator.next().sendMassage(message);
            }*/

        loggedClients.forEach(clientHandler -> clientHandler.sendMassage(message));
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public void subscribe(ClientHandler clientHandler) {
        loggedClients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        loggedClients.remove(clientHandler);
    }

    public boolean isLoggedIn(String name) {
        /*
        Iterator<ClientHandler> iterator = loggedClients.iterator();
        while (iterator.hasNext()) {
            ClientHandler clientHandler = iterator.next();
            if (clientHandler.getName().equals(name)) {
                return true;
            }
        }
        return false;
        */

        return loggedClients.stream()
                .filter(clientHandler -> clientHandler.getName().equals(name))
                .findFirst()
                .isPresent();
    }
}
