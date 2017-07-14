/**
 * Technical documentation regarding the user story Lang04.2 - Function Intermidiate Wizard
 * <p>
 *<b>1. Description</b><p>
 * 
 * The extension should provide a new sidebar window for searching the contents of the active workbook.
 * The window should be composed of two parts. The first part (upper part of the window) should contain
 * a textbox for the user to enter a regular expression to be the basis for the search. This part should also
 * contain a button to launch the search. The second part (lower part of the window) should be used to
 * display the search results (cell coordinates and value or contents). The search should include no only the
 * content of the cell (i.e., the text entered by the user) but also its value (that could have been calculated
 * by a formula).<p>
 * 
 * <b>2. Requirement</b><p>
 * Create a new extension for the sidebar;<p>
 * 
 * The upper part of the window must have the input field and the button to initiate the search;<p>
 * 
 * The lower part of the window must display the result of the search showing the address and the content or value, depending on who contains the search parameter;<p>
 *
 * <b>3. Analysis</b><p>
 *  
 * Create a new extension for the sidebar;<p>
 * 
 * The upper part of the window must have the input field and the button to initiate the search;<p>
 * 
 * The lower part of the window must display the result of the search showing the address and the content or value, depending on who contains the search parameter;<p>   
 * 
 * The regular expression is simply the word or expression that is used on the search, conclusion reached after confirmation with the client;<p>
 *
 * 
 * <b>SSD</b><p>
 * <p>
 * <img src="core_07_1_sd_analysis.png"/>
 * <p>
 * <b>4. Design</b>
 *
 *<b>Sequence Diagram</b><p>
 * <p>
 * <img src="core_07_1_design_1.png"/>
 * <img src="core_07_1_design_2.png"/>
 * <p>
 *
 * @author João Coelho
 */

package lapr4.red.s3.core.n1150825.workbookSearch.ui;