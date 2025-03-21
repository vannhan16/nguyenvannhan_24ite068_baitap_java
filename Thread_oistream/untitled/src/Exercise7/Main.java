package Exercise7;

public class Main {
    public static void main(String[] args) {
        String filePath = "user_input.txt";
        Thread inputThread = new KeyboardToFileThread(filePath);
        inputThread.start();
    }
}
