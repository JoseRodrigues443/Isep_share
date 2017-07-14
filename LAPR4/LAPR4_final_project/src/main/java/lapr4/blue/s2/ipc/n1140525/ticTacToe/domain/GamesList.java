/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.domain;

import csheets.ui.ctrl.UIController;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MariaJoão
 */
public class GamesList {
      private final Map<String, Game> gamesBeeingPlayed;

    /**
     * Constructor. Is empty because in the beegining there hasent been any game
     * created yet
     */
    public GamesList() {
        gamesBeeingPlayed = new HashMap<>();
    }

    /**
     * Adds a new game to the list
     *
     * @param senderIp String
     * @param invitedGame Game
     */
    public void createNewGameBoard(String senderIp, Game invitedGame) {
        gamesBeeingPlayed.put(senderIp, invitedGame);

    }

    /**
     * Removes the specified game from the list
     *
     * @param senderIp String
     * @param uiCtrl UIController
     */
    public void endGame(String senderIp, UIController uiCtrl) {
        this.gamesBeeingPlayed.remove(senderIp);
    }

    /**
     * Check if user is in open game by IP.
     *
     * @param ip String
     * @return boolean
     */
    public boolean isOpenGame(String ip) {
        return this.gamesBeeingPlayed.containsKey(ip);
    }

    /**
     * Receive play from other user and update table board.
     *
     * @param board table board
     * @param ip string ip
     */
    public void receivePlay(String[][] board, String ip) {
        gamesBeeingPlayed.get(ip).updateBoard(board);

    }

    /**
     * Receive ready from other user and update table board.
     *
     * @param board table board
     * @param ip string ip
     */
    public void receiveReady(String[][] board, String ip) {
        ((Game)gamesBeeingPlayed.get(ip)).updateReadyBoard(board);
    }

    /**
     * Get game of user by IP.
     *
     * @param ip string ip
     * @return game
     */
    public Game getGame(String ip) {
        return gamesBeeingPlayed.get(ip);
    }
}
