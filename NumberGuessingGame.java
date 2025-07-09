import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = maxAttempts;
            boolean hasWon = false;

            roundsPlayed++;
            System.out.println("\nRound " + roundsPlayed + ": Guess a number between " + lowerBound + " and " + upperBound);

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");
                int guess;

                // Validate input
                if (!scanner.hasNextInt()) {
                    System.out.println("⚠️ Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                    continue;
                }

                guess = scanner.nextInt();

                if (guess < numberToGuess) {
                    System.out.println("📉 Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("📈 Too high!");
                } else {
                    System.out.println("🎉 Correct! You guessed the number.");
                    hasWon = true;
                    roundsWon++;
                    break;
                }

                attemptsLeft--;
            }

            if (!hasWon) {
                System.out.println("💥 You're out of attempts! The correct number was: " + numberToGuess);
            }

            System.out.print("\n🔁 Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        // Game summary
        System.out.println("\n🧾 Game Over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("🎯 Thanks for playing!");

        scanner.close();
    }
}
