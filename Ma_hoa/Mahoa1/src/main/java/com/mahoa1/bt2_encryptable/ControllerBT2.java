package com.mahoa1.bt2_encryptable;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerBT2 {
    @FXML private TextField inputField;
    @FXML private TextArea resultArea;

    private AESUtil aes;
    private RSAUtil rsa;

    public ControllerBT2() {
        try {
            aes = new AESUtil();
            rsa = new RSAUtil();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void encryptAES() {
        try {
            resultArea.setText("AES: " + aes.encrypt(inputField.getText()));
        } catch (Exception e) {
            resultArea.setText("Lỗi: " + e.getMessage());
        }
    }

    public void decryptAES() {
        try {
            resultArea.setText("Giải mã AES: " + aes.decrypt(inputField.getText()));
        } catch (Exception e) {
            resultArea.setText("Lỗi: " + e.getMessage());
        }
    }

    public void encryptRSA() {
        try {
            resultArea.setText("RSA: " + rsa.encrypt(inputField.getText()));
        } catch (Exception e) {
            resultArea.setText("Lỗi: " + e.getMessage());
        }
    }

    public void decryptRSA() {
        try {
            resultArea.setText("Giải mã RSA: " + rsa.decrypt(inputField.getText()));
        } catch (Exception e) {
            resultArea.setText("Lỗi: " + e.getMessage());
        }
    }
}
