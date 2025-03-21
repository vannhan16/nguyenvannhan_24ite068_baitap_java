package Chapter2.Exercise2_5;

public class Customer {
    private int id;
    private String name;
    private char gender;
    private int discount;

    public Customer(int id, String name, char gender, int discount){
        this.id = id;
        this.name = name;
        this.discount = discount;
    }
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public char getGender(){
        return gender;
    }
    @Override
    public String toString(){
        return "name "+ name +"(id" +id+ ")";
    }
}
