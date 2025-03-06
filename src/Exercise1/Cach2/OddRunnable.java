package Exercise1.Cach2;

public class OddRunnable implements Runnable {
    private SharedPrinter printer;
    public OddRunnable(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2){
            printer.printOdd(i);
        }
    }
}
