package Unit09;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/01
 *     desc   :
 *     version:
 * </pre>
 */
public class Client {
    public static final int PORT = 6666;

    public static void main(String[] args) {
        try {
            try (var socket = new Socket("127.0.0.1", PORT)) {
                try (var dataOutputStream = new DataOutputStream(socket.getOutputStream())) {
                    dataOutputStream.writeDouble(6.66);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
