package Chapter8;

public class TestMain {
    public static void main(String[] args) {
        MyIntStack stack = new MyIntStack(2);

        System.out.println("Pushing elements: 10, 20, 30");
        stack.push(10);
        stack.push(20);
        stack.push(30); // This will trigger dynamic resizing

        System.out.println("Top element: " + stack.peek()); // 30

        System.out.println("Popping elements:");
        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
        System.out.println(stack.pop()); // 10
    }
}
