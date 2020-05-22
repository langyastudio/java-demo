package encryt;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * 哈希
 */
public class HashT {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        //MessageDigest messageDigest = MessageDigest.getInstance("RipeMD160");

        //or SHA-1
        MessageDigest messageDigest = MessageDigest.getInstance("Md5");

        messageDigest.update("hello".getBytes(StandardCharsets.UTF_8));
        messageDigest.update("langyastudio".getBytes(StandardCharsets.UTF_8));

        byte [] hash = messageDigest.digest();
        System.out.println( (new BigInteger(1, hash)).toString(16));
    }
}
