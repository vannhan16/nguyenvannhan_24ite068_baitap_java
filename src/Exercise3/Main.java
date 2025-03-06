package Exercise3;

public class Main {
    public static void main(String[] args) {
        DiningTable table = new DiningTable();

        Chef chef = new Chef(table);
        Customer customer = new Customer(table);

        chef.start();
        customer.start();
    }
}
