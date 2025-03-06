package Exercise1.Cach2;

public class EvenRunnable implements Runnable {
    private SharedPrinter printer;
    public EvenRunnable(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for(int i = 2; i <= 10; i += 2){
            printer.printEven(i);
        }
    }
}
