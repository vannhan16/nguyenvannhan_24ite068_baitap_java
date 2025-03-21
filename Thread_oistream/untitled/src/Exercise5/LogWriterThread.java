package Exercise5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class LogWriterThread extends Thread {
    private String logFile;
    private String message;

    public LogWriterThread(String logFile, String message) {
        this.logFile = logFile;
        this.message = message;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.write("[" + timestamp + "] " + message);
            writer.newLine();
            System.out.println("Log ghi thành công: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
