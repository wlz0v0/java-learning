package Unit01;

import java.util.Random;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/15
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise10 {
    public static void main(String[] args) {
        var random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; ++i) {
            arr[i] = random.nextInt(100);
        }
        bubbleSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
