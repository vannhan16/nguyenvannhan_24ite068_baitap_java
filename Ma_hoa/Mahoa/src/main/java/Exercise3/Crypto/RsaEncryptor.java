package Exercise3.Crypto;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class RsaEncryptor implements Encryptable {

    private final KeyPair keyPair;

    public RsaEncryptor() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        this.keyPair = generator.generateKeyPair();
    }

    @Override
    public String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encrypted = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    @Override
    public String decrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(input));
        return new String(decrypted);
    }
}
