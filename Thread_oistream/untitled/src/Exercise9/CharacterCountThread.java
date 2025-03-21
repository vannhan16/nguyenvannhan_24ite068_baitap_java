package Exercise9;

import java.io.*;

class CharacterCountThread extends Thread {
    private String inputFile;
    private String outputFile;

    public CharacterCountThread(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int charCount = 0;
            int ch;
            while ((ch = reader.read()) != -1) {
                charCount++;
            }

            writer.write("Số ký tự trong file: " + charCount);
            System.out.println("Kết quả đã được ghi vào " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
