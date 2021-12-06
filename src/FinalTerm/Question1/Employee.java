package FinalTerm.Question1;

public class Employee extends Person {
    public String office;
    public double salary;

    /**
     * @param name        姓名
     * @param address     住址
     * @param phoneNumber 手机号
     * @param email       邮箱地址
     * @param office      办公室
     * @param salary      薪水
     */
    public Employee(String name, String address, String phoneNumber, String email, String office, double salary) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
    }

    /**
     * @return 类名 + 人名
     */
    @Override
    public String toString() {
        return "class name: " + "Employee" + " person name: " + name;
    }
}
