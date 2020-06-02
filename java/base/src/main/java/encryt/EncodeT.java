package encryt;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * 编码
 */
public class EncodeT {
    public static void main(String[] args) {
        //url encode
        String urlEncode = URLEncoder.encode("中国，不错yes", StandardCharsets.UTF_8);
        System.out.println(urlEncode);

        String urlDecode = URLDecoder.decode(urlEncode, StandardCharsets.UTF_8);
        System.out.println(urlDecode);

        //byte encode
        byte [] input = new byte[] { (byte)0xe4, (byte)0xb8, (byte)0xad };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);

        byte[] output = Base64.getDecoder().decode(b64encoded);
        System.out.println(Arrays.toString(output));
    }
}
