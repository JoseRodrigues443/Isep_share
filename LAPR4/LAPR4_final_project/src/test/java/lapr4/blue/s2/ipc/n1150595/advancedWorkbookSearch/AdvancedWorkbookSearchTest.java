/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150595.advancedWorkbookSearch;

import java.io.File;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class AdvancedWorkbookSearchTest {

    public AdvancedWorkbookSearchTest() {
    }

    /**
     * Test of search method, of class AdvancedWorkbookSearch.
     */
    @Ignore
    @Test
    public void testSearchPattern() {
        System.out.println("search");
        AdvancedWorkbookSearch instance = new AdvancedWorkbookSearch("C:\\Users\\starb\\Desktop\\final\\lapr4-2017-2db\\CLS", "teste");

        List<File> result = instance.search();

        for (File file : result) {
            System.out.println(file.getAbsolutePath());
        }

        assertEquals(result.size(), 1);

    }

}
