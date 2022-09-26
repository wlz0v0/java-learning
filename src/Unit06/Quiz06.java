package Unit06;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Quiz06 {
    public static void main(String[] args) {
        // write
        try (var randomAccessFile = new RandomAccessFile("./file", "rw")) {
            int[] data = {1, 2, 3, 4, 5, 6, 7};
            for (int datum : data) {
                randomAccessFile.writeInt(datum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // read
        try (var randomAccessFile = new RandomAccessFile("./file", "rw")) {
            randomAccessFile.skipBytes(4 * 6);// int 4 bytes, 7 - 1
            System.out.println(randomAccessFile.readInt());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
