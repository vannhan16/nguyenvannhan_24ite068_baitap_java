package Chapter6.Exercise6_6;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Meow");
    }
}
