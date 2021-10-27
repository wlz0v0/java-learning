package Unit05;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/10/27
 *     desc   :
 *     version:
 * </pre>
 */
public class DividingZero extends Exception {
    private final String info = "除数不能为0！";

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println(info);
    }

    @Override
    public String getMessage() {
        return info;
    }
}
