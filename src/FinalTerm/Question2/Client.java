package FinalTerm.Question2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/15
 *     desc   :
 *     version:
 * </pre>
 */
public class Client {
    public final static int PORT = 4396;

    public static void main(String[] args) {
        try (var socket = new Socket("127.0.0.1", PORT);
             var dos = new DataOutputStream(socket.getOutputStream())) {
            String str = "Hello world!\n";
            dos.write(str.getBytes());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
