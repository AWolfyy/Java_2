package ru.geekbrains.homework.Lesson8Homework.Client.GUI;

import ru.geekbrains.homework.Lesson8Homework.Client.GUI.API.Receiver;
import ru.geekbrains.homework.Lesson8Homework.Client.GUI.API.Sender;

import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JFrame {
    private final JTextArea chatArea;

    public ChatFrame(Sender sender) {
        setTitle("Чат v1.0");
        setBounds(600, 200, 700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        top.add(chatArea, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        JTextField inputField = new JTextField();
        bottom.add(inputField, BorderLayout.CENTER);
        JButton submitButton = new JButton("Отправить");
        submitButton.addActionListener(new SubmitButtonListener(inputField, sender));
        bottom.add(submitButton, BorderLayout.EAST);

        add(top, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    public Receiver getReceiver() {
        return (message) -> {
            if (!message.isBlank()) {
                chatArea.append(message);
                chatArea.append("\n");
            }
        };
    }
}
