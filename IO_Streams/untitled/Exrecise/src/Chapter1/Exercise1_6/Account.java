package Chapter1.Exercise1_6;

public class Account {
    private String id;
    private String name;
    private int balance;

    public Account(String id, String name){
        this.id = id;
        this.name = name;
        this.balance = 0;
    }
    public Account(String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public String getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getBalance(){
        return balance;
    }
    // nap tien vao tai khoan
    public int credit(int amount) {
        balance += amount;
        return balance;
    }
    // rut tien neu so du du
    public int debit(int amount) {
        if (amount <= balance){
            balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }
    // chuyen tien cho tai khoan khac neu so du du
    public int transferTo(Account another, int amount) {
        if (amount <= balance) {
            balance -= amount;
            another.credit(amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }
    @Override
    public String toString() {
        return "Account[id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }




}
