package Unit02.Part1;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/22
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise10 {
    public static void main(String[] args) {
        int a = 1, b = 2;
        Integer c = 2000, d = 2001;
        Exercise10 exercise10 = new Exercise10();
        System.out.println("int Before swap\n" + a + " " + b);
        exercise10.swap(a, b);
        System.out.println("int after swap\n" + a + " " + b);
        System.out.println("integer Before swap\n" + c + " " + d);
        exercise10.swap(c, d);
        System.out.println("integer after swap\n" + c + " " + d);
    }

    private <T> void swap(T lhs, T rhs) {
        T temp = lhs;
        lhs = rhs;
        rhs = temp;
    }
}

