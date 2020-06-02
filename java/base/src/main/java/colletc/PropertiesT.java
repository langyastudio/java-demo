package colletc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesT {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties props = new Properties();
        props.load(new FileReader("out/production/java/setting.properties", StandardCharsets.UTF_8));

        //读取classpath资源
        //props.load(PropertiesT.class.getResourceAsStream("../setting.properties"));

        System.out.println(props.getProperty("auto_save_interval"));

        //save
        props.setProperty("auto_save_interval", "120");
        props.store(new FileOutputStream("out/production/java/setting.properties"), "test");
    }
}