package Lab2.Project3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    public final static int SERVER_PORT = 11778;
    public final static int CLIENT_PORT = 1778;

    public static void main(String[] args) {
        try (var socket = new Socket("127.0.0.1", SERVER_PORT);
             var oos = new ObjectOutputStream(socket.getOutputStream());
             var ois = new ObjectInputStream(socket.getInputStream());
             var datagramSocket = new DatagramSocket(CLIENT_PORT)) {

            var aThread = new RandomChoiceThread(
                    (choice, sleepDuration) -> {
                        try {
                            oos.writeObject(choice);
                            oos.writeInt(sleepDuration);
                            System.out.println("a" + choice + " " + sleepDuration);
                            oos.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    },
                    () -> {
                        try {
                            ois.readBoolean();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

            var bThread = new RandomChoiceThread(
                    (choice, sleepDuration) -> {
                        try (var bos = new ByteArrayOutputStream();
                             var oos2 = new ObjectOutputStream(bos)) {
                            oos2.writeObject(choice);
                            oos2.writeInt(sleepDuration);
                            oos2.flush();
                            byte[] bytes = bos.toByteArray();
                            var address = InetAddress.getLocalHost();
                            var packet = new DatagramPacket(bytes, bytes.length, address, SERVER_PORT);
                            datagramSocket.send(packet);
                            System.out.println("b" + choice + " " + sleepDuration);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    },
                    () -> {
                        try {
                            byte[] bytes = new byte[128];
                            var packet = new DatagramPacket(bytes, bytes.length);
                            datagramSocket.receive(packet);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

            aThread.start();
            bThread.start();
            while (!aThread.stop || !bThread.stop) {
                Thread.onSpinWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
