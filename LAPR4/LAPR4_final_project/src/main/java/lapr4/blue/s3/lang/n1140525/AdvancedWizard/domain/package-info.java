/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1140525.AdvancedWizard.domain;
/**
 * Technical documentation regarding the user story: Advanced Wizard
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
 * 1-User starts advanced wizard<p>
 * 2-System asks to select a function<p>
 * 3-User selects function<p>
 * 4-System asks for paramethers<p>
 * 5-User inserts<p>
 * 6-System validates<p>
 * 7-User asks to insert function in formula<p>
 * 8-System validates and inserts and updates result<p>
 * 9-2 to 8 happends until user builds up his formula<p>
 * 10-User asks to see generated tree-<p>
 * 11-System shows tree to user-<p>
 * 10-User confirms-<p>
 * 10-System validates and adds result to Cell-<p>
*<p>
 * Restrictions<p>
 * User can't add a funtion to formula if he doesnt replace all paramethers<p>
 * User can't add a funtion to formula in an invalid place<p>
 * User can't replace paramethers with diferent type values<p>
 * 
 * <b>Design: </b><p>
 * 
 * Sequence diagram<p>
 * <img src="Sequence_Diagram.png" alt="image">
 * 
 */