package encryt;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 基于密钥的哈希
 */
public class HmacT {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        //1.0 生成Key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMd5");
        SecretKey secretKey =   keyGenerator.generateKey();

        //打印key
        byte[] skey = secretKey.getEncoded();
        System.out.println(new BigInteger(1, skey).toString(16));

        //2.0 计算hash
        Mac mac = Mac.getInstance("HmacMd5");

        //指定key
        mac.init(secretKey);
        mac.update("HelloWorld".getBytes(StandardCharsets.UTF_8));

        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1, result).toString(16));

        //3.0 恢复
        SecretKey secretKey2 = new SecretKeySpec(skey, "HmacMD5");
        byte[] skey2 = secretKey2.getEncoded();
        System.out.println(new BigInteger(1, skey2).toString(16));
    }
}
