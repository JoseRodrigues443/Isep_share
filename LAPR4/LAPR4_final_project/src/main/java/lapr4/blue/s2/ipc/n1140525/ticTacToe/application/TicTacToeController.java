/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.application;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.io.Serializable;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.TicTacToe;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.ui.TicTacToeUI;

/**
 *
 * @author MariaJoão
 */
public class TicTacToeController implements Serializable {

    /**
     * User interface controller.
     */
    private UIController uiController;

    /**
     * Instance of tic tac toe game.
     */
    private TicTacToe game;

    /**
     * IP of opponent.
     */
    private String ip;

    /**
     * Create instace of tic tac toe controller.
     *
     * @param uiController ui controller
     * @param ip ip opponent
     * @param mark
     */
    public TicTacToeController(UIController uiController, String ip, String mark) {
        this.uiController = uiController;
        this.ip = ip;
        game = new TicTacToe(mark);

        GameCenterController.getInstance().getGamesBeeingPlayed().createNewGameBoard(ip, game);
    }

    /**
     * Start the game.
     *
     */
    public void startGame() {
        game.setGameOver(false);
    }

    /**
     * Validate if move is legal or not.
     *
     * @param cell cell
     * @return boolean
     */
    public boolean validateMove(Cell cell) {
        if (!game.isGameOver() && game.isYourTurn()) {
           return getGame().checkIfLegal(cell.getAddress().getRow() - TicTacToeUI.ROW_START_BOARD, cell.getAddress().getColumn() - TicTacToeUI.COLUMN_START_BOARD);
        }
        return false;
    }

    /**
     *
     *
     * @param cell cell
     * @return boolean
     */
    public boolean play(Cell cell) {
        if (!game.isGameOver() && game.isYourTurn()) {
            GameCenterController ctr = GameCenterController.getInstance();
            ctr.sendPlay(ip, this);
            getGame().play(cell.getContent(), cell.getAddress().getRow() - TicTacToeUI.ROW_START_BOARD, cell.getAddress().getColumn() - TicTacToeUI.COLUMN_START_BOARD);
            return true;
        }
        return false;
    }

    /**
     * Check if player win the game.
     *
     * @return boolean
     */
    public boolean isWinner() {
        if (getGame().checkIfWinner()) {
            game.setGameOver(true);
            return true;
        }
        return false;

    }

    /**
     * Check if game ends with draw.
     *
     * @return boolean
     */
    public boolean isDraw() {
        if (getGame().checkIfDraw()) {
            game.setGameOver(true);
            return true;
        }
        return false;

    }

    /**
     * Check if game ends with lose.
     *
     * @return boolean
     */
    public boolean isLose() {
        if (getGame().checkIfLose()) {
            game.setGameOver(true);
            return true;
        }
        return false;
    }

    /**
     * Return if game is game over or not.
     *
     * @return boolean
     */
    public boolean isGameOver() {
        if (game.isGameOver()) {
          //  GameCenterController;
            return true;
        }
        return false;
    }

    /**
     * Change the turn to inverse.
     */
    public void changeTurn() {
        game.changeTurn();
    }

    /**
     * Set the game.
     *
     * @param game the game to set
     */
    public void setGame(TicTacToe game) {
        this.game = game;
    }

    /**
     * Get the game.
     *
     * @return the game
     */
    public TicTacToe getGame() {
        return game;
    }

    /**
     * @return the uiController
     */
    public UIController getUiController() {
        return uiController;
    }

    /**
     * Get the turn.
     *
     * @return the yourTurn
     */
    public boolean isYourTurn() {
        return game.isYourTurn();
    }
}

