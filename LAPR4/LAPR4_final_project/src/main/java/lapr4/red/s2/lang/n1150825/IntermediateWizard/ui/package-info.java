/**
 * Technical documentation regarding the user story Lang04.2 - Function Intermidiate Wizard
 * <p>
 *<b>1. Description</b><p>
 * 
 * The wizard window should display an edit box for each parameter of the selected function. The user
 * should use these edit boxes to enter the values for each parameter of the function. As the user enters the
 * values the wizard should display (in a new region of the window) the result of the execution of the formula
 * or a message explaining the problem. The function list should now include also the operators as well as
 * the functions that are dynamically loaded from java.lang.Math. The wizard should be now launched
 * from an icon or button located in the formula bar, between the label of the active cell and the edit box of
 * the formula/value of the current cell. The menu option should be removed.<p>
 * 
 * <b>2. Requirement</b><p>
 * The list presented to the user should contain the functions from Math<p>
 * There should be as many edit boxes as there are parameters<p>
 * There should be a warning showing either the value of the function or the error<p>
 * It should be activated, or called, through a button, or icon, between the cell 
 * address box and the cell editor<p>
 * 
 * 
 * <b>3. Analysis</b><p>
 *  
 * It should keep the previous requests and it now needs to have edit boxes for the
 * parameters, the function list sshould now have the functions from the java class Math 
 * and besides these there should also be a warning, or message, showing the value of 
 * the function or inform if there are parameters missing or even if the arguments are 
 * invalid.<p>
 * It should also be launched from a button or icon present in the formula bar, between the label of the active cell and the edit box of
 * the formula.<p>
 *
 * 
 * <b>SSD</b><p>
 * <p>
 * <img src="intermidiate_wizard_analysis.png"/>
 * <p>
 * <b>4. Design</b>
 *
 *<b>Sequence Diagram</b><p>
 * <p>
 * <img src="intermidiate_wizard_design.png"/>
 * <p>
 *
 * @author João Coelho
 */

package lapr4.red.s2.lang.n1150825.IntermediateWizard.ui;