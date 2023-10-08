import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	
	System.out.println("Hey, Welcome to the Lucky Seven Game!!!");
	
	int playerMoney = getPlayerMoney(scan);
	
		while (playerMoney > 0) {
	        int[] randomNumbers = generateRandomNumbers(random);
	        displayRandomNumbers(randomNumbers);
	        
	        if (isContainsSeven(randomNumbers)) {
	            int winnings = calculateWin(randomNumbers);
	            playerMoney += winnings;
	            System.out.println("You won " + winnings + "€!");
	        } else {
	            playerMoney--;
	            System.out.println("You lost 1€");
	        }
	        
	        System.out.println("Your current balance is: " + playerMoney + "€");
	        
	        if (playerMoney <= 0) {
	            System.out.println("You have currently run out of money. Game over!!!");
	            break;
	        }
	        
	        System.out.print("Do you want to play the game again? (YES / NO): ");
	        String playAgain = scan.next();
	        if (!playAgain.equalsIgnoreCase("yes")) {
	            System.out.println("Thank you for playing with us, Your final balance is: " + playerMoney + "€");
	            break;
	        }
	    }

	}
	
	public static int getPlayerMoney(Scanner scanner) {
        System.out.print("Enter the amount of money you going to spend with lucky 7: ");
        int amountOfMoney = scanner.nextInt();
        return amountOfMoney;
    }
	
	public static int[] generateRandomNumbers(Random random) {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(10) + 1; 
        }
        return numbers;
    }
	
	public static void displayRandomNumbers(int[] numbers) {
        System.out.println("Random Numbers: " + numbers[0] + " " + numbers[1] + " " + numbers[2]);
    }

	public static boolean isContainsSeven(int[] numbers) {
        for (int number : numbers) {
            if (number == 7) {
                return true;
            }
        }
        return false;
    }
	
	public static int calculateWin(int[] numbers) {
        if (numbers[0] == 7 && numbers[1] == 7 && numbers[2] == 7) {
            return 10; 
        } else if (numbers[0] == 7 || numbers[1] == 7 || numbers[2] == 7) {
            return 3; 
        } else if ((numbers[0] == 7 && numbers[1] == 7) || (numbers[0] == 7 && numbers[2] == 7) || (numbers[1] == 7 && numbers[2] == 7)) {
            return 5; 
        } else {
            return 0; 
        }
    }
}
