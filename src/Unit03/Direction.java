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
    EAST,
    WEST,
    NORTH,
    SOUTH;

    Direction left;
    Direction right;

    public static void bindDirections() {
        EAST.left = NORTH;
        EAST.right = SOUTH;
        WEST.right = NORTH;
        WEST.left = SOUTH;
        NORTH.left = WEST;
        NORTH.right = EAST;
        SOUTH.left = EAST;
        SOUTH.right = WEST;
    }

    public Direction turnLeft() {
        return this.left;
    }

    public Direction turnRight() {
        return this.right;
    }
}
