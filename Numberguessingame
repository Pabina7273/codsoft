import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game! 🎯");

        while (true) {
            int secretNumber = rand.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("Try to guess it!");

            while (!guessed) {
                System.out.print("Enter your guess: ");
                
                // Check if there is an integer input
                if (!sc.hasNextInt()) {
                    System.out.println("⚠️ Invalid input. Enter a number between 1 and 100.");
                    sc.next(); // skip invalid input
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("✅ Correct! You guessed it in " + attempts + " attempts.");
                    score++;
                    guessed = true;
                } else if (guess < secretNumber) {
                    System.out.println("🔼 Too low. Try again.");
                } else {
                    System.out.println("🔽 Too high. Try again.");
                }
            }

            System.out.println("⭐ Your Score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            
            // Safe reading for next input
            if (!sc.hasNext()) {
                System.out.println("\nNo input detected. Exiting.");
                break;
            }

            String choice = sc.next().trim().toLowerCase();
            if (!choice.equals("yes")) {
                System.out.println("\n🎉 Final Score: " + score + " | Thanks for playing!");
                break;
            }
        }

        sc.close();
    }
}
