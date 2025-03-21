package Exercise1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "input.txt";
        FileReaderThread fileReaderThread = new FileReaderThread(filePath);
        fileReaderThread.start();
    }
}

