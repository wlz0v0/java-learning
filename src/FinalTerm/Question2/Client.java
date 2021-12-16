package FinalTerm.Question2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    /**
     * 端口号
     */
    public final static int PORT = 4396;

    public static void main(String[] args) {
        // 使用try-with-resource自动关闭流
        try (var socket = new Socket("127.0.0.1", PORT);
             var dos = new DataOutputStream(socket.getOutputStream())) {
            // 把数据传送给服务器
            String str = "Hello world!\n";
            dos.write(str.getBytes());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
