/**
 * Technical documentation regarding the user story Core06.2: Overlay Image Window.
 * 
 * <p>
 * <b>Scrum Master: - no</b>
 * 
 * <p>
 * <b>Area Leader: - no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * <p>
 * This week i should've finished last week's feature : Lang02.1 - "Temporary Variables", but i was unable to do so duo to
 * some problems i had to face, unrelated to the project itself. Since i couldn't, that feature was attributed to another team member
 * Joao Fernandes (1141114).
 * As such, this document will report the development of the feature Core 06.2: Overlay Image Window developed on this week.
 *
 * <h2>2. Requirement</h2>
 * 
 * The user should be able to see a small icon on the corner of the cells that have associated images.
 * When the mouse is hovered above those cells, a window that displays all the images should open.
 * This window should have browsing buttons. When the mouse is moved out of the cell, the window should close.
 * The images are to be persisted with the workbook.
 * 
 * <p>
 * <b>Use Case "Overlay Image Window":</b> Cleansheets should display a small icon in the corner of cells that have associated images. 
 * When the mouse is hovering such cells a modeless window (i.e., an overlay window) should appear to display the associated images 
 * (this is independent from the sidebar window). The window should always appear next to the cell. 
 * This window should have buttons to browse over all the images. When the mouse focus leaves the cell the window should automatically close. 
 * The images should also be persisted with (i.e., inside) the workbook. 
 *  
 * <h2>3. Analysis</h2>
 * 
 * To the realization of this User Case, a mouse listener needs to be implemented.
 * The listener will detect if the mouse is hovering the cell to open the window, and it will also detect if the mouse leaves the window
 * This will create a modeless window on the side of the cell with the associated images and a way to browse through images (a combobox will be used).
 * The cells with images need to have an icon.
 *
 * <h2>4. Design</h2>
 *
 * <h3>4.1. Functional Tests</h3>
 * <p>
 * Add an image to a cell and see if an icon appears.
 * <p>
 * Pass the mouse over the cells and see if the overlay window appears.
 * <p>
 * Have an error message if the path chosen for the image is not valid.
 * <p>
 * Save the worksheet with images on and reload to see if it is persisted.
 * 
 * <h3>4.2. Sequence Diagram</h3>
 * <p>
 * <img src="core06.2_SD" alt="image"/> 
 * <p>
 * 
 * <h2>5. Implementation</h2>
 * 
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and where used in this issue. As far as possible you should use links to the commits of your work-
 * 
 * <h2>6. Integration/Demonstration</h2>
 * 
 * -In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 * -TODO-
 * 
 * <h2>7. Final Remarks</h2>
 * 
 *  -TODO-
 * 
 * <h2>8. Work Log</h2> 
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Nothing
 * <p>
 * Today
 * <p>
 * 1. Nothing
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Nothing
 * <p>
 * Today
 * <p>
 * 1. Presentation of last week's work
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Presentation of last week's work
 * <p>
 * Today
 * <p>
 * 1. Analysis
 * <p>
 * Blocking: 
 * <p>
 * 1. Nothing
* <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Analysis
 * <p>
 * Today
 * <p>
 * 1. Design
 * 2. Tests
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 * <p>
 * <b>Friday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Design
 * 2. Tests
 * <p>
 * Today
 * <p>
 * 1. Continuation of Design
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 * <p>
 *  * <b>Saturday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Continuation of Design
 * <p>
 * Today
 * <p>
 * -TODO-
 * <p>
 * Blocking:
 * <p>
 * -TODO-
 * <p>
 * 
 * <h2>9. Self Assessment</h2> 
 * 
 * <h3>Design and Implementation: -TODO-</h3>
 * 
 * -TODO-
 * 
 * <h3>R6. Rubric Requirements Analysis: -TODO- </h3>
 * 
 *  -TODO-
 * 
 * <h3>R7. Rubric Design and Implement:  -TODO-</h3>
 * 
 *  -TODO-
 * 
 * @author Rui Braga
 */
package lapr4.green.s2.core.n1150835.overlayImageWindow;

