import javax.swing.*;
import java.io.*;
import java.util.Scanner;
public class Fileinspector {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("File chosen: " + file.getName());

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }
            }

            catch (FileNotFoundException e) {
                System.err.println("The file is not found: " + file.getPath());
            }

            System.out.println("\nSummary Report:");
            System.out.println("File Name: " + file.getName());
            System.out.println("The number of lines: " + lineCount);
            System.out.println("The number of words: " + wordCount);
            System.out.println("The number of characters: " + charCount);
        } else {
            System.out.println("No file is selected.");
        }
    }
}