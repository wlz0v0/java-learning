package Unit03;

import java.util.Arrays;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/29
 *     desc   :
 *     version:
 * </pre>
 */
public class SmartRobot extends Robot {
    private int[][] stepsRecord; // 初始为-1，走一步数值+1
    private final int offset;
    private int stepCnt;

    public SmartRobot(String name) {
        this(name, 0, 0, Direction.EAST);
    }

    public SmartRobot(String name, int x, int y, Direction direction) {
        super(name, x, y, direction);
        stepsRecord = new int[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                stepsRecord[i][j] = -1;
            }
        }
        offset = 4;
        stepCnt = 0;
        stepsRecord[x + offset][y + offset] = 0;
    }

    @Override
    public void move(int steps) {
        while (steps != 0) {
            ++stepCnt;
            --steps;
            super.move(1);
            stepsRecord[position.getX() + offset][position.getY() + offset] = stepCnt;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(":\n");
        for (var line : stepsRecord) {
            for (var column : line) {
                builder.append(column).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
