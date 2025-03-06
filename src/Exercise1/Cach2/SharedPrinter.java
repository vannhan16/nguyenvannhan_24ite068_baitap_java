package Exercise1.Cach2;

public class SharedPrinter {
    private boolean oddTurn = true;

    synchronized public void printOdd(int number) {
        while (!oddTurn) {
            try { wait(); } catch (InterruptedException e) { }
        }
        System.out.println("le: " + number);
        oddTurn = false;
        notify();
    }
    synchronized void printEven(int number) {
        while (!oddTurn){
            try { wait(); } catch (InterruptedException e) { }
        }
        System.out.println("chan: " + number);
        oddTurn = true;
        notify();
    }
}
