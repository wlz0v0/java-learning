package FinalTerm.Question3;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/16
 *     desc   :
 *     version:
 * </pre>
 */
public class Publisher {
    private int cnt;
    private final Buffer buffer;

    public Publisher(Buffer buffer) {
        this.buffer = buffer;
        cnt = 0;
    }

    public void publish() {
        buffer.putMessage(cnt);
        System.out.println("Publish " + cnt++);
    }
}
