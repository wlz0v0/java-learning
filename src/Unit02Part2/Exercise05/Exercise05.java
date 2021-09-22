package Unit02Part2.Exercise05;

import java.util.Scanner;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/22
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise05 {
    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (!guessNumber.guess(num)) {
            System.out.println(guessNumber.getCounter());
            num = scanner.nextInt();
        }
        GuessNumber guessNumber1 = new GuessNumber();
        GuessNumber guessNumber2 = new GuessNumber();
        System.out.println(GuessNumber.getNumOfObjects());
    }
}
