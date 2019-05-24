
public class RockScissorGame {

	private int playerWins, computerWins, numPlayerDraws, numComputerDraws, playerLoss, computerLoss, playerRoundStatus;

	public RockScissorGame() {
		playerWins = 0;
		computerWins = 0;
		numPlayerDraws = 0;
		numComputerDraws = 0;
		playerLoss = 0;
		computerLoss = 0;
	}

	/*
	 * A method for determining the winner of the overal game.
	 */
	public void getWinner(String player) {

		if (playerWins > computerWins) {
			System.out.println("Congratulations " + player + " on your win!! You defeated the computer with "
					+ playerWins + " points\n");
		} else if (playerWins == computerWins) {
			System.out.println("It was a tie!!");
		} else {
			System.out.println("Sorry " + player + " you lost to the computer. The computer won with " + computerWins
					+ " points\n");
		}
		System.out.println("-----OVERALL GAME STATUS------\n");
		gameStatus();
	}

	/*
	 * A method that determines the outcome of a round given player choice and
	 * computer choice
	 */
	public void game(int computerChoice, int playerChoice) {

		int difference = (playerChoice - computerChoice) % 5;

		if (difference == 0) {
			numPlayerDraws++;
			numComputerDraws++;
			playerRoundStatus = 0;
		} else if (difference == 1 || difference == 2) {
			playerWins++;
			computerLoss++;
			playerRoundStatus = 1;

		} else {
			computerWins++;
			playerLoss++;
			playerRoundStatus = 2;
		}
	}

	/*
	 * A method that displays the results for each player
	 */
	public void gameStatus() {
		System.out.println("------Your results-------\nWins: " + playerWins + "\nLoss: " + playerLoss + "\nDraws: "
				+ numPlayerDraws);
		System.out.println("------Computer results-------" + "\nComputerWins: " + computerWins + "\nComputerLoss: "
				+ computerLoss + "\nDraws: " + numComputerDraws + "\n");
	}

	/*
	 * A method that displays the results of each round played
	 */
	public void displayRoundResults() {
		if (playerRoundStatus == 1) {
			System.out.println("You won this round:");
		} else if (playerRoundStatus == 2) {
			System.out.println("You Loss this round:");
		} else {
			System.out.println("It was a tie:");
		}
		gameStatus();
	}

}
