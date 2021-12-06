package Lab2.Project3;

import java.io.Serializable;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/04
 *     desc   :
 *     version:
 * </pre>
 */
public enum Choice implements Serializable {
    ROCK(0),
    SCISSORS(1),
    PAPER(2);

    final int value;

    Choice(int value) {
        this.value = value;
    }

    public static Choice valueOf(int value) {
        value %= 3;
        switch (value) {
            case 0:
                return ROCK;
            case 1:
                return SCISSORS;
            case 2:
                return PAPER;
            default:
                return null;
        }
    }

    Choice getCounter() {
        return valueOf(this.value + 1);
    }

    Choice getCountered() {
        return valueOf(this.value + 2);
    }
}
