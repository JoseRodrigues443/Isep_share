/**
 * Technical documentation regarding the user story IPC04.3: Import/Export Data.
 * 
 * <h2>1. Notes</h2>
 * 
 * <h2>2. Use case description:</h2>
 * It should be possible to export and import data to/from a table in a database. Each row in the table corresponds to a row in Cleansheets and each column in the table corresponds to a column in Cleansheets. The user should enter a range of cells to be used as source (export) or destination (import) for the operation. The first row of the range should be treated as a header. Each column in the first row is used as the name of the corresponding database column. This feature should be based in jdbc (Java Database Connectivity). The user should specify a database connection to be used and the name of the table.
 * 
 * <h2>2. Requirement</h2>
 * The user select a range of cells and export information of cells to a specific table
 * in database (name of table and name of database are choosed by the user). Or the user
 * select a range of cells to act as destination of imported information, select a specific table in  
 * database and import imformation to the selected cells.
 * 
 *  
 * <h2>3. Analysis</h2>
 * Since import/Export database will be supported in a new extension to cleansheets we need to study how extensions are loaded by cleansheets and how they work.
 * The first sequence diagram in the section <a href="../../../../overview-summary.html#arranque_da_aplicacao">Application Startup</a> tells us that extensions must be subclasses of the Extension abstract class and need to be registered in special files.
 * The Extension class has a method called getUIExtension that should be implemented and return an instance of a class that is a subclass of UIExtension.
 * 
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * <p>
 * <b> The user select a range of cells to be used as source or destination.
 * The system asks the name of database and table.
 * The user inserts data(name of database and table).
 * The system asks if you want to import or export.
 * The user select one option.
 * The system fills the cells with the content of the database(import) or export the selected cells.
 * The system asks confirmation.
 * The user confirm.
 * 
 * The following diagram depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created).
 * <p>
 * <img src="import_export_database_uc_realization.png" alt="image"> 
 * <p>
 * 
 *
 * <h2>4. Design</h2>
 *
 * <h3>4.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core functionality of this use case is to be able to add an attribute to cells to be used to store a comment/text. We need to be able to set and get its value.
 * Following this approach we can start by coding a unit test that uses a subclass of <code>CellExtension</code> with a new attribute for user comments with the corresponding method accessors (set and get). A simple test can be to set this attribute with a simple string and to verify if the get method returns the same string.
 * As usual, in a test driven development approach tests normally fail in the beginning. The idea is that the tests will pass in the end. 
 * <p>
 * see: <code>lapr4.white.s1.core.n1234567.comments.CommentableCellTest</code><p>//Change
 *
 * <b>Attention: This test should be moved and refactored to Acceptance Tests so that it is in accordance with the 2017 edition guidelines.</b>
 * 
 * <h3>4.2. UC Realization</h3>
 * The user selects a range of cells to import or export and the ui asks a name for the database connection. 
 * User connection name is validated by the ui and, through the ImportExportTable and jdbc 
 * classes, a connection to the database will be established. Once a successful 
 * connection is established the use case will have different actions(to import or export):
 * To import the ui asks the name of the table already existent in the database, the ui
 * calls a controller method and the controller calls a ImportExportTable method that
 * create a connection with database and execute a couple of queries in order to get
 * information contained in the choosed table filling the selected cells with the
 * correct information. 
 * To export the user choose create a new table or change an existing table. If he
 * chooses change an existing table, the ui calls a controller method that calls a ImportExportTable
 * method that establishes a connection with the database and executes a query that 
 * will retrieve the name of all tables. After that, the information in this
 * table will be changed.
 * <p>
 * 
 * <h3>Sequence diagrams</h3>
 * The following diagrams explain how use case works.
 * <p>
 * <img src="04.3_Export_Data_Design.png" alt="image">
 * <p>
 * <img src="04.3_Import_Data_Design.png" alt="image">
 * 
 * 
 * <h3>4.3. Design Patterns and Best Practices</h3>
 * To obtain a more organized implementacion i use a classe JDBC to establish connection
 * with the database, and the classe ImportExportTable that simplified accedd to the
 * data stored in the database.
 * <p>
 * 
 * <h2>8. Work Log</h2> 
 * <b>Monday: </b>
 * <p>
 * started the analysis
 * </p>
 * <b>Tuesday</b>
 * <p>
 * continuation of the analysis
 * </p>
 * <b>Wendsday</b>
 * <p>
 * finished analysis and started the design
 * </p>
 * <b>Thursday</b>
 * <p>
 * finished design and started implementation
 * </p>
 * <b>Friday</b>
 * <p>
 * continuation of the implementation
 * </p>
 * <b> Saturday</b>
 * <p>
 * correction of erros in the implementation
 * </p>
 * <b>Sunday</b>
 * * <p>
 * tests and update the package info
 * </p>
 * 
 * @author Carlos Neiva
 */
package lapr4.green.s3.ipc.n1150993.ImportExportData;