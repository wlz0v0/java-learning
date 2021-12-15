package Lab2.Project3;

import java.util.Random;

/**
 * RandomChoiceThread.java
 */
public class RandomChoiceThread extends Thread {
    private final SendInterface sendCallback;
    private final ReceiveInterface receiveCallback;
    public Choice choice;
    public int millis;
    public volatile boolean stop = false;

    /**
     * @param sendCallback    发送数据回调函数
     * @param receiveCallback 接收数据回调函数
     */
    public RandomChoiceThread(SendInterface sendCallback, ReceiveInterface receiveCallback) {
        this.sendCallback = sendCallback;
        this.receiveCallback = receiveCallback;
    }

    @Override
    public void run() {
        var random = new Random();
        for (int i = 1; i <= SocketServer.round; ++i) {
            // 睡眠小于1s时间
            try {
                millis = random.nextInt(1000);
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            choice = Choice.getChoice(random.nextInt(3));

            sendCallback.send(choice, millis);
            // 通过阻塞式receive阻塞线程直到获取服务端反馈再生成下一组数据
            receiveCallback.receive();
        }
        stop = true;
    }

    /**
     * 发送数据接口，本类将通过实现的send方法把生成的选择和线程睡眠时间发送给服务端
     */
    public interface SendInterface {
        void send(Choice choice, int sleepDuration);
    }

    /**
     * 接收数据接口，本类将通过实现的receive方法接收服务端的反馈<br>
     * receive方法应当是阻塞式的
     */
    public interface ReceiveInterface {
        void receive();
    }
}
