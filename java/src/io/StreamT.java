package io;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamT {
    public static void main(String[] args) throws IOException {
        try(InputStream input = new FileInputStream("out/production/java/setting.properties")){

        }// 编译器在此自动为我们写入finally并调用close()

        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try(InputStream inputStream = new ByteArrayInputStream(data)){
            System.out.println( readAsString(inputStream) );
        }
    }

    public static String readAsString(InputStream inputStream) throws IOException {
        int           n;
        StringBuilder sb = new StringBuilder();
        while ((n = inputStream.read()) != -1) {
            sb.append((char) n);
        }

        return sb.toString();
    }
}
