/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.ui;
import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.awt.Frame;
import javax.swing.JOptionPane;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.application.GameCenterController;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.application.TicTacToeController;

/**
 *
 * @author MariaJoão
 */
public class TicTacToeUI {
    
    public static final String INVITING_PLAYER_MARK = "X";
    public static final String INVITED_PLAYER_MARK = "O";
    
    public static final String STATUS_YOUR_TURN = "Your turn!";
    public static final String STATUS_WAIT = "Wait!";
    public static final String STATUS_WIN = "You win!";
    public static final String STATUS_LOSE = "You lose!";
    public static final String STATUS_DRAW = "Game tied!";
    
    public static final int ROW_START_BOARD = 4;
    public static final int ROW_END_BOARD = 6;
    public static final int COLUMN_START_BOARD = 1;
    public static final int COLUMN_END_BOARD = 3;
    
    private String status;
    
    private String mark;
    
    private TicTacToeController controller;
    
    private Spreadsheet spreadsheet;
    
    public TicTacToeUI(UIController uiController, String ip, boolean isInvited) {
        
        mark = isInvited ? INVITED_PLAYER_MARK : INVITING_PLAYER_MARK;
        String[][] cont;        
        spreadsheet=uiController.getActiveWorkbook().getSpreadsheet(uiController.getActiveWorkbook().getSpreadsheetCount()-1);        
        addCellListeners();
        uiController.setActiveSpreadsheet(spreadsheet);
        controller = new TicTacToeController(uiController, ip, mark);
        controller.startGame();
        setStatus(isInvited ? STATUS_WAIT : STATUS_YOUR_TURN);

        
    }
    
    private void addCellListeners() {
    CellListener listener = new CellListener() {
            @Override
            public void valueChanged(Cell cell) {
                if (isInBoardRange(cell.getAddress().getRow(), cell.getAddress().getColumn())
                        && (!cell.getContent().equals("") || cell.getContent() != null)) {
                    if (!GameCenterController.getInstance().isUpdate()) {
                        if (!controller.isGameOver()) {
                            if (controller.isYourTurn()) {
                                if (cell.getContent().equalsIgnoreCase(mark)) {
                                    if (controller.validateMove(cell)) {
                                        controller.play(cell);
                                        if (controller.isWinner()) {
                                            JOptionPane.showMessageDialog((Frame) null, "You win!", "Game",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            setStatus(STATUS_WIN);
                                        } else if (controller.isDraw()) {
                                            JOptionPane.showMessageDialog((Frame) null, "The game tied!", "Game",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            setStatus(STATUS_DRAW);
                                        } else {
                                            controller.changeTurn();
                                            setStatus(STATUS_WAIT);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog((Frame) null, "Invalid move!", "Game",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        GameCenterController.getInstance().setIsUpdate(true);
                                        try {
                                            cell.setContent(controller.getGame().getBoardSize()[cell.getAddress().getRow() - ROW_START_BOARD][cell.getAddress().getColumn() - COLUMN_START_BOARD]);
                                        } catch (FormulaCompilationException ex) {
                                        }
                                        GameCenterController.getInstance().setIsUpdate(false);
                                    }
                                } else {
                                    displayError("Your mark is \"" + mark + "\"!", cell);
                                }
                            } else if (status.equals(STATUS_WAIT)) {
                                displayError("It is not your turn!", cell);
                            }
                        } else {
                            JOptionPane.showMessageDialog((Frame) null, "The game is over!", "Game",
                                    JOptionPane.INFORMATION_MESSAGE);
                            GameCenterController.getInstance().setIsUpdate(true);
                            try {
                                cell.setContent(controller.getGame().getBoardSize()[cell.getAddress().getRow() - ROW_START_BOARD][cell.getAddress().getColumn() - COLUMN_START_BOARD]);
                            } catch (FormulaCompilationException ex) {
                            }
                            GameCenterController.getInstance().setIsUpdate(false);
                            }
                    }
                }
            }

        @Override
        public void contentChanged(Cell cell) {
             if (isInBoardRange(cell.getAddress().getRow(), cell.getAddress().getColumn())
                        && (!cell.getContent().equals("") || cell.getContent() != null)) {
                    if (!GameCenterController.getInstance().isUpdate()) {
                        if (!controller.isGameOver()) {
                            if (controller.isYourTurn()) {
                                if (cell.getContent().equalsIgnoreCase(mark)) {
                                    if (controller.validateMove(cell)) {
                                        controller.play(cell);
                                        if (controller.isWinner()) {
                                            JOptionPane.showMessageDialog((Frame) null, "You win!", "Game",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            setStatus(STATUS_WIN);
                                        } else if (controller.isDraw()) {
                                            JOptionPane.showMessageDialog((Frame) null, "The game tied!", "Game",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            setStatus(STATUS_DRAW);
                                        } else {
                                            controller.changeTurn();
                                            setStatus(STATUS_WAIT);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog((Frame) null, "Invalid move!", "Game",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        GameCenterController.getInstance().setIsUpdate(true);
                                        try {
                                            cell.setContent(controller.getGame().getBoardSize()[cell.getAddress().getRow() - ROW_START_BOARD][cell.getAddress().getColumn() - COLUMN_START_BOARD]);
                                        } catch (FormulaCompilationException ex) {
                                        }
                                        GameCenterController.getInstance().setIsUpdate(false);
                                    }
                                } else {
                                    displayError("Your mark is \"" + mark + "\"!", cell);
                                }
                            } else if (status.equals(STATUS_WAIT)) {
                                displayError("It is not your turn!", cell);
                            }
                        } else {
                            JOptionPane.showMessageDialog((Frame) null, "The game is over!", "Game",
                                    JOptionPane.INFORMATION_MESSAGE);
                            GameCenterController.getInstance().setIsUpdate(true);
                            try {
                                cell.setContent(controller.getGame().getBoardSize()[cell.getAddress().getRow() - ROW_START_BOARD][cell.getAddress().getColumn() - COLUMN_START_BOARD]);
                            } catch (FormulaCompilationException ex) {
                            }
                            GameCenterController.getInstance().setIsUpdate(false);
                            }
                    }
                }
        }

        @Override
        public void dependentsChanged(Cell cell) {
             if (isInBoardRange(cell.getAddress().getRow(), cell.getAddress().getColumn())
                        && (!cell.getContent().equals("") || cell.getContent() != null)) {
                    if (!GameCenterController.getInstance().isUpdate()) {
                        if (!controller.isGameOver()) {
                            if (controller.isYourTurn()) {
                                if (cell.getContent().equalsIgnoreCase(mark)) {
                                    if (controller.validateMove(cell)) {
                                        controller.play(cell);
                                        if (controller.isWinner()) {
                                            JOptionPane.showMessageDialog((Frame) null, "You win!", "Game",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            setStatus(STATUS_WIN);
                                        } else if (controller.isDraw()) {
                                            JOptionPane.showMessageDialog((Frame) null, "The game tied!", "Game",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            setStatus(STATUS_DRAW);
                                        } else {
                                            controller.changeTurn();
                                            setStatus(STATUS_WAIT);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog((Frame) null, "Invalid move!", "Game",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        GameCenterController.getInstance().setIsUpdate(true);
                                        try {
                                            cell.setContent(controller.getGame().getBoardSize()[cell.getAddress().getRow() - ROW_START_BOARD][cell.getAddress().getColumn() - COLUMN_START_BOARD]);
                                        } catch (FormulaCompilationException ex) {
                                        }
                                        GameCenterController.getInstance().setIsUpdate(false);
                                    }
                                } else {
                                    displayError("Your mark is \"" + mark + "\"!", cell);
                                }
                            } else if (status.equals(STATUS_WAIT)) {
                                displayError("It is not your turn!", cell);
                            }
                        } else {
                            JOptionPane.showMessageDialog((Frame) null, "The game is over!", "Game",
                                    JOptionPane.INFORMATION_MESSAGE);
                            GameCenterController.getInstance().setIsUpdate(true);
                            try {
                                cell.setContent(controller.getGame().getBoardSize()[cell.getAddress().getRow() - ROW_START_BOARD][cell.getAddress().getColumn() - COLUMN_START_BOARD]);
                            } catch (FormulaCompilationException ex) {
                            }
                            GameCenterController.getInstance().setIsUpdate(false);
                            }
                    }
                }
        }

        @Override
        public void cellCleared(Cell cell) {
             if (isInBoardRange(cell.getAddress().getRow(), cell.getAddress().getColumn())
                        && (!cell.getContent().equals("") || cell.getContent() != null)) {
                    if (!GameCenterController.getInstance().isUpdate()) {
                        if (!controller.isGameOver()) {
                            if (controller.isYourTurn()) {
                                if (cell.getContent().equalsIgnoreCase(mark)) {
                                    if (controller.validateMove(cell)) {
                                        controller.play(cell);
                                        if (controller.isWinner()) {
                                            JOptionPane.showMessageDialog((Frame) null, "You win!", "Game",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            setStatus(STATUS_WIN);
                                        } else if (controller.isDraw()) {
                                            JOptionPane.showMessageDialog((Frame) null, "The game tied!", "Game",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            setStatus(STATUS_DRAW);
                                        } else {
                                            controller.changeTurn();
                                            setStatus(STATUS_WAIT);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog((Frame) null, "Invalid move!", "Game",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        GameCenterController.getInstance().setIsUpdate(true);
                                        try {
                                            cell.setContent(controller.getGame().getBoardSize()[cell.getAddress().getRow() - ROW_START_BOARD][cell.getAddress().getColumn() - COLUMN_START_BOARD]);
                                        } catch (FormulaCompilationException ex) {
                                        }
                                        GameCenterController.getInstance().setIsUpdate(false);
                                    }
                                } else {
                                    displayError("Your mark is \"" + mark + "\"!", cell);
                                }
                            } else if (status.equals(STATUS_WAIT)) {
                                displayError("It is not your turn!", cell);
                            }
                        } else {
                            JOptionPane.showMessageDialog((Frame) null, "The game is over!", "Game",
                                    JOptionPane.INFORMATION_MESSAGE);
                            GameCenterController.getInstance().setIsUpdate(true);
                            try {
                                cell.setContent(controller.getGame().getBoardSize()[cell.getAddress().getRow() - ROW_START_BOARD][cell.getAddress().getColumn() - COLUMN_START_BOARD]);
                            } catch (FormulaCompilationException ex) {
                            }
                            GameCenterController.getInstance().setIsUpdate(false);
                            }
                    }
                }
        }

        @Override
        public void cellCopied(Cell cell, Cell source) {
        }
        };        
                            
            
        spreadsheet.getCell(COLUMN_START_BOARD, ROW_START_BOARD).addCellListener(listener);
        spreadsheet.getCell(COLUMN_START_BOARD, ROW_START_BOARD + 1).addCellListener(listener);
        spreadsheet.getCell(COLUMN_START_BOARD, ROW_END_BOARD).addCellListener(listener);
        spreadsheet.getCell(COLUMN_START_BOARD + 1, ROW_START_BOARD).addCellListener(listener);
        spreadsheet.getCell(COLUMN_START_BOARD + 1, ROW_START_BOARD + 1).addCellListener(listener);
        spreadsheet.getCell(COLUMN_START_BOARD + 1, ROW_END_BOARD).addCellListener(listener);
        spreadsheet.getCell(COLUMN_END_BOARD, ROW_START_BOARD).addCellListener(listener);
        spreadsheet.getCell(COLUMN_END_BOARD, ROW_START_BOARD + 1).addCellListener(listener);
        spreadsheet.getCell(COLUMN_END_BOARD, ROW_END_BOARD).addCellListener(listener);
    }
    
    public void displayError(String message, Cell cell) {
        JOptionPane.showMessageDialog((Frame) null, message, "Game",
                JOptionPane.INFORMATION_MESSAGE);
        GameCenterController.setIsUpdate(true);
        try {
            cell.setContent("");
        } catch (FormulaCompilationException ex) {
        }
        GameCenterController.setIsUpdate(false);
    }
    
    private boolean isInBoardRange(int row, int column) {
        return (row >= ROW_START_BOARD && row <= ROW_END_BOARD)
                && (column >= COLUMN_START_BOARD && column <= COLUMN_END_BOARD);
    }
    
    private void setStatus(String status) {
        try {
            this.status = status;
            spreadsheet.getCell(2, 10).setContent(status);
        } catch (FormulaCompilationException ex) {
        }
    }  
    
}
