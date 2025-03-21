package Exercise2;

public class Main {
    public static void main(String[] args) {
        String filePath = "output.txt";
        Thread thread1 = new FileWriterThread(filePath, "Thread 1: Xin chào từ Java!");
        Thread thread2 = new FileWriterThread(filePath, "Thread 2: Lập trình đa luồng rất thú vị!");

        thread1.start();
        thread2.start();
    }
}
