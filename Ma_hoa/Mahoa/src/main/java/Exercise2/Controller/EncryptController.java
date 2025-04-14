package Exercise2.Controller;

import Exercise2.Crypto.*;
import Exercise2.Crypto.AesEncryptor;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EncryptController {

    @FXML private ComboBox<String> algoBox;
    @FXML private TextArea inputText, outputText;
    @FXML private Label statusLabel;

    private Encryptable encryptor;

    @FXML
    public void initialize() {
        algoBox.setValue("AES"); // mặc định
        setEncryptor("AES");

        algoBox.setOnAction(e -> setEncryptor(algoBox.getValue()));
    }

    private void setEncryptor(String algo) {
        try {
            if (algo.equals("AES")) {
                encryptor = new AesEncryptor();
            } else if (algo.equals("RSA")) {
                encryptor = new RsaEncryptor();
            }
            statusLabel.setText("Thuật toán được chọn: " + algo);
        } catch (Exception e) {
            statusLabel.setText("Lỗi khi chọn thuật toán.");
            e.printStackTrace();
        }
    }

    @FXML
    public void handleEncrypt() {
        try {
            String plain = inputText.getText();
            if (plain.isEmpty()) {
                statusLabel.setText("Vui lòng nhập văn bản!");
                return;
            }
            String result = encryptor.encrypt(plain);
            outputText.setText(result);
            statusLabel.setText("Đã mã hóa!");
        } catch (Exception e) {
            statusLabel.setText("Lỗi mã hóa.");
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDecrypt() {
        try {
            String cipher = outputText.getText();
            if (cipher.isEmpty()) {
                statusLabel.setText("Vui lòng nhập văn bản mã hóa!");
                return;
            }
            String result = encryptor.decrypt(cipher);
            inputText.setText(result);
            statusLabel.setText("Đã giải mã!");
        } catch (Exception e) {
            statusLabel.setText("Lỗi giải mã.");
            e.printStackTrace();
        }
    }
}
