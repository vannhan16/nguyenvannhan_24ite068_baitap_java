package Exercise2.Crypto;

public interface Encryptable {
    String encrypt(String plainText) throws Exception;
    String decrypt(String cipherText) throws Exception;
}
