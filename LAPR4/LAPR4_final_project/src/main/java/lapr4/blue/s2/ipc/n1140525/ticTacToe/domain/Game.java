/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.domain;

/**
 *
 * @author MariaJoão
 */
public interface Game {
     /**
     * Returns the name of the game.
     *
     * @return GameName
     */
    String getGameName();

    /**
     * Returns the size of the board.
     *
     * @return String[][]
     */
    public String[][] getBoardSize();

    /**
     * Update board of game.
     *
     * @param board new board
     */
    public void updateBoard(String[][] board);

    public void updateReadyBoard(String[][] board);


}
