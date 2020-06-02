package io;

import java.io.File;
import java.io.IOException;

public class FileT {
    public static void main(String[] args) throws IOException {
        File file = new File("out/production/java/setting.properties");

        //path
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());

        //"\"或"/"
        System.out.println(File.separator);

        //file size
        System.out.println("is file:" + file.isFile());
        if(file.isFile())
        {
            System.out.println("file size:" + file.length());
        }

        //list files
        File curDir = new File("./out/production/java");
        File [] files = curDir.listFiles();
        if(null != files)
        {
            for (File f:files)
            {
                System.out.println(f);
            }
        }
    }
}
