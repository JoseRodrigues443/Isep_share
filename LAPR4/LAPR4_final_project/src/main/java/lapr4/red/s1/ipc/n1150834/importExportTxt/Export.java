package lapr4.red.s1.ipc.n1150834.importExportTxt;

/**
 *
 * @author 1150834
 */
public interface Export {

    /**
     * Exports into a file the information given in the matrix.
     *
     * @param information matrix with the information to be exported
     * @return true if succesfull, false otherwise
     */
    public boolean exportInformation(String[][] information);
}
