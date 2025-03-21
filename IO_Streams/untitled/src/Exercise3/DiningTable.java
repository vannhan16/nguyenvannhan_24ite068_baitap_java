package Exercise3;

import java.util.LinkedList;
import java.util.Queue;

public class DiningTable {
    private final int CAPACITY = 5; // gioi han ban an chi chua toi da 5 mon an
    private final Queue<String> table = new LinkedList<>();
    // dau bep nau an
    public synchronized void cook(String dish) throws InterruptedException {
        while (table.size() == CAPACITY) {
            System.out.println("ban day! dau bep cho...");
            wait();
        }
        table.add(dish);
        System.out.println("dau bep da nau: "+dish);
        notify(); // bao cho khach hang biet co mon an moi
    }
    // khach hang an mon
    public synchronized void eat() throws InterruptedException {
        while (table.isEmpty()){
            System.out.println("ban trong! khach hang cho...");
            wait(); // cho cho den khi co mon awn tren ban
        }
        String dish = table.poll();
        System.out.println("khach hang an: "+dish);
        notify(); // bao cho dau bep bt co cho trong de nau tiep
    }
}
