package Unit06;

import java.io.*;

public class Quiz05 {
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
            var objectOutputStream = new ObjectOutputStream(fileOutputStream);
            String s = "this is string";
            Integer integer = 100000;
            objectOutputStream.writeObject(s);
            objectOutputStream.writeObject(integer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var fileInputStream = new FileInputStream("./file")) {
            var objectInputStream = new ObjectInputStream(fileInputStream);
            String s = (String) objectInputStream.readObject();
            Integer integer = (Integer) objectInputStream.readObject();
            System.out.println(s);
            System.out.println(integer);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
