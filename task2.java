import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // enter text or provide file
        System.out.println("Enter text or provide a file path to count words:");
        String input = scanner.nextLine();

        // Read the input text and store it in a string
        String text = "";
        if (input.toLowerCase().endsWith(".txt")) {
            try {
                File file = new File(input);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    text += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                return;
            }
        } else {
            text = input;
        }

        // Split the string into an array of words
        String[] words = text.split("\s+");

        int wordCount = 0;

        for (String word : words) {
            if (!word.isEmpty()) { 
                wordCount++;
            }
        }

        System.out.println("Total number of words: " + wordCount);

        scanner.close();
    }
}
