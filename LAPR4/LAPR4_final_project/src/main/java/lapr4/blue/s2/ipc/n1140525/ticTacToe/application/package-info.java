/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Technical documentation regarding the user story IPC07.2: Tic-Tac-Toe
 * <p>
 * <p>
 * 
 * <b>Requirement</b>
 * Statement:<p>
 * The tic-tac-toe game should be implemented. The game should be implemented as described in https://en.wikipedia.org/wiki/Tic-tac-toe.<p>
 * The board of the game should be displayed in a range of cells. <p>
 * Each cell should correspond to a position in the game board.<p>
 * Moves are performed by placing an 'X' or an 'O' in the cells.<p>
 * The user should only be able to perform a move when its his turn.<p>
 * Boards are updated on both instances. <p>
 * Cleansheets should automatically verify and enforce the rules of the game.<p>
 * 
 * <b>Analisys</b><p>
 * <p>
 * Sequence of Events<p>
 * User (player 1) invites another user that is online (player 2) to play a game<p>
 * System asks player 1 to chose the game he wants to play<p>
 * Player 1 choses tic tac toe to play<p>
 * System sends invite to player 2<p>
 * Player 2 acepts invite<p>
 * System opens new spreadsheet for both player 1 and 2<p>
 * System asks player 1 to chose range of cells for board of game<p>
 * Player 1 selects cells<p>
 * Player 1 and 2 take turns to play<p>
 * When the game is over, system informs both players of the final result<p>
 *<p>
 * Restrictions<p>
 * Range of cells selected must be 3x3<p>
 * Board must be blocked for player if it's not the players turn<p>
 * Player cannot play in cell that has already been played at<p>
 * Range is chosen when player selects first cell of the board (first row and first column of desired board)<p>
 * 
 * <b>Design: </b><p>
 * 
 * Sequence diagram<p>
 * <img src="Sequence_Diagram.png" alt="image">
 * 
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.application;
