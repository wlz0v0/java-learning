package FinalTerm.Question3;

import java.util.concurrent.LinkedBlockingQueue;

public class Buffer {
    /**
     * LinkedBlockingQueue中有2个方法: <br>
     * put(E e)会在队尾插入元素，如果队列已满则等待直到队列有多余空间<br>
     * take()会获取队头元素，如果队列为空则等待直到队列中有元素<br>
     * 这个数据结构非常符合本题的需求
     */
    private final LinkedBlockingQueue<Integer> buffer;

    /**
     * @param capacity 缓冲区容量
     */
    public Buffer(int capacity) {
        buffer = new LinkedBlockingQueue<>(capacity);
    }

    /**
     * @param msg 将一条消息加入缓冲区队列的队尾
     */
    public void putMessage(int msg) {
        // 当等待时被打断就再put一次，如果是其他的异常则不put
        boolean flag;
        do {
            try {
                buffer.put(msg);
                flag = false;
            } catch (InterruptedException e) {
                flag = true;
                e.printStackTrace();
            }
        } while (flag);
    }

    /**
     * @return 获取缓冲区队列队头的消息
     */
    public int getMessage() {
        int res = -1;
        // 当等待时被打断就再take一次，直到成功为止
        do {
            try {
                res = buffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (res == -1);
        return res;
    }
}
