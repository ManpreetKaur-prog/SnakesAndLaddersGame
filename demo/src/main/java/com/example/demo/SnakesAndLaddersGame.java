package com.example.demo;

import com.example.demo.Player;

import java.util.*;

public class SnakesAndLaddersGame {
    private static final int BOARD_SIZE = 100;
    private Player[] players;
    private int currentPlayerIndex;
    private int[] board;

    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player[] players = {player1, player2};

        SnakesAndLaddersGame game = new SnakesAndLaddersGame(players);
        game.playGame();
    }

    public SnakesAndLaddersGame(Player[] players) {
        this.players = players;
        this.currentPlayerIndex = 0;
        this.board = new int[BOARD_SIZE + 1];
        initializeBoard();
    }

        private void initializeBoard() {
            // Initialize all positions to -1, indicating no snake or ladder
            Arrays.fill(board, -1);

            // Define snakes and ladders on the board
            board[16] = 6;
            board[47] = 26;
            board[49] = 11;
            board[56] = 53;
            board[62] = 19;
            board[64] = 60;
            board[87] = 24;
            board[93] = 73;
            board[95] = 75;
            board[98] = 78;
            // Add ladders
            board[1] = 38;
            board[4] = 14;
            board[9] = 31;
            board[21] = 42;
            board[28] = 84;
            board[36] = 44;
            board[51] = 67;
            board[71] = 91;
            board[80] = 100;
        }
    public void playGame() {
        while (true) {
            Player currentPlayer = players[currentPlayerIndex];
            int diceRoll = rollDice();
            int newPosition = currentPlayer.getPosition() + diceRoll;

            if (newPosition <= BOARD_SIZE) {
                newPosition = board[newPosition] != -1 ? board[newPosition] : newPosition;
                currentPlayer.setPosition(newPosition);
                System.out.println(currentPlayer.getName() + " rolled a " + diceRoll + " and is now at position " + newPosition);

                if (newPosition == BOARD_SIZE) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                }

                currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            }
        }
    }
    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1; // Roll a 6-sided die
    }





}