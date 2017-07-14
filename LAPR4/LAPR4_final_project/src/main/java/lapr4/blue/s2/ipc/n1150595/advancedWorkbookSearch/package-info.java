/**
 * Technical documentation regarding the user story Ipc02.2: Advanced Workbook Search
 * <p>
 *
 * <b></b>
 *
 *
 *
 * <h2>1. Requirement</h2>
 *
 * The sidebar window that displays the results of the search should now include
 * an area to display a preview of the contents of a workbook when the user
 * selects it (i.e., clicks on it). The preview should be based on the values of
 * the first non-empty cells of the workbook. This preview should be produced
 * without open the worksheet (at least without the worksheet been opened in the
 * user interface). The search should now be based on a pattern and not only on
 * the file name extension.
 * <p>
 *
 * <h2>2. Analysis</h2>
 *
 * The user opens the "Find Workbooks" sidebar. The user selects the directory.
 * The user clicks one time to preview the workbook. The user clicks two times
 * to open the workbook.
 *
 * <p>
 * <img src="IPC02.2_advancedWorkbookSearch_SSD.png" alt="image">
 *
 * <p>
 * <h3>Client questions<h3>
 * <p>
 * The word "pattern" is referred to in what context?
 * <p>
 * It can be considered an expression or pattern similar to a regular
 * expression. Ex: abc*.cls.
 * <p>
 * The user decides the pattern, right?
 * <p>
 * There should be opened a window were the user can write the pretendes
 * pattern? Yes.
 * <p>
 *
 * <h2>3. Tests</h2>
 *
 * The only test that will be made in this fase of the US is to search by
 * pattern, because in the previous fase were made all the tests that were
 * considered necessary.
 * <p>
 *
 * <h2>4. Design</h2>
 *
 * <b>Sequence Diagrams</b><p>
 *
 * <p>
 * <img src="IPC02.1_FindWorkbooks_Design.png" alt="image">
 *
 * <p>
 * <img src="IPC02.2_advancedWorkbookSearch_SD.png" alt="image">
 *
 * <p>
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
package lapr4.blue.s2.ipc.n1150595.advancedWorkbookSearch;
