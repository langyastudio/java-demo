package network.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * socket 编程
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("server is running...");

        for (; ; ) {
            Socket socket = ss.accept();
            Thread t      = new ServerHandler(socket);
            t.start();
        }
    }
}

class ServerHandler extends Thread {
    private final Socket ss;

    public ServerHandler(Socket ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        try {
            InputStream  inputStream  = this.ss.getInputStream();
            OutputStream outputStream = this.ss.getOutputStream();

            handle(inputStream, outputStream);
        } catch (IOException e) {
            //关闭socket连接
            try {
                this.ss.close();
            } catch (IOException ioe) {
            }

            e.printStackTrace();
            System.out.println("client disconnected.");
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));

        writer.write("hello\n"); writer.flush();
        for (; ; ) {
            String s = reader.readLine();
            System.out.println(s);

            //退出
            if (s.equals("bye")) {
                writer.write("bye\n");
                writer.flush();
                break;
            }

            writer.write("ok: " + s + "\n");
            writer.flush();
        }
    }
}
