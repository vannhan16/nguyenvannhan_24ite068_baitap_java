package Exercise10;

import java.io.*;
import java.net.*;

class URLDownloadThread extends Thread {
    private String urlString;
    private String outputFile;

    public URLDownloadThread(String urlString, String outputFile) {
        this.urlString = urlString;
        this.outputFile = outputFile;
    }

    @Override
    public void run() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(urlString).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("Tải dữ liệu thành công vào " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

