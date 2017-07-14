/**
 * Technical documentation regarding the user story Lang08.2 - Import XML.
 *
 *
 * <h2>2. Requirement</h2>
 * It should be possible to import data from an XML file (this operation is the "inverse" of the previous FI). 
 * Depending on the contents of the XML file, the data from the file can replace the contents of a workbook, 
 * a worksheet or a range of a worksheet. This option should appear in the File menu.
 *
 * 
 * <h2>3. Analysis</h2>
 *
 *
 * <h3>First "analysis" sequence diagrams</h3>
 * 
 * <p>
 * <img src="importxml_analysis.png" alt="image">
 * <p>
 * Although the diagram doesn't show any relevant information regarding the coding of this functionality,
 * there is a need to refine the previous iteration, implementing a mechanism to export the tags of the file as
 * an actual element. This way we can import the information regardless of which tags the user that wrote the file
 * used, and there is no need to bother the user to know which tags were used or ask for extra information.</p>
 *
 * <h3>Unit Tests</h3>
 *
 * <h2>4. Design</h2>
 * <p>
 * <img src="importxml_design.png" alt="image">
 * <p>
 * <h3>4.1. UC Realization</h3>
 * <p>
 * For this UC there will be no need to change the existing importXML code except for the refinement
 * stated above. Therefore, the methods needed to implement this functionality will consist of a recursive
 * search for elements of a given tag, such as workbooks or worksheets, and consequently cells and it's adresses
 * and content. The methods of loading workbooks/spreadsheets used are present in the class UIController, which has
 * access to the app itself. </p>
 *
 *
 */
package lapr4.red.s2.lang.n1150466.importXML;
