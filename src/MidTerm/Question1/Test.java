package MidTerm.Question1;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/10/13
 *     desc   :
 *     version:
 * </pre>
 */
public class Test {
    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        SpecialDay day = new SpecialDay();
        if (day instanceof MidAutumn) {
            day.eatMooncake();
        }
        if (day instanceof SpecialDay) {
            day.singSong();
        }
    }
}
