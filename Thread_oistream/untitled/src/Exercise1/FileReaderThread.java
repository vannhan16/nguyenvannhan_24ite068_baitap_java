package Exercise1;

import java.io.*;


class FileReaderThread extends Thread {
    private String filePath;

    public FileReaderThread(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + ": " + line);
                Thread.sleep(500); // Giả lập độ trễ để thấy rõ luồng hoạt động
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

