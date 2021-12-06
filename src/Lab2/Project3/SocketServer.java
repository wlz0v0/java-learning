package Lab2.Project3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/02
 *     desc   :
 *     version:
 * </pre>
 */
public class SocketServer {
    public final static int round = 20;
    public final static int PORT = 1778;

    public static void main(String[] args) {
        try (var ss = new ServerSocket(PORT);
             var socket = ss.accept();
             var objectInputStream = new ObjectInputStream(socket.getInputStream())) {
            objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
