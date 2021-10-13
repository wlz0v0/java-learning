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
public class SpecialDay implements MidAutumn, NationalDay{
    @Override
    public void eatMooncake() {
        System.out.println("Eat a mooncake");
    }

    @Override
    public void singSong() {
        System.out.println("Sing a song");
    }
}
