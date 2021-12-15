package FinalTerm.Question2;

import java.io.*;
import java.net.ServerSocket;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/15
 *     desc   :
 *     version:
 * </pre>
 */
public class Server {
    public final static int PORT = 4396;

    public static void main(String[] args) {
        var file = new File("./string.dat");
        try (var ss = new ServerSocket(PORT)) {
            //noinspection InfiniteLoopStatement
            while (true) {
                var socket = ss.accept();
                new Thread(() -> {
                    try (var dis = new DataInputStream(socket.getInputStream());
                         var fos = new FileOutputStream(file, true);
                         var dos = new DataOutputStream(fos)) {
                        synchronized (file) {
                            byte[] bytes = new byte[64];
                            int len = dis.read(bytes);
                            String str = new String(bytes, 0, len);
                            System.out.print(str);
                            dos.write(str.getBytes());
                            dos.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
