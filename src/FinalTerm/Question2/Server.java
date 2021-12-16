package FinalTerm.Question2;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    /**
     * 端口号
     */
    public final static int PORT = 4396;

    public static void main(String[] args) {
        var file = new File("./string.dat");
        try (var ss = new ServerSocket(PORT)) {
            //noinspection InfiniteLoopStatement
            while (true) {
                var socket = ss.accept();
                // 生成一个新线程
                new Thread(() -> {
                    // 使用try-with-resource自动关闭流
                    try (var dis = new DataInputStream(socket.getInputStream());
                         var fos = new FileOutputStream(file, true);
                         var dos = new DataOutputStream(fos)) {
                        // 同步
                        synchronized (file) {
                            byte[] bytes = new byte[64];
                            int len = dis.read(bytes);
                            String str = new String(bytes, 0, len);
                            // 控制台输出
                            System.out.print(str);
                            // 写入文件
                            dos.write(str.getBytes());
                            dos.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        // 关闭socket连接 释放资源
                        // 不用try-with-resource是因为socket必须要在数据传输之后关闭
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
