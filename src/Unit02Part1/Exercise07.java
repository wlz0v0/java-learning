package Unit02Part1;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/22
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise07 {
    public static void main(String[] args) {
        Exercise07 exercise07 = new Exercise07();
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = i;
        }
        exercise07.print(exercise07.reverse(arr));
        exercise07.print(arr);
    }


    private int[] reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    private void print(int[] arr) {
        for (var a : arr) {
            System.out.println(a);
        }
    }
}
