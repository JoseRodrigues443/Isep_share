/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1140412.fileSharing;

import java.io.File;
import java.util.ArrayList;
import javax.swing.filechooser.FileSystemView;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Tiago
 */
public class FileShareTest {
    
    public FileShareTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of filesUnderPath method, of class FileShare.
     */
    @Ignore
    @Test
    public void testEmptyDirector() {
        System.out.println("filesUnderPath");
        String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\test";
        ArrayList<File> expResult = new ArrayList<>();
        ArrayList<File> result = FileShare.filesUnderPath(path);
        assertEquals(expResult, result);
        
    }

    
}
