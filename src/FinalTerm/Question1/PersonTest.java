package FinalTerm.Question1;

public class PersonTest {
    public static void main(String[] args) {
        // 创建四个对象
        var person = new Person("Trump", "USA", "911", "Trump@love.cn");
        var student = new Student("Handsome", "Beijing", "123", "sg@bupt.edu.cn", Student.Status.SOPHOMORE);
        var employee = new Employee("Big Mengzi", "工地", "100", "meng@163.com", "工地", 1.0);
        var staff = new Staff("Me", "BUPT", "996", "gg@future.good", "Unknown", 0.0, "Unknown");

        // 把四个对象保存到Person数组中
        var persons = new Person[4];
        persons[0] = person;
        persons[1] = student;
        persons[2] = employee;
        persons[3] = staff;

        // 调用所有对象的toString
        for (var p : persons) {
            System.out.println(p.toString());
        }
    }
}
