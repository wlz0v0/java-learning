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
public class Subscriber {
    private final Buffer buffer;

    public Subscriber(Buffer buffer) {
        this.buffer = buffer;
    }

    public void subscribe() {
        int num = buffer.getMessage();
        System.out.println("Subscribe " + num);
    }
}
