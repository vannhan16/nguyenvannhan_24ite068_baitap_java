package Exercise2;

public class CountdownThread extends Thread {

    @Override
    public void run(){
        for (int i = 10; i >= 0; i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        }
    }
    public static void main(String[] args) {
        CountdownThread countdown = new CountdownThread();
        countdown.start();
    }
}

