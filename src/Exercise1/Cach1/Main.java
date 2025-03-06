package Exercise1.Cach1;

public class Main {
    public static void main(String[] args) {
        OddThread oddthread = new OddThread();
        oddthread.start();
        EvenThread eventhread = new EvenThread(oddthread);
        eventhread.start();
    }
}
