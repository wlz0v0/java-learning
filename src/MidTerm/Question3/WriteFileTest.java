package MidTerm.Question3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/10/13
 *     desc   :
 *     version:
 * </pre>
 */
public class WriteFileTest {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) {
        // 文件路径
        final String path = "C:\\MyDownload\\file.txt";
        // 通过路径创建file.txt
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("创建文件");
        }
        // 输出字符串
        String[] strings = {
                "Man on earth\n",
                "Good at birth\n",
                "The same nature\n",
                "Varies on nurture\n",
                "With no education\n",
                "There'd be aberration\n",
                "To teach well\n",
                "You deeply dwell\n"
        };
        FileOutputStream outputStream;
        try {
            // 创建文件输出流将信息输出到文件
            outputStream = new FileOutputStream(file);
            for (var str : strings) {
                // 采用UTF-8字符集输出
                outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
