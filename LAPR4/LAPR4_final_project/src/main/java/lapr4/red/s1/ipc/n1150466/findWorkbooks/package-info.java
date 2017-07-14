/**
 * Technical documentation regarding the user story IPC02.1 - Find Workbooks.
 *
 * <b>Scrum Master: no</b>
 * <b>Area Leader: no</b>
 *
 * <h2>1. Notes</h2>
 *
 *
 * <h2>2. Requirement</h2>
 * The extension should add a new window (sidebar) to search for workbook files
 * in the local file system. The user should be able to enter the name of a
 * directory of the file system to be used as the root of the search. The search
 * should include this directory and all its contents (including
 * subdirectories). The results of the search should appear in a list (as files
 * are found). It should be possible for the user to open a workbook from this
 * list by double clicking in it. The search can be based solely on the file
 * name extension. For instance, find the files with .cls extension.
 *
 * <p>
 * <b>Use Case "Find Workbooks":</b> The user enters the name of the directory
 * to search for. The system displays the results of the search. The user opens
 * a file if he desires.
 *
 * <h2>3. Analysis</h2>
 *
 * <h3>First "analysis" sequence diagram</h3>
 * <p>
 * <img src="IPC02.1_FindWorkbooks.png" alt="image">
 * <p>
 * From the previous diagram we see that there is a need to create an algorithm
 * that would select a directory and traverse all sub-directories in search for
 * all files that end with the ".cls" extension. And consequently present them
 * to the user in a list. Then if the user selects a given file, the extension
 * should load the spreadsheet as a newly opened spreadsheet. To aid this
 * implementation there is a possibility to re-use the already implemented
 * function of opening a user selected filein order to avoid code duplication.
 * </p>
 *
 * <p>
 * The code that would be used is the following function, "load, from the class
 * CleanSheets.
 * </p>
 * <pre>
 * {@code
 *          public void load(File file) throws IOException, ClassNotFoundException {
 *		Codec codec = new CodecFactory().getCodec(file);
 *		if (codec != null) {
 *                  FileInputStream stream = null;
 *                  Workbook workbook;
 *                  try {
 *                      // Reads workbook data
 *                      stream = new FileInputStream(file);
 *                      workbook = codec.read(stream);
 *                  } finally {
 *                      try {
 *                          if (stream != null)
 *                              stream.close();
 *                          } catch (IOException e) {}
 *                      }
 *
 *                  // Loads the workbook
 *                  workbooks.put(workbook, file);
 *                  fireSpreadsheetAppEvent(workbook, file, SpreadsheetAppEvent.Type.LOADED);
 *		} else
 *                  throw new IOException("Codec could not be found");
 *           }
 *}
 * </pre>
 * <h2>4. Design</h2>
 *
 *
 * <h3>4.1. UC Realization</h3>
 *
 * <p>
 * For this use case realization there will be needed only one class/interface
 * to implement our algorithm to find all files with .cls extension. Therefore
 * this use case only require further research about how to actually implement
 * the extension, which can be found in the CleanSheets core package.
 * </p>
 *
 * <h3>Extension Setup</h3>
 * <img src="find_workbooks_extension_setup.png" alt="image">
 *
 * <br/><p>
 * The following diagram illustrates the extension implementation, when the user
 * specifies the directory to search.</p>
 *
 * <img src="find_workbooks_design.png" alt="image">
 *
 *
 *
 */
package lapr4.red.s1.ipc.n1150466.findWorkbooks;
