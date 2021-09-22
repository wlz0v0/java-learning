package Unit02Part2.Exercise05;

import java.util.Random;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/22
 *     desc   :
 *     version:
 * </pre>
 */
public class GuessNumber {
    private final int num;
    private int counter;
    private static int numOfObjects = 0;

    public GuessNumber() {
        this(11);
    }

    public GuessNumber(int range) {
        Random random = new Random();
        num = random.nextInt(range);
        counter = 0;
        ++numOfObjects;
    }

    public static int getNumOfObjects() {
        return numOfObjects;
    }

    public int getCounter() {
        return counter;
    }

    public boolean guess(int num) {
        ++counter;
        if (num == this.num) {
            System.out.println("Congratulations!");
            return true;
        } else if (num > this.num) {
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller");
        }
        return false;
    }
}
