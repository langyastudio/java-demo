package json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * jackson
 */
public class JsonT {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = JsonT.class.getResourceAsStream("../book.json");
        ObjectMapper objectMapper = new ObjectMapper();

        // 反序列化时忽略不存在的JavaBean属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        BookT book = objectMapper.readValue(inputStream, BookT.class);
        System.out.println(book.author);
    }
}

