package lapr4.red.s3.core.n1150834.persistingImages;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * A Unit Test class to test ImportImage
 *
 * @author 1150834
 */
public class ImportImageTest {

    private ImportImage in;
    private UIController ui;
    private Cell cell;
    private String path;

    public ImportImageTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        CleanSheets app = new CleanSheets();
        ui = new UIController(app);
        Workbook book = new Workbook(1);
        Spreadsheet sheet = book.getSpreadsheet(0);
        cell = sheet.getCell(0, 0);
        ui.setActiveCell(cell);
        path = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg";
    }

    @After
    public void tearDown() {
    }

    /**
     * Test is image path is not null.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testpathCannotBeNull() {
        System.out.println("image path cannot not be null");

        in = new ImportImage(ui, null);
    }

    /**
     * Test is image path is not empty.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testpathCannotBeEmpty() {
        System.out.println("image path cannot be empty");

        in = new ImportImage(ui, "");
    }

    /**
     * Test is image path is not whitespace.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testpathCannotBeWhiteSpace() {
        System.out.println("image path cannot be whitespace");

        in = new ImportImage(ui, " ");
    }

    /**
     * Test that given path is for an image
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testpathHasToRepresentAnImage() {
        System.out.println("image path has to represent an image");

        in = new ImportImage(ui, "image.txt");
    }

    /**
     * Test of importImage method
     *
     * @throws java.io.IOException
     */
    @Test
    @Ignore
    public void testImportImage() throws IOException {
        System.out.println("image is properly imported");

        in = new ImportImage(ui, path);
        File file = new File(path);

        in.importImage();
        PersistentImageCell result = (PersistentImageCell) cell.getExtension(PersistingImagesExtension.NAME);
        List<PersistentImage> list = result.getList();

        BufferedImage buffer = ImageIO.read(file);
        Image img = buffer.getScaledInstance(buffer.getWidth(), buffer.getHeight(), Image.SCALE_SMOOTH);
        PersistentImage expected = new PersistentImage(img, file.getName());

        assertEquals(1, list.size());
        assertEquals(expected.image().getDescription(), list.get(0).image().getDescription());

    }

}
