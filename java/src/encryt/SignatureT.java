package encryt;

import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * 签名 - 本质上是原始消息的哈希进行签名(RSA签名)
 */
public class SignatureT {
    public static void main(String[] args) throws Throwable {
        //生成公钥 私钥
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");

        //使用1024bit的RSA加密时，明文长度不能超过117字节
        kpGen.initialize(1024);

        KeyPair    keyPair = kpGen.generateKeyPair();
        PrivateKey sk = keyPair.getPrivate();
        PublicKey  pk = keyPair.getPublic();

        String msg = "i love you";

        //私钥加密
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(sk);
        signature.update(msg.getBytes(StandardCharsets.UTF_8));
        byte[] sign = signature.sign();

        //公钥验证
        Signature v = Signature.getInstance("SHA1withRSA");
        v.initVerify(pk);
        v.update(msg.getBytes(StandardCharsets.UTF_8));
        System.out.println(v.verify(sign));
    }
}
