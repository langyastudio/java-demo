package network.tcp;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * socket 编程-客户端
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);

        try {
            handle(socket.getInputStream(), socket.getOutputStream());
        }
        finally {
            socket.close();
        }
    }

    private static void handle(InputStream input, OutputStream output) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));

        System.out.println("server:" + reader.readLine());

        Scanner scanner = new Scanner(System.in);
        for (;;){
            String s = scanner.nextLine();
            writer.write(s);
            writer.newLine();
            writer.flush();

            String req = reader.readLine();
            System.out.println(req);

            if(req.equals("bye")){
                break;
            }
        }
    }
}
