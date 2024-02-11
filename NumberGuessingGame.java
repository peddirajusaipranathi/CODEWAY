import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 10; // Change this value to adjust the number of attempts allowed
        int score = 0;
        
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = minRange + random.nextInt(maxRange - minRange + 1);
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");
            
            for (int attempt = 1; attempt <= attempts; attempt++) {
                System.out.print("Attempt " + attempt + "/" + attempts + ": Enter your guess: ");
                int guess = scanner.nextInt();
                
                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            System.out.print("Your score: " + score + "\n\n");
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
