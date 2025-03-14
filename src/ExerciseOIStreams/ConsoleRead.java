package ExerciseOIStreams;

import java.io.*;
public class ConsoleRead {
    public static void main(String[] args) {
        try {
            File file = new File ("file.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileReader = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader);

            String line;
            while (!(line = bufferedReader.readLine()).equals("Exit")) {
                bufferedWriter.write(line);
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
