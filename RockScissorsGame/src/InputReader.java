import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/*
 * @author: Nura Abdul-Rahman
 */
public class InputReader {

	private String[] choice = { "Rock", "Spock", "Paper", "Lizard", "Scissors" };
	private String playerName;
	private int playerChoice;
	private boolean exitGame;
	private RockScissorGame play;
	private static Scanner keyboardInput;

	public InputReader() {
		playerName = "";
		playerChoice = 0;
		exitGame = false;
		play = new RockScissorGame();
		keyboardInput = new Scanner(System.in);
	}

	/*
	 * A method that displays welcome message the game rules at the beginning of the
	 * game
	 */
	public void gameIntroduction() {
		System.out.println("Welcome to Rock, Paper, Scissors, Lizard, Spock game\n");
		System.out.println("---------Below are the game rules---------\n");
		System.out.println("Scissors cuts Paper \nPaper covers Rock \nRock crushes Lizard \n"
				+ "Lizard poisons Spock \nSpock smashes Scissors \nScissors decapitates Lizard \nLizard eats Paper \n"
				+ "Paper disproves Spock \nSpock vaporizes Rock\nRock crushes Scissors\n");
		System.out.println("Please enter your name");
		playerName = keyboardInput.nextLine();
	}

	/*
	 * A method for displaying each round information and accepting user input for
	 * each round
	 */
	public void gameRounds() {
		System.out.print("Hi " + playerName + " ");
		int rounds = 0;
		Random rand = new Random();
		int input = inputValidation();
		while (!exitGame) {
			rounds++;
			System.out.println("-------ROUND " + rounds + " ---------");
			playerChoice = input;
			int computerChoice = rand.nextInt(4);
			play.game(computerChoice, playerChoice);
			System.out.println("You selected: " + choice[playerChoice] + " & the computer selected: "
					+ choice[computerChoice] + "\n");
			play.displayRoundResults();
			input = inputValidation();
		}
		if (exitGame) {
			System.out.println("-------GAME OVER --------");
			System.out.println("Total Number of Game Rounds: " + rounds + "\n");
			play.getWinner(playerName);
		}
	}

	/*
	 * A method for validating user input
	 */
	public int inputValidation() {
		int input = 0;
		boolean validInput = false;
		while (!validInput && !exitGame) {
			try {
				System.out.println(
						"Select any of following options (0-5): \nRock:0 \nSpock:1 \nPaper:2 \nLizard:3 \nScissors:4 \nExitGame:5");
				Scanner scInput = new Scanner(System.in);
				input = scInput.nextInt();
				if (input >= 0 && input < 5) {
					validInput = true;
				} else if (input == 5) {
					exitGame = true;
				} else {
					System.out.println("Please enter a valid input");
					validInput = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid number");
				validInput = false;
			} catch (NoSuchElementException e) {
				System.out.println("Please enter a valid number");
				validInput = false;
			}

		}
		return input;
	}

}
