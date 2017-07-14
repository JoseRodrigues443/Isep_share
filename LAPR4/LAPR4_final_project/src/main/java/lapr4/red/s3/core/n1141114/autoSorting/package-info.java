/**
 * Technical documentation regarding the user story Core03.3: Auto-Sorting. 
 * <p>
 * 
 * <b>Requirement</b><p>
 * Statement:<p>
 * It should be possible to automatically sort a selected range of cells. <p>
 * It should be possible to visually define the selected range of cells and have visual marks to display the sorting column and order.<p>
 * It should be possible to change to sorting column by clicking on a new column. <p>
 * 
 * <b>Analysis</b><p>
 * <img src="Core03.3_AutoSorting.png" alt="image">
 * <p>
 * <b>Notes:</b><p>
 * 
 * This analysis is a very simple view of the automatically sorting. It will be covered in detail at the design
 * 
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also use case tests (e.g., like in the TDD approach). <p>
 * In addition to the required tests the next ones were implemented:
 * 
 * <b>Test1:</b> AutoSortingSelectingColumn<p>
 * There should be a simple test that should verify if selecting a column triggers a sort.<p>
 * 
 * <b>Test2:</b> ColumnOutsideRangeWontSort<p>
 * There should be a simple test that should verify if pressing a column that doesnt belong to the selected range doesn't trigger the automatic sorting mechanism. <p>
 * 
 * <b>Test3:</b> AutoSortingOnlyWhenRowIsComplete<p>
 * There should be a simple test that should verify if the sorting only happens after a row is completed.
 * 
 * <b>Design</b><p>
 * First model regarding the design.
 * 
 * <p>
 * <img src="Core03.3_AutoSorting_Design.png" alt="image"> 
 * <p>
 * 
 * @author Joao Fernandes - 1141114@isep.ipp.pt
 */
package lapr4.red.s3.core.n1141114.autoSorting;

