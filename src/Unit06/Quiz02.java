package Unit06;

import java.io.*;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/10/27
 *     desc   :
 *     version:
 * </pre>
 */
@SuppressWarnings("ALL")
public class Quiz02 {
    public static void main(String[] args) {
        var file1 = new File(".\\file1.txt");
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            var fileWriter = new FileWriter(file1);
            fileWriter.write("123\n");
            fileWriter.write("456\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        var file2 = new File(".\\file2.txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            var printWriter = new PrintWriter(file2);
            printWriter.println("789");
            printWriter.println("012");
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            var fileReader = new FileReader(file1);
            char[] code = new char[10];
            fileReader.read(code);
            for (var c : code) {
                System.out.print(c);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
