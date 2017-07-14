/*
 * Technical documentation regarding the user story Lang03.2 - Conditional Formatting of Ranges.
 *
 *
 * <h2>2. Requirement</h2>
 * Enable Cleansheets to apply conditional formatting to a range of cells (also in the style extension). 
 * The idea is that a single formula could applied to all the cells in the range (one at a time) in order 
 * to evaluate what style to apply. For that to be possible it is necessary to add a new special kind of 
 * variable to the formulas that represents the 'current' cell. This special variable could be named "_cell".
 * For instance, the formula "=_cell >= 10" could be associated to a range format. 
 * In this case, Cleansheets would evaluate the formula for each cell in the range and apply the 
 * formatting style in accordance with the result of the formula. In this example, all cell in the range 
 * with a value greater or equal to 10 would receive the style associated with the true result and the others 
 * the style associated with the false result. The window in the sidebar should also be updated so that it is clear if the format 
 * is for a single cell or for a range. Within the sidebar window it should also be possible to remove existing conditional 
 * style formatting.
 *
 * <p>
 * <b>Use Case "Conditional Formatting of Ranges":</b> The user selects the formatting range option.
 * The system asks for the cell range. The user gives the cell range. The system asks for a condition.
 * The user gives the condition. The system shows the formatted cells.
 *
 * <h2>3. Analysis</h2>
 * In its most basic form, this user story is an expansion of the previous user story, Lang 03.1, 
 * however in this iteration it is expected that the user is able to apply the cell formatting to more than one cell. 
 * That being said the analysis present in <code>lapr4.green.s1.lang.n1141431.conditional.formatting.pacakge-info</code> 
 * will be taken into account.
 *
 *
 * <h3>First "analysis" sequence diagrams</h3>
 * The following diagram depict a proposal for the realization of the
 * previously described use case, depicting conditional formatting of ranges. We
 * call these diagrams an "analysis" use case realization because they function
 * like a draft that we can do during analysis or early design in order to get a
 * previous approach to the design. For that reason we mark the elements of the
 * diagrams with the stereotype "analysis" that states that the element is not a
 * design element and, therefore, does not exists as such in the code of the
 * application (at least at the moment that these diagrams were created), or in this case 
 * may suffer alterations during the UC implementation.
 * <p>
 * <img src="conditional_formatting_range_realization1.png" alt="image">
 * <p>
 *
 * From the previous diagram we see that we atleast need to update the already existing code.
 * Therefore, at this point, we need to study the previous user story.
 * We also need to add new options to the sidebar, so that it will fit the new functions.
 *
 * <h3>Unit Tests</h3>
 * testRelationalOperatorCannotBeNull
 *
 * <h2>4. Design</h2>
 *
 * <h3>4.1. UC Realization</h3>
 * To realize this user story we will need to alter the already existing code, be it rewriting or simply 
 * updating it, so that it will support the formatting of one than more cells. We will need the creation of 
 * special kind variable, that can share the same syntax as a temporary variable, 
 * to represent the cell that is being altered. Finally the side bar has to be update in order to support 
 * distinction between single and multiple cell formatting and removing existing conditional style formatting.
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.
 * <p>
 *
 * <h3>Conditional Formatting of Ranges</h3>
 * <img src="conditional_formatting_range.png" alt="image">
 * <p>
 *
 *
 *
 * @author 1150834
 */
package lapr4.red.s2.lang.n1150834.conditionalFormatting;
