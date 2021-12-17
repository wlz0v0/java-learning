package FinalTerm.Question3;

public class Publisher {
    private final Buffer buffer;
    private int cnt;

    /**
     * @param buffer 发布消息的缓冲区
     */
    public Publisher(Buffer buffer) {
        this.buffer = buffer;
        cnt = 0;
    }

    /**
     * 发布一条新消息<br>
     * 注意，本函数不具备原子性，控制台可能会先输出Subscribe信息再输出Publish信息，这是正常现象<br>
     * 实际上还是先Publish才能Subscribe
     */
    public void publish() {
        buffer.putMessage(cnt);
        System.out.println("Publish " + cnt++);
    }
}
