package FinalTerm.Question3;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/16
 *     desc   :
 *     version:
 * </pre>
 */
public class Buffer {
    /**
     * LinkedBlockingQueue中包含2个方法
     */
    private final LinkedBlockingQueue<Integer> buffer;

    public Buffer(int capacity) {
        buffer = new LinkedBlockingQueue<>(capacity);
    }

    public void putMessage(int msg) {
        try {
            buffer.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getMessage() {
        int res = -1;
        while (res == -1) {
            try {
                res = buffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
