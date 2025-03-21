package Exercise2;

import java.io.*;

class FileWriterThread extends Thread {
    private String filePath;
    private String content;
    private static final Object lock = new Object(); // Đối tượng khóa để đồng bộ hóa

    public FileWriterThread(String filePath, String content) {
        this.filePath = filePath;
        this.content = content;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(content);
                writer.newLine();
                System.out.println(Thread.currentThread().getName() + " đã ghi: " + content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}