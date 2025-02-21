package Chapter4.Exercise4_2;

public class TestMain {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", "123 Main St", "Computer Science", 2, 2000.5);
        System.out.println(s1);

        Staff staff1 = new Staff("Bob", "456 Park Ave", "ABC School", 3500.75);
        System.out.println(staff1);
    }
}
