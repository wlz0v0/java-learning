package FinalTerm.Question1;

public class Student extends Person {
    public Status status;

    /**
     * @param name        姓名
     * @param address     住址
     * @param phoneNumber 手机号
     * @param email       邮箱地址
     * @param status      年级
     */
    public Student(String name, String address, String phoneNumber, String email, Status status) {
        super(name, address, phoneNumber, email);
        this.status = status;
    }

    /**
     * @return 类名 + 人名
     */
    @Override
    public String toString() {
        return "class name: " + "Student" + " person name: " + name;
    }

    /**
     * 年级枚举类，包括大一二三四
     */
    public enum Status {
        FRESH_MAN,
        SOPHOMORE,
        JUNIOR,
        SENIOR
    }
}
