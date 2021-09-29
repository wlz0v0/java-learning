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
public class RobotTest {
    public static void main(String[] args) {
        Robot robot = new SmartRobot("Moon");
        robot.turnLeft();
        robot.move(2);
        robot.turnLeft();
        robot.move(2);
        robot.turnRight();
        robot.turnRight();
        robot.move(3);
        System.out.println(robot);
    }
}
