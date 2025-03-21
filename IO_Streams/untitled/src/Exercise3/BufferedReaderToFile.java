package Exercise3;

import java.io.*;

public class BufferedReaderToFile {
    public static void main(String[] args) {

        String fileName = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int lineCount = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
            }

            System.out.println("Số dòng trong tệp " + fileName + " là: " + lineCount);
        } catch (IOException e) {
            System.err.println("Lỗi khi xử lý tệp: " + e.getMessage());
        }
    }
}
