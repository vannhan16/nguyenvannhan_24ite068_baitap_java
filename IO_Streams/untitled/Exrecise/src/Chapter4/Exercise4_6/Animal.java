package Chapter4.Exercise4_6;

public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal[name=" + name + "]";
    }
}

class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Mammal[" + super.toString() + "]";
    }
}
