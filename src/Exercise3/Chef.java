package Exercise3;

public class Chef extends Thread{
    private final DiningTable table;
    private int dishNumber = 1;

    public Chef(DiningTable table) {
        this.table = table;
    }
    @Override
    public void run() {
        try{
            while (true){
                table.cook("mmon an "+ dishNumber++);
                Thread.sleep(2000); // nau mat 2 giay
            }
        } catch(InterruptedException e){
            System.out.println("dau bep dung lam viec.");
        }
    }
}
