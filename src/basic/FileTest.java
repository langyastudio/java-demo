package basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("test.txt");

        if (!file.exists()) {
            System.out.println("未在指定目录下找到 test.txt 文件，正在创建...");

            try {
                boolean bCreated = file.createNewFile();
                if (bCreated) {
                    System.out.println("创建成功");
                }

                if (file.canWrite()) {
                    //写入一些数据
                    String           content       = "你见过洛杉矶凌晨4点的样子吗？";
                    byte             contentByte[] = content.getBytes();
                    FileOutputStream out           = new FileOutputStream(file);

                    out.write(contentByte);
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            if (file.isFile() && file.canRead()) {
                System.out.println("文件可读！正在读取文件....");

                String  fileName = file.getName();
                String  filePath = file.getAbsolutePath();
                boolean hidden   = file.isHidden();
                long    len      = file.length();

                long             modifyTime = file.lastModified();
                SimpleDateFormat sdf        = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String           time       = sdf.format(new Date(modifyTime));

                System.out.println("文件名：" + fileName);
                System.out.println("文件的绝对路径：" + filePath);
                System.out.println("文件是否隐藏：" + hidden);
                System.out.println("文件字节数：" + len);
                System.out.println("文件最后的修改时间：" + time);

                file.delete();
            }
        }
    }
}
