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
public class Quiz03 {

    public static void main(String[] args) {
        var copy = new File("./copy.txt");
        if (!copy.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                copy.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        var file = new File("./file.txt");
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                copy.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Quiz02.writeFile(file, "this is info in file");
        }

        byte[] bytes = new byte[100];
        int len = 0;
        try (var inputStream = new FileInputStream("./file.txt")) {
            len = inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (var outputStream = new FileOutputStream(copy)) {
            outputStream.write(bytes, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
