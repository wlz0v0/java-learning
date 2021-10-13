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
        File file = new File("C:\\file.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("..");
        }
        String[] strings = {
                "Man on earth",
                "Good at birth",
                "The same nature",
                "Varies on nurture",
                "With no education",
                "There'd be aberration",
                "To teach well",
                "You deeply dwell"
        };
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            for (var str : strings) {
                outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
