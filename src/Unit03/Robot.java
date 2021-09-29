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
public class Robot {
    protected String name;
    @SuppressWarnings("FieldMayBeFinal")
    protected Coordinate position;
    protected Direction direction;

    public Robot(String name) {
        this(name, 0, 0, Direction.EAST);
    }

    public Robot(String name, int x, int y, Direction direction) {
        Direction.bindDirections();
        this.name = name;
        this.position = new Coordinate(x, y);
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Direction getDirection() {
        return direction;
    }

    public void move(int steps) {
        switch (direction) {
            case EAST:
                position.setY(position.getY() + steps);
                break;
            case WEST:
                position.setY(position.getY() - steps);
                break;
            case NORTH:
                position.setX(position.getX() - steps);
                break;
            case SOUTH:
                position.setX(position.getX() + steps);
                break;
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public Coordinate getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + ":\n" +
                "x = " + Integer.valueOf(position.getX()).toString() + ", "
                + "y = " + Integer.valueOf(position.getY()).toString();
    }
}
