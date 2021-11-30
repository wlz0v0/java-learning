package Unit07;

import java.util.concurrent.Executors;

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
    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(3);
        var printChar = new PrintChar('a');
//        executor.execute(new PrintChar('a'));
//        executor.execute(new PrintNum(printChar));
//        executor.execute(printChar);
        var printNum = new Thread(new PrintNum(printChar));
        printChar.start();
        printNum.start();

        executor.shutdown();
        System.out.println("Main finished");
    }
}

class PrintChar extends Thread {
    private final char start;

    public PrintChar(char start) {
        this.start = start;
    }

    @Override
    public void run() {
        char a = start;
        int cnt = 26;
        while (cnt-- != 0) {
            System.out.print(a++ + " ");
            if (a == 'o') {
                PrintChar.yield();
            }
        }
    }
}

class PrintNum implements Runnable {
    private final Thread charThread;

    public PrintNum(Thread thread) {
        this.charThread = thread;
    }

    @Override
    public void run() {
        int num = 0;
        while (num++ != 26) {
            System.out.print(num + " ");
            if (num == 20) {
                try {
                    charThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
