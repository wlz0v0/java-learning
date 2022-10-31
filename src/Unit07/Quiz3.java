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
public class Quiz3 {
    public static void main(String[] args) throws InterruptedException {
        var printChar = new PrintCharThread();
        var printNum = new Thread(new PrintNumRunnable(printChar));

        printChar.start();
        printNum.start();

        printChar.join();
        printNum.join();
    }
}

class PrintCharThread extends Thread {
    @Override
    public void run() {
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.printf("%c ", i);
            if (i == 'o') {
                PrintCharThread.yield();
            }
        }
    }
}

class PrintNumRunnable implements Runnable {
    private final Thread charThread;

    public PrintNumRunnable(Thread thread) {
        this.charThread = thread;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 26; i++) {
            System.out.printf("%d ", i);
            if (i == 20) {
                try {
                    charThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
