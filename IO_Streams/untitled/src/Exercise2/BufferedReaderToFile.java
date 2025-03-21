package Exercise2;

import java.io.*;
public class BufferedReaderToFile {
    public static void main(String[] args) {
        String fileName = "output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            System.out.println("Nhập nội dung (gõ 'exit' để thoát):");
            String line;

            while ((line = reader.readLine()) != null) {
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Dữ liệu đã được lưu vào " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi xử lý tệp: " + e.getMessage());
        }
    }
}
