package Chapter4.Exercise4_6;

public class TestMain {
    public static void main(String[] args) {
        Animal a = new Animal("Generic Animal");
        System.out.println(a);

        Mammal m = new Mammal("Generic Mammal");
        System.out.println(m);

        Cat c = new Cat("Kitty");
        System.out.println(c);
        c.greets();

        Dog d1 = new Dog("Buddy");
        Dog d2 = new Dog("Charlie");
        System.out.println(d1);
        d1.greets();
        d1.greets(d2);
    }
}
