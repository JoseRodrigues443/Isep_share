/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.domain;

import java.io.Serializable;

/**
 *
 * @author MariaJoão
 */
public class GameBoard implements Serializable {

    /**
     * Instance of game.
     */
    private Game game;
    /**
     * Table board of game.
     */
    private String[][] boardInfo;

    /**
     * Creates a new instance of game board.
     *
     * @param invitedGame game
     */
    public GameBoard(Game invitedGame) {
        this.game = invitedGame;
        this.boardInfo = game.getBoardSize();
    }

    /**
     * Updates the board state with the new state recived from the opponent play
     *
     * @param newBoard String[][]
     */
    public void setBoard(String[][] newBoard) {
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[0].length; j++) {
                boardInfo[i][j] = newBoard[i][j];
            }
        }
    }

    /**
     * Returns the board state
     *
     * @return String[][]
     */
    public String[][] getBoard() {
        return boardInfo;
    }

    /**
     * Get game of board.
     *
     * @return game
     */
    public Game getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(Game game) {
        this.game = game;
        this.boardInfo = game.getBoardSize();
    }

}
