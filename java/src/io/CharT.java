package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class CharT {
    public static void main(String[] args)throws IOException {
        try(Reader reader = new FileReader("out/production/java/setting.properties", StandardCharsets.UTF_8))
        {
            char []cbuf = new char[100];
            while (-1 != reader.read(cbuf)){
                System.out.println(cbuf);
            }
        }
    }
}
