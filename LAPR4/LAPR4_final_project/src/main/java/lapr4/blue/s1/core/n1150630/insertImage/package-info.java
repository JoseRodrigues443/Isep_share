/**
 * Technical documentation regarding the user story Core6.1: Insert Image
 * <p>
 *
 * <b></b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the sprint's work.-
 * <p>
 *
 *
 * <h2>1. Requirement</h2>
 *
 * The extension should include an option to insert an image. The inserted image
 * should become associated with the active/selected cell. It should also exist
 * a new sidebar window to display the images that are associated with the
 * current cell (in a manner similar to how comments work). A cell can have
 * several associated images. The sidebar should have an option (button) to
 * remove/delete images. The workbook should only save links to the files that
 * contain the images.
 * <p>
 *
 * <h2>2. Analysis</h2>
 *
 * The user iniciates the operation Insert Image after selecting a cell. The
 * system opens a sidebar and the user adds or removes images
 *
 * Dependencies: This story doesn't depend on the realization of any other
 * story, because what's needed is already implemented.
 *
 * Questions for the client: Is it supposed to have the images in the sidebar
 * and the path of the image in the cells?? Yes.
 * <p>
 *
 * <h2>3. Tests</h2>
 *
 * The main tests we will have to do is to verify if the images are being
 * correctly inserted and removed. Therefore, when the user adds images we will
 * test if those images were inserted on the cells selected. When the user
 * removes an image, we have to guarantee that these images were removed
 * successfully. Therefore, will be made tests about the Image methods that this
 * US uses.
 * <p>
 *
 * <h2>4. Design</h2>
 *
 * <b>Sequence Diagrams</b><p>
 *
 * <p>
 *
 * <img src="Analysis.png" alt="image">
 *
 * <p>
 * <img src="Design1.png" alt="image">
 *
 * <p>
 * <img src="Design2.png" alt="image">
 *
 *
 * @author David
 */
package lapr4.blue.s1.core.n1150630.insertImage;
