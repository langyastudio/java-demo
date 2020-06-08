package network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * @author hk
 */
public class HttpT {
    static HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) {
        try{
            URI  uri = new URI("https://www.sina.com.cn/");
            HttpRequest httpRequest = HttpRequest.newBuilder(uri)
                    .header("User-Agent", "Java HttpClient")
                    .header("Accept", "*/*")
                    .timeout(Duration.ofSeconds(30))
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            Map<String, List<String>> headers = response.headers().map();
            for(String key : headers.keySet()){
                System.out.println(headers.get(key).get(0));
            }

            System.out.println(response.body());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
