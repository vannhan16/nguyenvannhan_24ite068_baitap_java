package Exercise5;

import java.io.*;

public class ListFilesInDirectory {
    public static void main(String[] args) {
        String directoryPath = "./";

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                System.out.println("Danh sách tệp trong thư mục " + directoryPath + ":");
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Không thể liệt kê tệp trong thư mục.");
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc không hợp lệ.");
        }
    }
}

