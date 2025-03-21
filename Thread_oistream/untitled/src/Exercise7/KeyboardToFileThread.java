package Exercise7;

import java.io.*;
import java.util.Scanner;

class KeyboardToFileThread extends Thread {
    private String filePath;

    public KeyboardToFileThread(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            System.out.println("Nhập dữ liệu (gõ 'exit' để thoát):");

            while (true) {
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) break;

                writer.write(input);
                writer.newLine();
                writer.flush(); // Đảm bảo dữ liệu được ghi ngay lập tức
            }

            System.out.println("Dữ liệu đã được lưu vào file " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
