package Lab2.Project3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 * SocketServer.java
 */
public class SocketServer {
    public final static int round = 20;
    public final static int SERVER_PORT = 11778;
    public final static int CLIENT_PORT = 1778;
    // 采用volatile保证字段可见性
    private static volatile boolean tcpStop = false;
    private static volatile boolean udpStop = false;
    private static Choice tcpChoice;
    private static int tcpSleep;
    private static Choice udpChoice;
    private static int udpSleep;

    public static void main(String[] args) {
        // TCPServer线程
        new Thread(() -> {
            try (var ss = new ServerSocket(SERVER_PORT);
                 var socket = ss.accept();
                 var ois = new ObjectInputStream(socket.getInputStream());
                 var oos = new ObjectOutputStream(socket.getOutputStream())) {
                for (int i = 0; i < round; ++i) {
                    tcpChoice = (Choice) ois.readObject();
                    tcpSleep = ois.readInt();
                    tcpStop = true;

                    // 等待主线程处理数据
                    while (tcpStop) {
                        Thread.onSpinWait();
                    }
                    oos.writeBoolean(true);
                    // 刷新缓冲区确保数据写出去了
                    oos.flush();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();

        // UDPServer线程
        new Thread(() -> {
            try (DatagramSocket datagramSocket = new DatagramSocket(SERVER_PORT)) {
                byte[] bytes = new byte[1024];
                for (int i = 0; i < round; ++i) {
                    try {
                        var receivePacket = new DatagramPacket(bytes, bytes.length);
                        datagramSocket.receive(receivePacket);
                        var bis = new ByteArrayInputStream(receivePacket.getData());
                        var ois = new ObjectInputStream(bis);
                        udpChoice = (Choice) ois.readObject();
                        udpSleep = ois.readInt();
                        udpStop = true;

                        // 等待主线程处理数据
                        while (udpStop) {
                            Thread.onSpinWait();
                        }

                        String sendStr = "Send";
                        InetAddress localHost = InetAddress.getLocalHost();
                        var sendPacket = new DatagramPacket(sendStr.getBytes(), sendStr.length(), localHost, CLIENT_PORT);
                        datagramSocket.send(sendPacket);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }).start();

        int tcpPoint = 0;
        int udpPoint = 0;
        for (int i = 1; i <= round; ++i) {
            // 阻塞主线程直到两个客户端的数据都接收到
            while (!tcpStop || !udpStop) {
                Thread.onSpinWait();
            }
            if (tcpChoice.getCounter() == udpChoice) {
                tcpPoint += 2;
            } else if (tcpChoice.getCountered() == udpChoice) {
                udpPoint += 2;
            } else {
                ++tcpPoint;
                ++udpPoint;
            }
            // SCISSORS比较长，为了输出的更加好看，SCISSORS一个制表符，剩下的两个制表符
            String table1 = tcpChoice.equals(Choice.SCISSORS) ? "\t" : "\t\t";
            String table2 = udpChoice.equals(Choice.SCISSORS) ? "\t" : "\t\t";
            System.out.println(i + "\t" + tcpSleep + "\t" + tcpChoice + table1 + tcpPoint +
                    "\t" + udpSleep + "\t" + udpChoice + table2 + udpPoint);
            tcpStop = false;
            udpStop = false;
        }
        if (tcpPoint > udpPoint) {
            System.out.println("A is the winner");
        } else if (tcpPoint == udpPoint) {
            System.out.println("None is the winner");
        } else {
            System.out.println("B is the winner");
        }
    }
}
