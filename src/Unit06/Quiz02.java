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

public class Quiz02 {
    public static void printFile(File file) {
        try {
            var fileReader = new FileReader(file);
            char[] buffer = new char[100];
            int buffer_len = fileReader.read(buffer);
            System.out.printf("%s:\n", file.getName());
            for (int i = 0; i < buffer_len; i++) {
                System.out.print(buffer[i]);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(File file, String s) {
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            var fileWriter = new FileWriter(file);
            fileWriter.write(s);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var file1 = new File("./file1.txt");
        var file2 = new File("./file2.txt");

        writeFile(file1, "this is file1\n");
        writeFile(file2, "this is file2\n");
        printFile(file1);
        printFile(file2);
    }
}
