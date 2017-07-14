/*
 * Technical documentation regarding the user story LANG08.1- ExportXML.
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 * <p>
 * -In this section you should register important notes regarding your work
 * during the sprint. For instance, if you spend significant time helping a
 * colleague or if you work in more than a feature.-
 *</p>
 *
 * <h2>2. Requirements</h2>
 *This uc allows you to export the information from a workbook, a worksheet or
 *a part of worksheet. The tags for each element will be requested from the user 
 *throught a window.
 *Only cell text will be exported and the export xml option should appear in 
 *the file menu.
 *
 * <h2>3. Analysis</h2>
 * The user selects the export xml option.
 * System asks a export type(workbook, a worksheet or a part of worksheet).
 * User choose a type of file. System asks tags for each element. User select tags.
 * System asks confirmation. User confirm.
 * <p>
 * <img src="export_xml_Analysis.png" alt="image">
 * <p>
 *
 *
 *<h2>4. Design</h2>
 *
 *<h3>4.1. UC Realization</h3>
 * <p>
 * To realize this user story we will need to create several new classes. An
 * action in the lapr4.green.s1.lang.n1150993.exportXML.ui package will be created, this will
 * be the starting point for the use case.
 * </p>
 * <p>This diagram illustrate aspects of the solution for this use case:
 * </p>
 * <p>
 * <img src="export_xml_Design.png" alt="image">
 * </p>
 *
 *
 * @author 1150993
 */
package lapr4.green.s1.lang.n1150993.exportXML;

