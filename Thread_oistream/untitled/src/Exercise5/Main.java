package Exercise5;

public class Main {
    public static void main(String[] args) {
        String logFile = "log.txt";

        Thread log1 = new LogWriterThread(logFile, "Ứng dụng khởi động.");
        Thread log2 = new LogWriterThread(logFile, "Người dùng đăng nhập.");

        log1.start();
        log2.start();
    }
}

