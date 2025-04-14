package Exercise3.Controller;
import Exercise2.Crypto.Encryptable;
import Exercise2.Crypto.RsaEncryptor;

import Exercise2.Crypto.AesEncryptor;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.concurrent.*;

public class ThreadedEncryptController {

    @FXML private ComboBox<String> algoBox;
    @FXML private TextArea inputText, encryptedText, decryptedText;
    @FXML private Label statusLabel;

    private Encryptable encryptor;

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    @FXML
    public void initialize() {
        algoBox.setValue("AES");
        setEncryptor("AES");
        algoBox.setOnAction(e -> setEncryptor(algoBox.getValue()));
    }

    private void setEncryptor(String algo) {
        try {
            if (algo.equals("AES")) encryptor = new AesEncryptor();
            else if (algo.equals("RSA")) encryptor = new RsaEncryptor();
            statusLabel.setText("Thuật toán: " + algo);
        } catch (Exception e) {
            statusLabel.setText("Lỗi chọn thuật toán");
            e.printStackTrace();
        }
    }

    @FXML
    public void handleEncrypt() {
        String plainText = inputText.getText();
        if (plainText.isEmpty()) {
            statusLabel.setText("Nhập văn bản trước khi mã hóa!");
            return;
        }

        executor.submit(() -> {
            try {
                String result = encryptor.encrypt(plainText);
                javafx.application.Platform.runLater(() -> {
                    encryptedText.setText(result);
                    statusLabel.setText("Đã mã hóa xong (luồng riêng).");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    public void handleDecrypt() {
        String encrypted = encryptedText.getText();
        if (encrypted.isEmpty()) {
            statusLabel.setText("Chưa có dữ liệu để giải mã!");
            return;
        }

        executor.submit(() -> {
            try {
                String result = encryptor.decrypt(encrypted);
                javafx.application.Platform.runLater(() -> {
                    decryptedText.setText(result);
                    statusLabel.setText("Đã giải mã xong (luồng riêng).");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
