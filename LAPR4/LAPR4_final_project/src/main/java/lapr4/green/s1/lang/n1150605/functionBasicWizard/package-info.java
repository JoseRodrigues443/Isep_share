/**
 * Technical documentation regarding the user story Lang04.1 - Insert Function Basic Wizard
 * <br/>
 *<h2>1. Description</h2>
 * 
 * Cleansheets should have a menu option to launch a wizard to aid the user in calling functions in formulas.
This new window should display a list of possible functions. The construction of this list should be made
dynamically based on the properties file and self-description of the functions. When a function is selected
in the list its syntax should be displayed in a edit box. The "syntax" should include the name of the
functions and its parameters. For example, for the factorial function, that only has one parameter, the
following text should be displayed in the edit box "= FACT(Number)". The window should also contain
an area to display a text describing the selected function (i.e., help text). The window should have an
"Apply" and a "Cancel" button. If the user selects the "Apply" button the text of the syntax of the
function should be written in the formula bar
 * <br/>
 * <br/>
 * 
 * <h2>2. Requirement</h2>
 * This use case allows the user to choose
 * a function of many available, in order to modify the value of the active cell.
 * 
 * <br/>
 * <br/>
 * 
 * <h2>3. Analysis</h2>
 * 
 * Initially, the user is presented with a list of all available functions in the system. 
 * Then, he has to choose one. As soon as there is a selected function, he is presented 
 * with selected function's syntax in a edit box(e.g "=FACT(Number)") and a brief description. 
 * After that, he can enter the values ​​for the function parameters in the edit box. Finally, 
 * he is able to proceed selecting "Apply"
 * button, so that the active cell value is modified. Or he can also get out of the window selecting "Cancel" button.
 *
 * <br/>
 * <br/>
 * 
 * <h2>SSD</h2>
 * <img src="basic_wizard_analysis.png"/>
 * 
 * <h2>4. Design</h2>
 *
 *<h2>Sequence Diagram</h2>
 *
 * <img src="basic_wizard_design.png"/>
 * 
 *
 *  <br/>
 * <h2>5. Coding</h2>
 *
 *
 * <br/>
 *
 * <h2>6. Tests </h2>
 *
 * 
 *
 * 
 * 
 *
 * <br/>
 * <br/>
 *
 * @author Miguel Morgado 1150605
 */

package lapr4.green.s1.lang.n1150605.functionBasicWizard;