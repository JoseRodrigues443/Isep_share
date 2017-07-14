/**
 * Technical documentation regarding the user story Lang04.3: Tables and Filters
 * <p>
 *
 * <b></b>
 *
 *
 *
 * <h2>1. Requirement</h2>
 *
 * Add a new extension to support the concept of 'tables'. A table is
 * essentially a range of cells. The first row of this range of cells can be
 * used as header of the table columns (the contents of these cells become the
 * name of the columns). Once a table is defined it should be possible to filter
 * its contents by using formulas. A formula that is used as a filter of a table
 * is applied to each row of the table. If the result is true, the row is
 * visible, if the result is false, the row should become invisible. To
 * facilitate the writing of such formulas a new special variable should be
 * added to formulas. This new variable should be an array variable that
 * represents the value of the columns of the table for the current row. Lets
 * consider, for instance, that the new variable is called '_col'. For example,
 * it should be possible to use '_col[2]' to get the value of column 2 for the
 * current row. It should also be possible to use the name of the column instead
 * of the index. For instance, if the header of column 2 is 'cidade' it should
 * be possible the get the value of this column for the current row by using
 * '_col[“cidade“]'. An example of a filter for a table could be:
 * '=or(_col[“idade“]>10; _col[3]>123)". This extension should add a new side
 * bar window that should be used to edit tables and its filters.
 * <p>
 *
 * <h2>2. Analysis</h2>
 *
 * </br>
 * Tables and Filters Create new extension that supports the concept of table.
 * </br>
 * First line: header/name of the columns.
 * </br>
 * Filter the cells of the table using formulas.
 * </br>
 * Filter:
 * </br>
 * - True: visible row;
 * </br>
 * - False: invisible row.
 * </br>
 * Special variable should be added to the formulas (<b>New condition</b>):
 * </br>
 * Corresponds to an array: value of the columns of the actual row;
 * </br>
 * _col;
 * </br>
 * example:
 * </br>
 * _col[2] - obtain the value of the cell that's in the column 2 from the actual
 * row;
 * </br>
 * _col["city"] - obtain the value of the actual row where the header matches
 * "city".
 * </br>
 * FILTER
 * </br>
 * =or(_col["age"]>10; _col[3]>123) obtain the actual row cells which header
 * matches "age" and value is higher than 10 or which column is the third (3)
 * and value is higher than 123.
 * </br>
 * New side bar to edit tables and filters.
 * </br>
 * <p>
 *
 * <h3>Glossary</h3>
 *
 * </br>
 *
 * <b>Table: </b>range of cells, when a table is "created" none of the cells
 * should be empty.
 *
 * </br>
 *
 * <b>Formula: </b>filter of a table that is applied to each row of the table.
 *
 *
 * <p>
 * <img src="LANG03.3_tablesAndFilters_SSD.png" alt="image">
 *
 * <p>
 * <h3>Client questions<h3>
 * <p>
 * All the new features should be executed directly through the side bar?
 * </br>
 * Yes, all should be executed through the side bar.
 * <p>
 *
 * <h2>3. Tests</h2>
 *
 * Were made unitary tests to the main methods to verify if they were correctly
 * implemented.
 *
 * <p>
 *
 * <h2>4. Design</h2>
 *
 * <b>Sequence Diagrams</b><p>
 *
 *
 * <p>
 * <img src="LANG03.3_tablesAndFilters_SD.png" alt="image">
 *
 * <p>
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
package lapr4.blue.s3.lang.n1150595.tablesAndFilters;
