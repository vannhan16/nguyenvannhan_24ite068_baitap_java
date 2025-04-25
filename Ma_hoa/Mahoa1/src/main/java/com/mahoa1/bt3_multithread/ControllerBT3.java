package com.mahoa1.bt3_multithread;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.security.MessageDigest;

public class ControllerBT3 {
    @FXML private TextField inputField;
    @FXML private TextArea resultArea;

    public void processData() {
        String input = inputField.getText();

        Thread encryptThread = new Thread(() -> {
            String md5 = hash(input, "MD5");
            Platform.runLater(() -> resultArea.appendText("Mã hóa MD5: " + md5 + "\n"));
        });

        Thread decryptThread = new Thread(() -> {
            // Không giải mã được MD5, mô phỏng giả lập
            Platform.runLater(() -> resultArea.appendText("Giải mã (giả lập): Không khả thi với MD5\n"));
        });

        resultArea.clear();
        encryptThread.start();
        decryptThread.start();
    }

    private String hash(String input, String algo) {
        try {
            MessageDigest md = MessageDigest.getInstance(algo);
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes)
                sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return "Lỗi: " + e.getMessage();
        }
    }
}
