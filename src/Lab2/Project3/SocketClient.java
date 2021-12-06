package Lab2.Project3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/05
 *     desc   :
 *     version:
 * </pre>
 */
public class SocketClient {
    public final static int PORT = 1778;

    public static void main(String[] args) {
        try (var socket = new Socket("127.0.0.1", PORT);
             var datagramSocket = new DatagramSocket()) {
            var aThread = new RandomChoiceThread((choice, sleepDuration) -> {
                try (var oos = new ObjectOutputStream(socket.getOutputStream())) {
                    oos.writeObject(choice);
                    oos.write(sleepDuration);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            var bThread = new RandomChoiceThread((choice, sleepDuration) -> {
                try (var bos = new ByteArrayOutputStream();
                     var oos = new ObjectOutputStream(bos)) {
                    oos.writeObject(choice);
                    oos.write(sleepDuration);
                    byte[] bytes = bos.toByteArray();
                    var address = InetAddress.getByName("127.0.0.1");
                    var packet = new DatagramPacket(bytes, bytes.length, address, PORT);
                    datagramSocket.send(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
