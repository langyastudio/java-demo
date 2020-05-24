package encryt;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 非对称加密
 */
public class RSAT {
    //私钥
    private PrivateKey sk;
    //公钥
    private PublicKey  pk;

    public static void main(String[] args) throws Throwable{
       String strMsg = "iloveyouiloveyou";
       System.out.println(strMsg);

       RSAT rsa = new RSAT();

       byte [] encode = rsa.encode(strMsg.getBytes(StandardCharsets.UTF_8));
       System.out.println(new BigInteger(1, encode).toString(16));

       byte [] decode = rsa.decode(encode);
       System.out.println(new String(decode));
    }

    public RSAT() throws Throwable
    {
        //生成公钥 私钥
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");

        //使用1024bit的RSA加密时，明文长度不能超过117字节
        kpGen.initialize(1024);

        KeyPair keyPair = kpGen.generateKeyPair();
        this.sk = keyPair.getPrivate();
        this.pk = keyPair.getPublic();
    }

    public byte [] encode(byte []input) throws Throwable
    {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.pk);
        return cipher.doFinal(input);
    }

    public byte [] decode(byte []input) throws Throwable
    {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.sk);
        return cipher.doFinal(input);
    }

    /**
     * 根据byte[]获取PublicKey
     */
    public PublicKey byteToPK(byte []input) throws Throwable
    {
        X509EncodedKeySpec pkSpeck = new X509EncodedKeySpec(input);
        return KeyFactory.getInstance("RSA").generatePublic(pkSpeck);
    }

    /**
     * 根据byte[]获取PrivateKey
     */
    public PrivateKey byteToSK(byte []input) throws Throwable
    {
        PKCS8EncodedKeySpec skSpeck = new PKCS8EncodedKeySpec(input);
        return KeyFactory.getInstance("RSA").generatePrivate(skSpeck);
    }

    public byte [] GetSK()
    {
        return this.sk.getEncoded();
    }

    public byte [] GetPK()
    {
        return this.pk.getEncoded();
    }
}
