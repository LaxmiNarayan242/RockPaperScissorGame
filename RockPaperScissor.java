import java.util.Random;
import java.util.Scanner;

    class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] choices = {"rock", "paper", "scissors"};
        
        while (true) {
            System.out.println("Enter your choice (rock, paper, or scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();
            
            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please choose rock, paper, or scissors.");
                continue;
            }
            
            int computerIndex = random.nextInt(3);
            String computerChoice = choices[computerIndex];
            
            System.out.println("Computer chose: " + computerChoice);
            System.out.println("You chose: " + userChoice);
            
            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);
            
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
    
    public static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }
    
    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
