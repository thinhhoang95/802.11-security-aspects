package hu.pe.thinhhoang.algorithms;

/**
 * Created by hoang on 09/04/16.
 */
public interface Algorithm {
    public String getCipherText(String plainText); // Get ciphertext after encryption
    public String getKey(); // Get key after encryption
    public String getPlainText(String cipherText, String key); // Decrypt
}
