package Unit02.Homework;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/29
 *     desc   :
 *     version:
 * </pre>
 */
public class TestCircle {
    public static void main(String[] args) {
        SimpleCircle[] arr = {
                new SimpleCircle(1.0),
                new SimpleCircle(2.0),
                new SimpleCircle(3.0)
        };

        System.out.println(SimpleCircle.getNumOfObjects());
        for (var c : arr) {
            System.out.println(c.getArea());
        }

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = null;
            System.gc();
            System.runFinalization();
            System.out.println(SimpleCircle.getNumOfObjects());
        }
    }
}
