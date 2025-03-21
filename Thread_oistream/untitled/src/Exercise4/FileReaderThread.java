package Exercise4;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class FileReaderThread extends Thread {
    private String filePath;
    private BlockingQueue<String> queue;

    public FileReaderThread(String filePath, BlockingQueue<String> queue) {
        this.filePath = filePath;
        this.queue = queue;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.put(line); // Đưa dòng vào hàng đợi
            }
            queue.put("EOF"); // Đánh dấu kết thúc file
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WordCountThread extends Thread {
    private BlockingQueue<String> queue;

    public WordCountThread(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int wordCount = 0;
        try {
            while (true) {
                String line = queue.take(); // Lấy dòng từ hàng đợi
                if ("EOF".equals(line)) break; // Kiểm tra kết thúc file
                wordCount += line.split("\\s+").length;
            }
            System.out.println("Tổng số từ trong file: " + wordCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
