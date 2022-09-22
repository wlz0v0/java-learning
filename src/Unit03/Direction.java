package Unit03;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/29
 *     desc   :
 *     version:
 * </pre>
 */
public enum Direction {
    EAST, NORTH, WEST, SOUTH; // 东北西南，左转下标增加

    public Direction left() {
        return Direction.values()[(this.ordinal() + 1) % 4];
    }

    public Direction right() {
        return Direction.values()[(this.ordinal() + 4 - 1) % 4];
    }
}
