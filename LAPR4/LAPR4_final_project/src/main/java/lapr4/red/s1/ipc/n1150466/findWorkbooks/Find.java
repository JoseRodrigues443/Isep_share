package lapr4.red.s1.ipc.n1150466.findWorkbooks;

import java.io.File;
import java.util.List;

public interface Find {
    /**
     * The method to search for files.
     * @return found file list
     */
    public List<File> search();
    
}
