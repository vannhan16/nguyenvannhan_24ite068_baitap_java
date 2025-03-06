package Exercise1.Cach1;

public class OddThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i+= 2){
            System.out.println("So lẻ: " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}
