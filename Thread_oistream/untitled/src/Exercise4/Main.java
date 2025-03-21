package Exercise4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        String filePath = "F:\\Java2\\Thread_oistream\\untitled\\src\\Exercise4\\input.txt";
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread readerThread = new FileReaderThread(filePath, queue);
        Thread processorThread = new WordCountThread(queue);

        readerThread.start();
        processorThread.start();
    }
}
