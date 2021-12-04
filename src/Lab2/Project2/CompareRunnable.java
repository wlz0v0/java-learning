package Lab2.Project2;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/03
 *     desc   :
 *     version:
 * </pre>
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

        for (int i = 1; i <= Test.round; ++i) {
            while (aThread.stop || bThread.stop) {
                Thread.onSpinWait();
            }
            aSleepDuration = aThread.millis;
            a = aThread.ch;
            bSleepDuration = bThread.millis;
            b = bThread.ch;

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
            aThread.stop = true;
            bThread.stop = true;
        }
        if (aPoint > bPoint) {
            System.out.println("A is the winner");
        } else if (aPoint == bPoint) {
            System.out.println("None is the winner");
        } else {
            System.out.println("B is the winner");
        }
    }
}
