package Exercise2.Crypto;

import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class RsaEncryptor implements Encryptable {

    private final KeyPair keyPair;

    public RsaEncryptor() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        keyPair = generator.generateKeyPair();
    }

    @Override
    public String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
    }

    @Override
    public String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
    }
}
