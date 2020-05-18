package colletc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesT {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties props = new Properties();
        props.load(new FileReader("D:\\Code\\Github\\demo-java\\java\\out\\production\\java\\setting.properties", StandardCharsets.UTF_8));
        System.out.println(props.get("auto_save_interval"));
    }
}