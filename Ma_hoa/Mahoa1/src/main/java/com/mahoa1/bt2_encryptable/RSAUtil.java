package com.mahoa1.bt2_encryptable;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class RSAUtil implements Encryptable {
    private final KeyPair keyPair;

    public RSAUtil() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        keyPair = keyGen.generateKeyPair();
    }

    @Override
    public String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
    }

    @Override
    public String decrypt(String encryptedText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
    }
}
