package Unit06;

import java.io.*;

public class Quiz04 {
    public static void main(String[] args) {
        var file = new File("./file");
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (var fileOutputStream = new FileOutputStream("./file")) {
            var dataOutputStream = new DataOutputStream(fileOutputStream);
            int[] data = {1, 2, 3, 5};
            for (int datum : data) {
                dataOutputStream.writeInt(datum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var fileInputStream = new FileInputStream("./file")) {
            var dataInputStream = new DataInputStream(fileInputStream);
            int[] data = new int[4];
            for (int i = 0; i < 4; ++i) {
                data[i] = dataInputStream.readInt();
            }
            for (int datum : data) {
                System.out.println(datum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
