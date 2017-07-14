

/**
 * Technical documentation regarding the user story Lang03.1 - Cell
 * Conditional Formatting
 * 
 * <br/>
 *<h2>1. Description</h2>
 * 
 * Update the 'style' extension so that it can be used for the conditional
 * formatting of cells based on the result of the execution of formulas.
 * For the style of a cell to be conditional it must have an
 * associated formula and two formatting styles. One of the
 * styles is applied when the formula evaluates to true and the
 * other when it evaluates to false.
 * 
 * <br/>
 * <br/>
 * 
 * <h2>1. Requirement</h2>
 * <br/>
 *
 * <b>UC: "Cell Conditional Formatting": </b>Add a window that allows the
 * user enter a condition based on a formula.As result, the active cell 
 * the one the user has selected at the moment of execution of this UC, 
 * is painted with green if the result condition is true or red if the condition 
 * is false. The information of this condition should be placed in a sidebar.
 * <br/>
 *
 *
 * <h2>2. Analysis</h2>
 * 
 * To start uc  this we must write a number on an cell ant let the cell selected.After that we open a  window where most of the uc 
 * is made, in this window the user gets to choose a Relational Operator and then insert a number so a condition can be made. After the user confirms the operator
 * and the value the program will check if the condition is true or false and in case it's true the cell where the  first number is written will trun green otherwise it will
 * turn red. The condition the user chose will be presented on a sidebar on the right of the window.
 *
 *
 * <h2>4. Design</h2>
 *
 *<b>Sequence Diagram</b> Diagram to create sidebar:
 *
 * <img src="lang03_01_ConditionalForamtingSideBarExtension.png"/>
 * 
 * 
 * Diagram that shows how the uc works:
 * <img src="lang03_01_ConditionalForamttingCell.png"/>
 *
 *  <br/>
 * <h2>5. Coding</h2>
 * Created the classes ConditionalFormattingCellSideBarController  ,ConditionalFormattingCellSideBarExtension, UIConditionalFormattingCellSideBarExtension related 
 * to the creation and display of the sidebar, the first refresh te text displayed at the JTextArea in the side bar , the second makes appear an option in the extension sidebar
 * on the main ui to show the sidebar of this uc and the last is the one where the sidebar itself  and it's components are  created.
 * After that i created another three classes named  ConditionalFormattingCellJMenu ,ConditionalFormattingCellMenuAction and UIConditionalFormattingJFrame.
 * The first  makes that when you choose extensions and then style in the main ui you can see an option that allows to create a new  window. The second class is that option
 * named create that is displayed before the window is set visible and the third class is the creation of the window itself where all the conditions will be written and then
 * tested before change the colour of the cell.

 *
 * <br/>
 *
 * <h2>6. Tests </h2>
 *
 *Given that the main  feature  in this use case is the creation of the formula i needed to test two importatn things. The first is that the active cell wouldn't be null
 * and the second that the information that was going to be displayed in the sidebar was correct
 *In the first test i assured that the cell wasn't null and in the second i tested if the information that was result of the condition was being correctly passed through 
 * all the methods by making a set of a String and then a get and the comparison of the two.
 * 
 * 
 *
 * <br/>
 * <br/>
 *
 * @author Pedro Oliveira 1141431
 */

package lapr4.green.s1.lang.n1141431.conditional.formatting.analysys;