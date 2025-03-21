package Exercise1.Cach2;

public class Main {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();

        Thread oddThread = new Thread(new OddRunnable(printer));
        oddThread.start();
        Thread evenThread = new Thread(new EvenRunnable(printer));
        evenThread.start();
    }
}
