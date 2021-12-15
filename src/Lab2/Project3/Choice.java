package Lab2.Project3;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Choice.java
 * 定义石头剪刀布三种选择的枚举类<br>
 * 实现Serializable以通过网络传输
 */
public enum Choice implements Serializable {
    ROCK,
    SCISSORS,
    PAPER;

    /**
     * 用HashMap保存克制和被克制关系
     */
    private final static HashMap<Choice, Choice> counter = new HashMap<>();
    private final static HashMap<Choice, Choice> countered = new HashMap<>();
    private final static HashMap<Integer, Choice> choice = new HashMap<>();
    private final static long serialVersionUID = 2800000593502041295L;

    static {
        counter.put(ROCK, SCISSORS);
        counter.put(SCISSORS, PAPER);
        counter.put(PAPER, ROCK);
        countered.put(ROCK, PAPER);
        countered.put(SCISSORS, ROCK);
        countered.put(PAPER, SCISSORS);
        choice.put(0, ROCK);
        choice.put(1, SCISSORS);
        choice.put(2, PAPER);
    }

    /**
     * @param val 0——石头，1——剪刀，2——布
     * @return 值对应选择 0——石头，1——剪刀，2——布
     */
    public static Choice getChoice(int val) {
        return choice.get(val);
    }

    /**
     * @return 该选择克制的选择，石头——剪刀，剪刀——布，布——石头
     */
    public Choice getCounter() {
        return counter.get(this);
    }

    /**
     * @return 克制该选择的选择，石头——布，剪刀——石头，布——剪刀
     */
    public Choice getCountered() {
        return countered.get(this);
    }
}
