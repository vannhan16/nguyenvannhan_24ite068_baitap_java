package Exercise3;

public class Main {
    public static void main(String[] args) {
        String source = "F:\\Java2\\Thread_oistream\\untitled\\src\\Exercise3\\source.txt";  // Đường dẫn file nguồn
        String destination = "destination.txt"; // Đường dẫn file đích

        FileCopyThread copyThread = new FileCopyThread(source, destination);
        copyThread.start();
    }
}
