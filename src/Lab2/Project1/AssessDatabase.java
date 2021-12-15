package Lab2.Project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/01
 *     desc   :
 *     version:
 * </pre>
 */
public class AssessDatabase {
    private final static String user = "root";
    private final static String pwd = "wlz123hhh";
    private static Connection conn;
    // 采用PreparedStatement，避免SQL注入以及提高性能
    private static PreparedStatement insertStatement;
    private static PreparedStatement deleteStatement;
    private static PreparedStatement viewStatement;
    private static PreparedStatement viewAllStatement;
    private static PreparedStatement lUpdateStatement;
    private static PreparedStatement fUpdateStatement;
    private static PreparedStatement tUpdateStatement;
    private static PreparedStatement eUpdateStatement;

    public static void main(String[] args) {
        // 加载驱动并获取连接
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Lab2", user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn == null) {
            System.err.println("获取连接失败");
            return;
        }

        // 打印提示
        help();
        // 开始读取用户输入并执行对应操作
        var scanner = new Scanner(System.in);
        String command;
        boolean exit = false;
        while (!exit) {
            System.out.print("请输入您的指令: ");
            command = scanner.nextLine();
            var cmdArgs = command.split(" ");
            switch (cmdArgs[0]) {
                case "help":
                    help();
                    break;
                case "insert":
                    insert(cmdArgs);
                    break;
                case "delete":
                    delete(cmdArgs);
                    break;
                case "view":
                    view(cmdArgs);
                    break;
                case "update":
                    update(cmdArgs);
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.err.println("请输入正确指令！");
            }
        }

        // 关闭所有资源
        try {
            closePreparedStatement(insertStatement);
            closePreparedStatement(deleteStatement);
            closePreparedStatement(viewStatement);
            closePreparedStatement(viewAllStatement);
            closePreparedStatement(eUpdateStatement);
            closePreparedStatement(fUpdateStatement);
            closePreparedStatement(lUpdateStatement);
            closePreparedStatement(tUpdateStatement);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void help() {
        System.out.println("指令用法:");
        System.out.println("help 查看指令");
        System.out.println("insert [id] [last name] [first name] [telephone] [email] 插入新员工信息");
        System.out.println("delete [id] 删除指定id员工信息");
        System.out.println("view [id] 查询指定id的员工信息, view all 查询所有员工信息");
        System.out.println("update [id] [-l|-f|-t|-e] [new data] 更新指定id的员工的指定信息\n" +
                "-l: last name, -f: first name, -t: telephone, -e: email");
        System.out.println("exit 退出");
    }

    private static void insert(String[] args) {
        if (args.length != 6) {
            System.out.println("指令用法: insert [id] [last name] [first name] [telephone] [email]");
            return;
        }
        try {
            // 采用懒加载
            if (insertStatement == null) {
                insertStatement = conn.prepareStatement("insert into lab2.staff (id, lastName, firstName, telephone, email) values (?, ?, ?, ?, ?);");
            }
            for (int i = 1; i <= 5; ++i) {
                insertStatement.setString(i, args[i]);
            }
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void delete(String[] args) {
        if (args.length != 2) {
            System.out.println("指令用法: delete [id]");
            return;
        }

        try {
            // 采用懒加载
            if (deleteStatement == null) {
                deleteStatement = conn.prepareStatement("delete from lab2.staff where id = ?;");
            }
            deleteStatement.setString(1, args[1]);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void view(String[] args) {
        if (args.length != 2) {
            System.out.println("指令用法: view [id], view all");
            return;
        }
        try {
            PreparedStatement stm;
            if (args[1].equals("all")) {
                if (viewAllStatement == null) {
                    viewAllStatement = conn.prepareStatement("select * from lab2.staff");
                }
                stm = viewAllStatement;
            } else {
                // 采用懒加载
                if (viewStatement == null) {
                    viewStatement = conn.prepareStatement("select * from lab2.staff where id = ?;");
                }
                viewStatement.setString(1, args[1]);
                stm = viewStatement;
            }
            var rs = stm.executeQuery();
            if (!rs.next()) {
                System.out.println("查无此人");
            }
            do {
                System.out.println("id:" + rs.getString("id") +
                        " last name:" + rs.getString("lastName") +
                        " first name:" + rs.getString("firstName") +
                        " telephone:" + rs.getString("telephone") +
                        " email:" + rs.getString("email"));
            } while (rs.next());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void update(String[] args) {
        if (args.length != 4) {
            System.out.println("指令用法: update [id] [-l|-f|-t|-e] [new data]\n" +
                    "-l: last name, -f: first name, -t: telephone, -e: email");
            return;
        }
        try {
            // 采用懒加载
            PreparedStatement updateStatement;
            switch (args[2]) {
                case "-l":
                    if (lUpdateStatement == null) {
                        lUpdateStatement = conn.prepareStatement("update lab2.staff set lastName = ? where id = ?;");
                    }
                    updateStatement = lUpdateStatement;
                    break;
                case "-f":
                    if (fUpdateStatement == null) {
                        fUpdateStatement = conn.prepareStatement("update lab2.staff set firstName = ? where id = ?;");
                    }
                    updateStatement = fUpdateStatement;
                    break;
                case "-t":
                    if (tUpdateStatement == null) {
                        tUpdateStatement = conn.prepareStatement("update lab2.staff set telephone = ? where id = ?;");
                    }
                    updateStatement = tUpdateStatement;
                    break;
                case "-e":
                    if (eUpdateStatement == null) {
                        eUpdateStatement = conn.prepareStatement("update lab2.staff set email = ? where id = ?;");
                    }
                    updateStatement = eUpdateStatement;
                    break;
                default:
                    System.out.println("指令用法: update [id] [-l|-f|-t|-e] [new data]\n" +
                            "-l: last name, -f: first name, -t: telephone, -e: email");
                    return;
            }
            updateStatement.setString(1, args[3]);
            updateStatement.setString(2, args[1]);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closePreparedStatement(PreparedStatement stm) throws SQLException {
        if (stm != null) {
            stm.close();
        }
    }
}
