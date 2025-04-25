package com.client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.net.Socket;

public class ChatController {
    @FXML private TextField ipField;
    @FXML private TextField portField;
    @FXML private Button connectButton;
    @FXML private TextArea messageArea;
    @FXML private TextField inputField;
    @FXML private Button sendButton;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private Thread receiveThread;

    @FXML
    private void handleConnect() {
        String ip = ipField.getText();
        int port = Integer.parseInt(portField.getText());

        try {
            socket = new Socket(ip, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            messageArea.appendText("Đã kết nối đến server\n");

            // Bắt đầu thread để nhận tin nhắn
            receiveThread = new Thread(() -> {
                String msg;
                try {
                    while ((msg = in.readLine()) != null) {
                        String finalMsg = msg;
                        Platform.runLater(() -> messageArea.appendText(finalMsg + "\n"));
                    }
                } catch (IOException e) {
                    Platform.runLater(() -> messageArea.appendText("Đã mất kết nối tới server\n"));
                }
            });
            receiveThread.setDaemon(true);
            receiveThread.start();

            connectButton.setDisable(true);
        } catch (IOException e) {
            messageArea.appendText("Không thể kết nối tới server\n");
        }
    }

    @FXML
    private void handleSend() {
        String msg = inputField.getText().trim();
        if (!msg.isEmpty() && out != null) {
            out.println(msg);
            inputField.clear();
        }
    }
}
