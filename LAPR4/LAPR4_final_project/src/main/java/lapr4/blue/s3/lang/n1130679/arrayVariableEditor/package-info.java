/**
 * Technical documentation regarding the user story LANG02.3: Arrays and Variable Editor. 
 * <p>
 * 
 * <b>Requirement</b><p>
 * Statement:<p>
 *  <p>
 * It should be possible to store global and temporary variables in an array.<p>
 * When accessing the variable only by its name, the first position of the array is returned.<p>
 * To access a specific position of the array it should be specified inside brackets. eg: "@abc[2]:=123" will set the second position of the global variable @abc to the value 123<p>
 * It should be possible to have an array with numeric and alphanumeric values.<p>
 * It should be possible to automatically refresh the value of the global variables in a sidebar once their values are edited.<p>
 * 
 * <b>Analysis</b><p>
 * <img src="SSD Lang02.03 - Arrays and Variable Editor.png" alt="image">
 * <img src="SSD Lang02.03 - Arrays and Variable Editor (Sidebar).png" alt="image">
 * 
 * <p>
 * <b>Notes:</b><p>
 * 
 * This analysis is a very simple view of how the program will act when creating the array and also how the sidebar works. 
 * 
 * To test this functionality we need to follow simple steps:<br/><br/>
 * 1st Test:<br/>
 * 1 - Select a cell<br/>
 * 2 - Insert one formula like: <br/>
 * 2.1=@temp[2]:=23 <br/>
 * 2.2 - =@temp[2]:=A1<br/>
 * 3 -Now, the value of the selected cell is the value assigned to the variable
 * at the selected index (second position).<br/>
 * <br/>
 * 
 * <b>Design</b><p>
 * First model regarding the design.
 * 
// * <img src="LANG02.3_ArrayVariable_Design.png" alt="image"> 
 * <p>
 * Design that explains how the extension functionality works, with assignment operation functionality.
 * 
 * @author Ana Pacheco - 1130679@isep.ipp.pt
 */
package lapr4.blue.s3.lang.n1130679.arrayVariableEditor;
