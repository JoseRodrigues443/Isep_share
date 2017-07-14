package lapr4.red.s1.ipc.n1150834.importExportTxt;

/**
 *
 * @author 1150834
 */
public interface Import {

    /**
     * Imports and returns lines from a text file, with the number of lines
     * being limited by a given number of rows.
     *
     * @param rowNumber number of rows to be imported
     * @return an array with the imported lines
     */
    public String[] importInformation(int rowNumber);
}
