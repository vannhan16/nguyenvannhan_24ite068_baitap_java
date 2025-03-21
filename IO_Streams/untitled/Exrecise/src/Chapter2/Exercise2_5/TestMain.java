package Chapter2.Exercise2_5;

public class TestMain {
    public static void main(String[] args) {
        // Tạo đối tượng Customer
        Customer customer1 = new Customer(1, "John Doe", 'M', 10);
        System.out.println(customer1);

        // Tạo đối tượng Account
        Account account1 = new Account(1001, customer1, 500.00);
        System.out.println(account1);

        // Thử các phương thức của Account
        account1.deposit(150.00);
        System.out.println("After deposit: " + account1);

        account1.withdraw(100.00);
        System.out.println("After withdrawal: " + account1);

        // Thử rút quá số dư
        account1.withdraw(600.00);
        System.out.println("After overdraw attempt: " + account1);
    }
}

