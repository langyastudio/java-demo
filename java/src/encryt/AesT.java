package encryt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * 对称加密
 */
public class AesT {
    public static void main(String[] args) throws Throwable  {
        String message = "Hello, world!";

        //128bit
        byte[] key = "1234567890abcdef".getBytes(StandardCharsets.UTF_8);

        byte[] encrptBytes = encrpt(key, message.getBytes(StandardCharsets.UTF_8));
        System.out.println((new BigInteger(1, encrptBytes)).toString(16));

        byte[] decrptBytes = decrpt(key, encrptBytes);
        System.out.println(new String(decrptBytes, StandardCharsets.UTF_8));
    }

    public static byte[] encrpt(byte[] key, byte[] input) throws Throwable {
        SecretKey secretKey = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(input);
    }

    public static byte[] decrpt(byte[] key, byte[] input) throws Throwable {
        SecretKey secretKey = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(input);
    }
}
