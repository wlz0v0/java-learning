package FinalTerm.Question1;

public class Person {
    public String name;
    public String address;
    public String phoneNumber;
    public String email;

    /**
     * @param name        姓名
     * @param address     住址
     * @param phoneNumber 手机号
     * @param email       邮箱地址
     */
    public Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * @return 类名 + 人名
     */
    @Override
    public String toString() {
        return "class name: " + "Person" + " person name: " + name;
    }
}
