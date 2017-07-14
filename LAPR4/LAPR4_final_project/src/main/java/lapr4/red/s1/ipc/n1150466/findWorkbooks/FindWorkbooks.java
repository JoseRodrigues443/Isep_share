package lapr4.red.s1.ipc.n1150466.findWorkbooks;

import csheets.core.Workbook;
import csheets.io.Codec;
import csheets.io.CodecFactory;
import csheets.ui.ctrl.UIController;
import java.io.EOFException;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Edited by Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class FindWorkbooks implements Find, Load {

    /**
     * Extension of the files to be searched for.
     */
    private static final String EXTENSION = ".cls";

    /**
     * The workbook which would be created if the user selects a file to be
     * loaded.
     */
    private Workbook workbook;

    /**
     * User selected directory of the root of the search.
     */
    private String userDirectory;

    /**
     * User inserted pattern
     */
    private String pattern;

    private final String DEFAULT_PATTERN = "";

    /**
     * Creates a new FindWorbooks object with no parameters.
     */
    public FindWorkbooks() {
        this.pattern = DEFAULT_PATTERN;
    }

    /**
     * Creates a new FindWorkbooks object with the userDirectory parameter.
     *
     * @param userDirectory user selected directory of the root of the search
     * @param pattern user inserted pattern
     */
    public FindWorkbooks(String userDirectory, String pattern) {
        this.userDirectory = userDirectory;
        this.pattern = pattern;
    }

    public FindWorkbooks(String userDirectory) {
        this.userDirectory = userDirectory;
        this.pattern = DEFAULT_PATTERN;
    }

    /**
     * Method to verify if the user has already specified a root directory.
     *
     * @return true - has - or false - has not.
     */
    public boolean hasDirectory() {
        return !userDirectory.equals("");
    }

    /**
     * Method to set the root directory.
     *
     * @param dir the root directory
     */
    public void setUserDirectory(String dir) {
        this.userDirectory = dir;
    }

    /**
     * Method to get the pattern
     *
     * @return user inserted pattern
     */
    public String pattern() {
        return pattern;
    }

    /**
     * Method to set the pattern
     *
     * @param pattern user inserted pattern
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Method to search for the .cls files, implemented as such and inherited
     * from the Find interface.
     *
     * @return found file list
     */
    @Override
    public List<File> search() {
        File directory = new File(userDirectory);

        List<File> result = new ArrayList<File>();

        File[] fileList = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return ((pathname.getAbsolutePath().endsWith(EXTENSION) && pathname.getAbsoluteFile().getName().startsWith(pattern)) || pathname.isDirectory());
            }
        });
        result.addAll(Arrays.asList(fileList));

        for (File file : fileList) {
            if (file.isFile()) {
                //System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                userDirectory = file.getAbsolutePath();
                result.remove(file);
                result.addAll(search());
            }
        }

        return result;
    }

    /**
     * Method to load a chosen file, inherited from the interface Load.
     *
     * @param file the chosen file
     * @param uiController user interface controller to access the active
     * workbook
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void load(File file, UIController uiController) throws IOException, ClassNotFoundException {
        Codec codec = new CodecFactory().getCodec(file);
        boolean load = true;
        if (codec != null) {
            FileInputStream stream = null;
            try {
                // Reads workbook data
                stream = new FileInputStream(file);
                workbook = codec.read(stream);
            } catch (EOFException exc) {
                JOptionPane.showMessageDialog(null, "The selected file is empty!", "Empty", JOptionPane.INFORMATION_MESSAGE);
                load = false;
            } finally {
                try {
                    if (stream != null) {
                        stream.close();
                    }
                } catch (IOException e) {
                }
            }

            //load
            if (load) {
                uiController.setActiveWorkbook(workbook);
            }

        } else {
            throw new IOException("Codec could not be found");
        }
    }

    /**
     * Method that returns the workbook - Sprint 2
     *
     * @return the workbook
     */
    public Workbook workbook() {
        return this.workbook;
    }

    /**
     * Method that changes the workbook
     *
     * @param workbook the new workbook
     */
    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

}
