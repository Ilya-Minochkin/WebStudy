package bs;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;


public class Crypto {

    private String text = "QWERTY";
    private String alias = "A";
    private final int keyByteSize = 256;
    private SecureRandom secureRandom;
    private Cipher cipher;
    private SecretKey secretKey;
    private KeyGenerator keyGenerator;
    private KeyStore keyStore;
    private KeyStore.SecretKeyEntry secretKeyEntry;
    private KeyStore.ProtectionParameter protectionParameter;
    private byte[] rnd = new byte[16];
    private char[] pwd = "password".toCharArray();
    private InputStream inputStream;
    private OutputStream outputStream;


    {
        try {
            secureRandom = SecureRandom.getInstanceStrong();
            secureRandom.nextBytes(rnd);
            cipher = Cipher.getInstance("AES");
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(keyByteSize, secureRandom);
            secretKey = keyGenerator.generateKey();
            keyStore = KeyStore.getInstance("JCEKS");
            keyStore.load(null, pwd);
            protectionParameter = new KeyStore.PasswordProtection(pwd);
            outputStream = new FileOutputStream("KeyStore.ks");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     public byte[] encryptData(String plaintext) throws Exception {
        SecretKey secretKey;

        if (!keyStore.isKeyEntry(alias)) {
            secretKeyEntry = new KeyStore.SecretKeyEntry(this.secretKey);
            keyStore.setEntry(alias, secretKeyEntry, protectionParameter);
            keyStore.store(outputStream, pwd);
            cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
        }
        else {
            secretKey = (SecretKey) keyStore.getKey(alias, pwd);
            inputStream = new FileInputStream("KeyStore.ks");
            keyStore.load(inputStream, pwd);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        }
        return cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
    }

     public String decryptData(byte[] plaintTextByteArray) throws Exception {
        SecretKey secretKey = (SecretKey) keyStore.getKey(alias, pwd);

        inputStream = new FileInputStream("KeyStore.ks");
        keyStore.load(inputStream, pwd);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedText = cipher.doFinal(plaintTextByteArray);
        return new String(decryptedText, "UTF-8");
    }
}
