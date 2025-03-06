package Exercise1.Cach1;

public class EvenThread extends Thread {
    private Thread oddThread;

    public EvenThread(Thread oddThread) {
        this.oddThread = oddThread;
    }
    @Override
    public void run() {
        try {
            oddThread.join();
        } catch (InterruptedException e) {}
        for (int i = 2; i <= 100 ; i += 2) {
            System.out.println("Even Thread: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
