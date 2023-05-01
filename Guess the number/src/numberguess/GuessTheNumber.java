package numberguess;

import java.util.Scanner;
import java.util.Random;


class Game {
	
	int compInput;
	int userInput;
	int guessno = 0;
	
	Game() {
		Random random = new Random();
		this.compInput = random.nextInt(100) + 1;
	}
	
	public boolean UserInput() {
		if ( guessno < 10 ) {
			System.out.print("Guess the number : ");
			this.userInput = GuessTheNumber.takeInput(100);
			guessno++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished...Better luck next time\n");
			return true;
		}
	}
	
	public boolean checkGuess() {
		
		if ( compInput == userInput ) {
			System.out.println("Congratulations, you guess the number " + compInput +
			" in " + guessno + " guesses");
			switch(guessno) {
				case 1:
				System.out.println("Your score is 100");
				break;
				case 2:
				System.out.println("Your score is 90");
				break;
				case 3:
				System.out.println("Your score is 80");
				break;
				case 4:
				System.out.println("Your score is 70");
				break;
				case 5:
				System.out.println("Your score is 60");
				break;
				case 6:
				System.out.println("Your score is 50");
				break;
				case 7:
				System.out.println("Your score is 40");
				break;
				case 8:
				System.out.println("Your score is 30");
				break;
				case 9:
				System.out.println("Your score is 20");
				break;
				case 10:
				System.out.println("Your score is 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( guessno < 10 && userInput > compInput ) {
			if ( userInput - compInput > 10 ) {
				System.out.println("Too High");
			}
			else {
				System.out.println("Little High");
			}
		}
		else if ( guessno < 10 && userInput < compInput) {
			if ( compInput - userInput > 10 ) {
				System.out.println("Too low");
			}
			else {
				System.out.println("Little low");
			}
		}
		return false;
	}
}

public class GuessTheNumber {

	public static int takeInput(int maxnum) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > maxnum || input < 1 ) {
					System.out.println("Choose the number between 1 to " + maxnum);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}

	public static void main(String[] args) {

		System.out.println("Enter your choice.Press:");
		System.out.println("1. Start the Game \n2. Exit");
		System.out.print("Enter your choice : ");
		int ch = takeInput(2);
		int nextRound = 1;
		int Roundno = 0;
		
		if ( ch == 1 ) {
			
			while ( nextRound == 1 ) {
				Game game = new Game();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound " + ++Roundno + " starts...");
				
				while ( !isMatched && !isLimitCross) {
					isLimitCross = game.UserInput();
					isMatched = game.checkGuess();
				}
				System.out.println("1. Next Round \n2. Exit");
				System.out.println("Enter your choice : ");
				nextRound = takeInput(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}
