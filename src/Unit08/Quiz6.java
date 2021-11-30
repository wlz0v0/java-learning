package Unit08;

import java.sql.*;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/11/28
 *     desc   :
 *     version:
 * </pre>
 */
public class Quiz6 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/unit08", "root", "wlz123hhh");
            Statement statement = conn.createStatement();
            statement.executeUpdate("insert into Person (Name, age, marriage) values ('Kitty', 13, false)");
            statement.executeUpdate("update Person set Name='Hello Kitty' where Name='Kitty'");
            ResultSet set = statement.executeQuery("select * from Person");
            while (set.next()) {
                System.out.println(set.getString("Name") + " "
                        + set.getString("Age") + " "
                        + Boolean.valueOf(set.getString("marriage")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
