package Exercise9;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "char_count.txt";

        Thread countThread = new CharacterCountThread(inputFile, outputFile);
        countThread.start();
    }
}

