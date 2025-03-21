package Chapter6.Exercise6_6;

public class TestMain {
    public static void main(String[] args) {
        Animal cat = new Cat("Kitty");
        Animal dog = new Dog("Buddy");
        Animal bigDog = new BigDog("Max");

        cat.greets(); // Meow
        dog.greets(); // Woof
        bigDog.greets(); // Wooow

        Dog dog1 = new Dog("Charlie");
        Dog dog2 = new Dog("Rocky");
        BigDog bigDog1 = new BigDog("Zeus");
        BigDog bigDog2 = new BigDog("Thor");

        dog1.greets(dog2); // Woooof
        bigDog1.greets(dog1); // Wooooow
        bigDog1.greets(bigDog2); // Woooooooow
    }
}
