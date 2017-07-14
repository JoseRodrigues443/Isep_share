/**
 * Technical documentation regarding the user story Core03.2) Sort Range of Cells
 *
 * <br/>
 * <h2>1.Description</h2>
 * <p>
 *
 * Sort a range of cells. A range of cells is a rectangular area delimited by an
 * upper left corner and a lower right corner. The sorting is based on a column
 * of the range. It should be possible to select the order: ascending or
 * descending. Interaction with the user should be based on a popup menu. It
 * should be possible to sort data of the following types: numeric, text or
 * date.
 *
 * <p/>
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * <p>
 * <br/>
 *
 * <b>UC: "Sort Range of Cells": </b>
 * Add a window where the user introduces the number of columns that will be
 * sorted(in case the user selects more then one column). Add new validations so
 * that dates can also be sorted.
 * <p/>
 * <br/>
 *
 *
 * <h2>2. Analysis</h2>
 * <p>
 * To start uc this the user must go to the extensions and choose the option
 * sort column v2 that when pressed it displays the option to sort in an
 * ascending or descending order. After the user chooses one option it will make
 * a window visible that asks for the range. Then the user insert the range for
 * example 1-1 ,2-2 (line 1 column 1 to line 2 column 2 ) and inserts the
 * confirmation wich will make columns being sorted accordingly with the
 * criteria chosen
 *
 * <p/>
 * <h2>4. Design</h2>
 * <p>
 * <b>Sequence Diagram</b>
 *
 *
 *
 * <img src="CORE03.2_sortColumnRange_SD"/>
 *
 *
 *
 *
 * <br/>
 * <p/>
 * <h2>5. Coding</h2>
 * <p>
 * Created the classe SortCellsExtension responsible for making the "Cells Sort
 * v2" option appears in the extensions, the class SortCellsMenu that makes that
 * when you click on the previous option two pop menus appear and show the
 * options ascending/descending order, AscendingSortRangeCellsAction and
 * DescendingSortRangeCellsAction that sets visible upon clicking the window
 * SortRangeUI responsible to get from the user the chosen range and sends it to
 * the SortColumnController to call the methods responsible for getting the
 * cells in the chosen range and then the sorting. The method that returns a
 * matrix with the cells within a chosen range was made based on the method of
 * another person of the class Tiago 1150834. are stored in the Sort class.
 *
 *
 * <p/>
 *
 *
 * <br/>
 *
 * <h2>6. Tests </h2>
 * To assure the full functionality of this feature there were made some tests
 * to see the efficiency of the uc. One of the test is to see if the
 * ascendigSortRange is working and the other for the descending and if they are
 * successful then this uc can be accepted.
 *
 *
 *
 *
 * <br/>
 * <br/>
 *
 * @author Pedro Oliveira 1141431
 */
package lapr4.green.s2.core.n1141431.sortColumnRange;
