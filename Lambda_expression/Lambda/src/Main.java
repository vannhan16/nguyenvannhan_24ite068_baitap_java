public class Main{
    public static void main(String[] args){
        // dung Lambda
        Runnable r = () -> System.out.println("Helle From thread");
        new Thread(r).start();

        //Functional Interface


    }
}