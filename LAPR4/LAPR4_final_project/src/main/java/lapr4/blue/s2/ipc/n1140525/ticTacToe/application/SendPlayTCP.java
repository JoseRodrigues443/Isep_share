/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.application;

import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.Game;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.TicTacToe;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.ui.TicTacToeUI;

/**
 *
 * @author MariaJoão
 */
class SendPlayTCP implements TcpClassWrapper, Serializable {
 
    /**
     * User interface controller.
     */
    private UIController uiCtr;
    /**
     * Table board of game.
     */
    private String[][] board;
    /**
     * IP of player.
     */
    private String ip;

    /**
     * Creates a new instance of Send Play TCP.
     *
     * @param board table board
     * @param ip ip player
     */
    public SendPlayTCP(String[][] board, String ip) {
        this.board = board;
        this.ip = ip;
    }

    /**
     * Set the user interface controller.
     *
     * @param uiController ui controller
     */
    public void setUIController(UIController uiController) {
        this.uiCtr = uiController;
    }

    /**
     * Process data after send play, in other words, receive play of other
     * player.
     */
    @Override
    public void processData() {

        GameCenterController ctrl = GameCenterController.getInstance();
            ctrl.setIsUpdate(true);
            ctrl.receivePlay(board, ip);
            uiCtr = ctrl.getUictrl();

            int temp = 0;

            Game g = ctrl.getGameByIP(ip);

            ctrl.setIsUpdate(false);
            if (g instanceof TicTacToe) {

                for (int i = 0; i < uiCtr.getActiveWorkbook().getSpreadsheetCount(); i++) {
                    if (uiCtr.getActiveWorkbook().getSpreadsheet(i).getTitle().equals(ip)) {
                        try {
                            uiCtr.getActiveWorkbook().getSpreadsheet(i).getCell(2, 10).setContent(TicTacToeUI.STATUS_YOUR_TURN);
                        } catch (FormulaCompilationException ex) {
                            Logger.getLogger(SendPlayTCP.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (int j = 0; j < board.length; j++) {
                            for (int k = 0; k < board[0].length; k++) {
                                try {
                                    uiCtr.getActiveWorkbook().getSpreadsheet(i).getCell(
                                            TicTacToeUI.COLUMN_START_BOARD + k, TicTacToeUI.ROW_START_BOARD + j)
                                            .setContent(board[j][k]);
                                } catch (FormulaCompilationException ex) {
                                }
                            }
                        }
                    }
                }

                if (((TicTacToe) g).checkIfLose()) {
                    JOptionPane.showMessageDialog((Frame) null, "You lose!", "Game",
                            JOptionPane.INFORMATION_MESSAGE);
                    ((TicTacToe) g).setGameOver(true);
                    try {
                        uiCtr.getActiveWorkbook().getSpreadsheet(temp).getCell(2, 10).setContent(TicTacToeUI.STATUS_LOSE);
                    } catch (FormulaCompilationException ex) {
                        Logger.getLogger(SendPlayTCP.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ctrl.endGame(ip);

                } else if (((TicTacToe) g).checkIfDraw()) {
                    JOptionPane.showMessageDialog((Frame) null, "The game tied!", "Game",
                            JOptionPane.INFORMATION_MESSAGE);
                    ((TicTacToe) g).setGameOver(true);
                    try {
                        uiCtr.getActiveWorkbook().getSpreadsheet(temp).getCell(2, 10).setContent(TicTacToeUI.STATUS_DRAW);
                    } catch (FormulaCompilationException ex) {
                        Logger.getLogger(SendPlayTCP.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ctrl.endGame(ip);
                } else {
                    ((TicTacToe) g).changeTurn();
                }
            } else {
                }
    }
    

    /**
     * Return textual description of class.
     *
     * @return string description
     */
    @Override
    public String toString() {
        return "Send Play of Game";
    }   
}
