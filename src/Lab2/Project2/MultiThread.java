package Lab2.Project2;

/**
 * MultiThread.java
 */
public class MultiThread {
    public final static int ROUND = 20;

    public static void main(String[] args) {
        var a = new RandomCharThread();
        var b = new RandomCharThread();
        var c = new Thread(new CompareRunnable(a, b));
        a.start();
        b.start();
        c.start();
    }
}
