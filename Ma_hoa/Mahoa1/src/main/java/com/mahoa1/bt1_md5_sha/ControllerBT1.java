package com.mahoa1.bt1_md5_sha;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.security.MessageDigest;

public class ControllerBT1 {
    @FXML private TextField inputField;
    @FXML private TextArea resultArea;

    public void encryptMD5() {
        String input = inputField.getText();
        resultArea.setText("MD5: " + hashString(input, "MD5"));
    }

    public void encryptSHA() {
        String input = inputField.getText();
        resultArea.setText("SHA-256: " + hashString(input, "SHA-256"));
    }

    private String hashString(String input, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] bytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes)
                sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return "Lỗi: " + e.getMessage();
        }
    }
}
