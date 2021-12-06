package FinalTerm.Question1;

public class Staff extends Employee {
    public String title;

    /**
     * @param name        姓名
     * @param address     住址
     * @param phoneNumber 手机号
     * @param email       邮箱地址
     */
    public Staff(String name, String address, String phoneNumber, String email, String office, double salary, String title) {
        super(name, address, phoneNumber, email, office, salary);
        this.title = title;
    }

    /**
     * @return 类名 + 人名
     */
    @Override
    public String toString() {
        return "class name: " + "Staff" + " person name: " + name;
    }
}
