package Exercise1.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Exercise1.Util.HashUtil;
import java.util.HashMap;

public class AuthController {
    @FXML
    private TextField signupUsername, loginUsername;
    @FXML
    private PasswordField signupPassword, loginPassword;
    @FXML
    private Label signupMessage, loginMessage;

    private HashMap<String, String> userDatabase = new HashMap<>();
    public void handleSignup(){
        String username = signupUsername.getText();
        String password = signupPassword.getText();
        if (userDatabase.containsKey(username)){
            signupMessage.setText("Tên đã tồn tại!");
        } else {
            String hashed = HashUtil.hashSHA256(password);
            userDatabase.put(username, hashed);
            signupMessage.setText("Đăng kí thàng công!");
        }
    }
    public void handleLogin(){
        String username = loginUsername.getText();
        String password = loginPassword.getText();
        String hashed = HashUtil.hashSHA256(password);
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(hashed)){
            loginMessage.setText("Đăng nhập thành công!");
        } else {
            loginMessage.setText("Sai ten hoặc mật khẩu!");
        }
    }
}
