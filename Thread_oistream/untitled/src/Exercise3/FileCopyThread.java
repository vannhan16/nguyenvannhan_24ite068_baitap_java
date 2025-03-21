package Exercise3;

import java.io.*;

class FileCopyThread extends Thread {
    private String sourceFile;
    private String destinationFile;

    public FileCopyThread(String sourceFile, String destinationFile) {
        this.sourceFile = sourceFile;
        this.destinationFile = destinationFile;
    }

    @Override
    public void run() {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Sao chép thành công từ " + sourceFile + " sang " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
