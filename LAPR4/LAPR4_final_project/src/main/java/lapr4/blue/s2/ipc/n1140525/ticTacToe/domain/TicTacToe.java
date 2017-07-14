/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.domain;
import java.io.Serializable;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.ui.TicTacToeUI;

/**
 *
 * @author MariaJoão
 */


/**
 * Class with logic of tic tac toe game.
 *
 * @author rubenamorim
 */
public class TicTacToe implements Game, Serializable {

    /**
     * Name of game.
     */
    private final static String GAME_NAME = "Tic Tac Toe";
    /**
     * Size of board of game.
     */
    private final static int BOARD_SIZE = 3;

    /**
     * Table of game.
     */
    private String[][] table;
    /**
     * Player mark of game.
     */
    private String mark;

    /**
     * Variable to "say" if is my turn to play or not.
     */
    private boolean yourTurn;

    /**
     * Variable to "say" if game is over or not.
     */
    private boolean gameOver;

    /**
     * Creates a new instance of tic tac toe game.
     *
     * @param mark
     */
    public TicTacToe(String mark) {
        table = new String[BOARD_SIZE][BOARD_SIZE];
        this.mark = mark;
        yourTurn = mark.equalsIgnoreCase("X");
        startTable();
    }

    /**
     * Start table to empty.
     */
    private void startTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = "";
            }
        }
    }

    /**
     * Returns the name of the game.
     *
     * @return game name
     */
    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    /**
     * Returns the size of the board.
     *
     * @return String[][] board
     */
    @Override
    public String[][] getBoardSize() {
        return table;
    }

    /**
     * Check if is legal play in specific position of board.
     *
     * @param row row number
     * @param column column number
     * @return boolean
     */
    public boolean checkIfLegal(int row, int column) {
        if ((row >= 0 && row <= 2) && (column >= 0 && column <= 2)) {
            if ("".equals(table[row][column])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Set a move of a player.
     *
     * @param player mark
     * @param row row number
     * @param column column number
     */
    public void play(String player, int row, int column) {
        table[row][column] = player;
    }

    /**
     * Check if player win the game.
     *
     * @return boolean
     */
    public boolean checkIfWinner() {
        if (table[0][0].equalsIgnoreCase(table[1][0]) && table[1][0].equalsIgnoreCase(table[2][0])
                && (table[0][0].equalsIgnoreCase(mark))) {
            //coluna esquerda
            return true;
        } else if (table[0][1].equalsIgnoreCase(table[1][1]) && table[1][1].equalsIgnoreCase(table[2][1])
                && (table[0][1].equalsIgnoreCase(mark))) {
            //coluna meio
            return true;
        } else if (table[0][2].equalsIgnoreCase(table[1][2]) && table[1][2].equalsIgnoreCase(table[2][2])
                && (table[0][2].equalsIgnoreCase(mark))) {
            //coluna direita
            return true;
        } else if (table[0][0].equalsIgnoreCase(table[0][1]) && table[0][1].equalsIgnoreCase(table[0][2])
                && (table[0][0].equalsIgnoreCase(mark))) {
            //linha cima
            return true;
        } else if (table[1][0].equalsIgnoreCase(table[1][1]) && table[1][1].equalsIgnoreCase(table[1][2])
                && (table[1][0].equalsIgnoreCase(mark))) {
            //linha meio
            return true;
        } else if (table[2][0].equalsIgnoreCase(table[2][1]) && table[2][1].equalsIgnoreCase(table[2][2])
                && (table[2][0].equalsIgnoreCase(mark))) {
            //linha baixo
            return true;
        } else if (table[0][0].equalsIgnoreCase(table[1][1]) && table[1][1].equalsIgnoreCase(table[2][2])
                && (table[0][0].equalsIgnoreCase(mark))) {
            //diagonal 1
            return true;
        } else if (table[2][0].equalsIgnoreCase(table[1][1]) && table[1][1].equalsIgnoreCase(table[0][2])
                && (table[2][0].equalsIgnoreCase(mark))) {
            //diagonal 2
            return true;
        }
        return false;
    }

    /**
     * Check if player lose the game.
     *
     * @return boolean
     */
    public boolean checkIfLose() {
        String oppenetMark = mark.equalsIgnoreCase("X") ? "O" : "X";
        if (table[0][0].equalsIgnoreCase(table[1][0]) && table[1][0].equalsIgnoreCase(table[2][0])
                && (table[0][0].equalsIgnoreCase(oppenetMark))) {
            return true;
        } else if (table[0][1].equalsIgnoreCase(table[1][1]) && table[1][1].equalsIgnoreCase(table[2][1])
                && (table[0][1].equalsIgnoreCase(oppenetMark))) {
            return true;
        } else if (table[0][2].equalsIgnoreCase(table[1][2]) && table[1][2].equalsIgnoreCase(table[2][2])
                && (table[0][2].equalsIgnoreCase(oppenetMark))) {
            return true;
        } else if (table[0][0].equalsIgnoreCase(table[0][1]) && table[0][1].equalsIgnoreCase(table[0][2])
                && (table[0][0].equalsIgnoreCase(oppenetMark))) {
            return true;
        } else if (table[1][0].equalsIgnoreCase(table[1][1]) && table[1][1].equalsIgnoreCase(table[1][2])
                && (table[1][0].equalsIgnoreCase(oppenetMark))) {
            return true;
        } else if (table[2][0].equalsIgnoreCase(table[2][1]) && table[2][1].equalsIgnoreCase(table[2][2])
                && (table[2][0].equalsIgnoreCase(oppenetMark))) {
            return true;
        } else if (table[0][0].equalsIgnoreCase(table[1][1]) && table[1][1].equalsIgnoreCase(table[2][2])
                && (table[0][0].equalsIgnoreCase(oppenetMark))) {
            return true;
        } else if (table[2][0].equalsIgnoreCase(table[1][1]) && table[1][1].equalsIgnoreCase(table[0][2])
                && (table[2][0].equalsIgnoreCase(oppenetMark))) {
            return true;
        }
        return false;
    }

    /**
     * Check if game ends with draw.
     *
     * @return boolean
     */
    public boolean checkIfDraw() {
        if (!checkIfWinner()) {
            for (int i = 0; i < table.length; i++) {
                for (int p = 0; p < table[0].length; p++) {
                    if ("".equals(table[i][p])) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Change the turn to inverse.
     */
    public void changeTurn() {
        yourTurn = !isYourTurn();
    }

    /**
     * Get the turn.
     *
     * @return the yourTurn
     */
    public boolean isYourTurn() {
        return yourTurn;
    }

    /**
     * Update board of game.
     *
     * @param board string[][]
     */
    @Override
    public void updateBoard(String[][] board) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = board[i][j];
            }
        }
    }

    /**
     * @return the gameOver
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * @param gameOver the gameOver to set
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public void updateReadyBoard(String[][] board) {
    }

}

