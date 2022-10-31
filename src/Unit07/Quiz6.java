package Unit07;


/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/11/17
 *     desc   :
 *     version:
 * </pre>
 */
public class Quiz6 {
    public static void main(String[] args) throws InterruptedException {
        var lock = new Object();
        var printChar = new Thread1(lock);
        var printNum = new Thread2(lock);

        printChar.start();
        printNum.start();

        printChar.join();
        printNum.join();
    }
}

class Thread1 extends Thread {
    final Object lock;

    Thread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

        synchronized (lock) {
            lock.notify();
        }

        for (char i = 'a'; i <= 'z'; i++) {
            System.out.printf("%c ", i);
        }
    }
}

class Thread2 extends Thread {
    final Object lock;

    Thread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException ignored) {
            }
        }

        for (int i = 1; i <= 26; i++) {
            System.out.printf("%d ", i);
        }
    }
}