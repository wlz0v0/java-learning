package MidTerm.Question1;

/**
 * 节日类，实现了中秋节，国庆节接口
 */
public class SpecialDay implements MidAutumn, NationalDay{
    /**
     * 实现MidAutumn接口方法
     */
    @Override
    public void eatMooncake() {
        System.out.println("Eat a mooncake");
    }

    /**
     * 实现NationalDay接口方法
     */
    @Override
    public void singSong() {
        System.out.println("Sing a song");
    }
}
