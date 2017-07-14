/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1150466.findWorkbooks;

import java.io.File;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Sebastiao
 */
public class FindWorkbooksTest {

    public FindWorkbooksTest() {
    }

    /**
     * Test of search method, of class FindWorkbooks.
     */
    @Ignore
    @Test
    public void testSearch() {
        System.out.println("search");
        FindWorkbooks instance = new FindWorkbooks("/Users/Sebastiao/CLS");

        List<File> result = instance.search();

        for (File file : result) {
            System.out.println(file.getAbsolutePath());
        }

        assertEquals(result.size(), 7);

    }

    /**
     * Test of search method, of class FindWorkbooks.
     */
    @Ignore
    @Test
    public void testSearchNoCLSFiles() {
        System.out.println("testSearchNoCLSFiles");
        FindWorkbooks instance = new FindWorkbooks("/Users/Sebastiao/Desktop/empty");

        List<File> result = instance.search();

        if (!result.isEmpty()) {
            for (File file : result) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("0 .cls files");
        }

        assertEquals(result.size(), 0);
    }

    /**
     * Test of search method, of class FindWorkbooks.
     */
    @Ignore
    @Test
    public void testSearchInvalidDir() {
        System.out.println("testSearchInvalidDir");
        FindWorkbooks instance = new FindWorkbooks("/Users/Sebastiao/Desktop/blabla");
        try {
            List<File> result = instance.search();
        } catch (NullPointerException e) {
            System.out.println("invalid dir");
        }

    }

}
