package Exercise10;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.example.com";
        String outputFile = "downloaded_page.html";

        Thread downloadThread = new URLDownloadThread(url, outputFile);
        downloadThread.start();
    }
}