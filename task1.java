import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 10;
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int myNumber = (int)(Math.random()*100);
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A new round has started! Try to guess the number between " + minNumber + " and " + maxNumber);

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < myNumber) {
                    System.out.println("Too low!");
                } else if (guess > myNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number!");
                    totalScore += maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + myNumber);
            }

            System.out.println("Your current score: " + totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();
            playAgain = scanner.nextLine().equalsIgnoreCase("yes");
        }

        System.out.println("Game over! Your final score: " + totalScore);
        scanner.close();
    }
}

