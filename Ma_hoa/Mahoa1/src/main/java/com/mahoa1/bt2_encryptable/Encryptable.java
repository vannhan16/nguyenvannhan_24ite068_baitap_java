package com.mahoa1.bt2_encryptable;

public interface Encryptable {
    String encrypt(String plainText) throws Exception;
    String decrypt(String encryptedText) throws Exception;
}
