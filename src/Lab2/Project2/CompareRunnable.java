package Lab2.Project2;

/**
 * CompareRunnable.java
 * 比较字符类，实现Runnable，用于创建一个线程来比较字符
 */
public class CompareRunnable implements Runnable {
    public final RandomCharThread aThread;
    public final RandomCharThread bThread;

    public CompareRunnable(RandomCharThread a, RandomCharThread b) {
        aThread = a;
        bThread = b;
    }

    @Override
    public void run() {
        int aSleepDuration;
        int bSleepDuration;
        char a;
        char b;
        int aPoint = 0;
        int bPoint = 0;

        for (int i = 1; i <= MultiThread.ROUND; ++i) {
            // 阻塞当前线程，等待a、b线程生成字符
            while (aThread.stop || bThread.stop) {
                Thread.onSpinWait();
            }
            aSleepDuration = aThread.millis;
            a = aThread.ch;
            bSleepDuration = bThread.millis;
            b = bThread.ch;

            // 计算分数
            if (a > b) {
                aPoint += 2;
            } else if (a == b) {
                ++aPoint;
                ++bPoint;
            } else {
                bPoint += 2;
            }

            System.out.println(i + "  " + aSleepDuration + "  " + a + "  " + aPoint +
                    "  " + bSleepDuration + "  " + b + "  " + bPoint);
            // 重置阻塞条件
            aThread.stop = true;
            bThread.stop = true;
        }
        // 根据得分输出胜负结果
        if (aPoint > bPoint) {
            System.out.println("A is the winner");
        } else if (aPoint == bPoint) {
            System.out.println("None is the winner");
        } else {
            System.out.println("B is the winner");
        }
    }
}
