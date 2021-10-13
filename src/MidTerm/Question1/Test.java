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
        // 创建SpecialDay实例
        SpecialDay day = new SpecialDay();
        // 判断是否是MidAutumn接口的实例，若是则调用其方法
        if (day instanceof MidAutumn) {
            day.eatMooncake();
        }
        // 判断是否是NationalDay接口的实例，若是则调用其方法
        if (day instanceof NationalDay) {
            day.singSong();
        }
    }
}
