package Exercise3;

import java.sql.SQLOutput;

public class Customer extends Thread {
    private final DiningTable table;
    public Customer(DiningTable table) {
        this.table = table;
    }
    @Override
    public void run() {
        try {
            while (true) {
                table.eat();
                Thread.sleep(3000); // an mat 3 giay
            }
        } catch (InterruptedException e) {
            System.out.println("khach hang voi ban.");
        }
    }
}

