package Exercise4;

import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {
        String fileName = "numbers.dat";
        int[] numbers = {10, 20, 30, 40, 50};

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int number : numbers) {
                dos.writeInt(number);
            }
            System.out.println("Đã ghi danh sách số nguyên vào " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Các số nguyên đọc từ file:");
            while (dis.available() > 0) {
                System.out.println(dis.readInt());
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}

