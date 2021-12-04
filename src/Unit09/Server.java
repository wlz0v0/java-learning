package Unit09;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/01
 *     desc   :
 *     version:
 * </pre>
 */
public class Server {
    public static final int PORT = 6666;

    public static void main(String[] args) {
        try {
            var ss = new ServerSocket(PORT);
            var socket = ss.accept();
            System.out.println("Connected from: " + socket.getInetAddress() + ":" + socket.getPort());
            var dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Data: " + dataInputStream.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
