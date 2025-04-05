package template_method;

import java.util.Random;

public class DiceGame extends Game {

    private int[] scores;
    private int winningScore = 50;
    private int numberOfPlayers;
    private int winner = -1;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        scores = new int[numberOfPlayers];
        System.out.println("The game begins! Number of players: " + numberOfPlayers);
    }

    @Override
    public void playSingleTurn(int player) {
        int dice1 = random.nextInt(6) + 1; // 1–6
        int dice2 = random.nextInt(6) + 1; // 1–6
        int sum = dice1 + dice2;
        scores[player] += sum;

        System.out.println("Player " + (player + 1) + " rolls: " +
                dice1 + " and " + dice2 + " (total this turn: " + sum + ")");
        System.out.println("Total score of player " + (player + 1) + ": " + scores[player]);

        if (scores[player] >= winningScore && winner == -1) {
            winner = player;
        }
    }

    @Override
    public boolean endOfGame() {
        return winner != -1;
    }

    @Override
    public void displayWinner() {
        System.out.println("Winner is Player " + (winner + 1) + " with " + scores[winner] + " points! 🎉");
    }
}