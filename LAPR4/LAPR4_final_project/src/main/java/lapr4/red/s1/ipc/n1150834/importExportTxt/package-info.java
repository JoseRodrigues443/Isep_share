/*
 * Technical documentation regarding the user story IPC04.1- Import/Export Text.
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 * <p>
 * -In this section you should register important notes regarding your work
 * during the sprint. For instance, if you spend significant time helping a
 * colleague or if you work in more than a feature.-
 *
 * <h2>2. Requirement</h2>
 * Import/Export Text. It should be possible to export and import data to/from a
 * text file. Each line in the text file represents a row of data. In each line
 * a special character is used to separate columns. The user should be able to
 * configure this character and also define if the first line of the text file
 * should be treated as containing the header of the columns or as regular row.
 * The user should also enter a range of cells to be used as source (export) or
 * destination (import) for the operation.
 *
 * <p>
 * <b>Use Case "Import/Export Text":</b> The user selects the import option. The
 * system asks for the file to use as input. The user chooses the file. The
 * system asks for the cell range. The user provides the range. The system
 * imports the information into the selected cells.<p>
 * The user selects the export option. The system asks for the cell range. The
 * user inserts the cell range. The system asks for the file name, special
 * character and if the first line of the text file should be treated as
 * containing the header of the columns or as regular row. The user inserts the
 * necessary information. The system exports the information.
 *
 * <h2>3. Analysis</h2>
 * Since comments on cells will be supported in a new extension to cleansheets
 * we need to study how extensions are loaded by cleansheets and how they work.
 * The first sequence diagram in the section
 * <a href="../../../../overview-summary.html#arranque_da_aplicacao">Application
 * Startup</a> tells us that extensions must be subclasses of the Extension
 * abstract class and need to be registered in special files. The Extension
 * class has a method called getUIExtension that should be implemented and
 * return an instance of a class that is a subclass of UIExtension. In this
 * subclass of UIExtension there is a method (getToolBare) that returns the
 * toolbar for the extension. A sidebar is a JPanel.
 *
 *
 * <h3>First "analysis" sequence diagrams</h3>
 * The following diagrams depict a proposal for the realization of the
 * previously described use case, depicting the import and export processess. We
 * call these diagrams an "analysis" use case realization because they function
 * like a draft that we can do during analysis or early design in order to get a
 * previous approach to the design. For that reason we mark the elements of the
 * diagrams with the stereotype "analysis" that states that the element is not a
 * design element and, therefore, does not exists as such in the code of the
 * application (at least at the moment that these diagrams were created).
 * <p>
 * <img src="import_txt_extension_uc_realization1.png" alt="image">
 * <p>
 * <img src="export_txt_extension_uc_realization1.png" alt="image">
 * <p>
 *
 * From the previous diagram we see that we need to create new
 * classes/interfaces "ImportText" and "ExportText" Therefore, at this point, we
 * need to study how to add this new extention to the user interface.
 * However this problem can be fixed by stuying
 * <code>csheets.ext.simple.pacakge-info</code>
 *
 * <h3>Unit Tests</h3>
 * testfileNameCannotBeNull
 * testfileNameCannotBeEmpty
 * testfileNameCannotBeWhiteSpace
 * testInputFileHasToBeTxt
 *
 * <h2>4. Design</h2>
 *
 * <h3>4.1. UC Realization</h3>
 * To realize this user story we will need to create two classes/interfaces that
 * will be used to import and export information. We also need a subclass of
 * Extension and a subclass of UIExtension. For the user interface we need to implement two
 * JPanels, one for import and the other for export. In the code of the extension <code>csheets.ext.style</code> we can
 * find examples that illustrate how to implement these technical requirements.
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.
 * <p>
 *
 * <h3>Extension Setup</h3>
 * <img src="import_export_txt_extension_setup.png" alt="image">
 * <p>
 *
 *
 * <h3>User Imports information</h3>
 * The following diagram illustrates what happens when the user chooses the
 * import option
 * <p>
 * <img src="import_export_txt_import.png" alt="image">
 *
 * <h3>User Exports information</h3>
 * The following diagram illustrates what happens when the user chooses the
 * export option
 * <p>
 * <img src="import_export_txt_export.png" alt="image">
 *
 * <h3>4.2. Classes</h3>
 *
 * -Document the implementation with class diagrams illustrating the new and the
 * modified classes-
 *
 * <h3>4.3. Design Patterns and Best Practices</h3>
 *
 * -Describe new or existing design patterns used in the issue-
 * <p>
 * -You can also add other artifacts to document the design, for instance,
 * database models or updates to the domain model-
 *
 * @author 1150834
 */
package lapr4.red.s1.ipc.n1150834.importExportTxt;
