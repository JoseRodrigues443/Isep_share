/**
 * Technical documentation regarding the user story Lang08.3 - Full xml Import/Export.
 *
 *
 * <h2>Requirements </h2>
 *
 * The previous options should now include all the persisting elements of
 * Cleansheets (i.e., all the contents that are normally persisted with the
 * workbook, such as macros, formatting styles, comments, etc.). The import
 * should now ask the user if the file contents should replace or append the
 * existing workbook contents.
 *
 *
 * <h2>Analisys </h2>
 *
 * <h3>Description: </h3>
 *
 * This use case complements both the use case Lang 8.1 and Lang 8.2 by adding
 * the persisting elements that were left out of them. This is done at both
 * export and import. Also, the xml elements may now append or replace the
 * existing workbook contents, as the user sees fit. The export option's
 * sequence diagram is very much the same as the one in uc 8.1 except with more
 * elements. The import option, has one extra step where the system asks the
 * user if he wants to append or replace the existing workbook contents.
 *
 * <h3>Persisting items that must be saved: </h3>
 *
 * -> Comments on cells<p>
 * -> Images on workbooks<p>
 * -> Global Variables on the workbook<p>
 * -> Macros on the workbook<p>
 * -> Forms on the workbook<p>
 * -> Profile Configuration and Message History<p>
 * -> The configuration of file sharing<p>
 *
 *
 * <h2>Design </h2>
 *
 * <h3>Xml export</h3>
 *
 * <p>
 * <img src="exportSd.png" alt="image">
 * <p>
 *
 * <h3>Xml import</h3>
 *
 * <p>
 * <img src="importxml_analisys.png" alt="image">
 * <p>
 *
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * 
 * Package lapr4.blue.s3.lang.n1150524.fullXmlImport.application<p>
 * {@link lapr4.blue.s3.lang.n1150524.fullXmlImport.application.FullXmlImportController}<p>
 * 
 * Package lapr4.blue.s3.lang.n1150524.fullXmlImportExport<p>
 * {@link lapr4.blue.s3.lang.n1150524.fullXmlImportExport.FullDataImport}<p>
 * 
 * Package lapr4.blue.s3.lang.n1150524.fullXmlImportExport.ui<p>
 * {@link lapr4.blue.s3.lang.n1150524.fullXmlImportExport.ui.FullImportUI}<p>
 * 
 * Other classes have been changed in order to make this use case functional:<p>
 * {@link lapr4.green.s1.lang.n1150993.exportXML}
 *
 */
package lapr4.blue.s3.lang.n1150524.fullXmlImportExport;
