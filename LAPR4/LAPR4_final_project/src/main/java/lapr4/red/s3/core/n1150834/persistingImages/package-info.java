/*
 * Technical documentation regarding the user story Core06.3 - Persisting Images.
 *
 *
 * <h2>2. Requirement</h2>
 * When a image is inserted its contents should be imported to the workbook. 
 * The images should also be persisted with (i.e., inside) the workbook. 
 * The window overlay that displays images should now be able to update its contents when the user 
 * changes the mouse focus to another cell. The window should now have a close button/icon. 
 * It should exist a new option to enable/disable automatic image window appearance. 
 * If enabled the window will appear automatically when the mouse is hovering a cell with images. 
 * If disabled, the window only appears if the user clicks in the icon that adorns the cell indicating 
 * that it has images.
 *
 * <p>
 * <b>Use Case "Persisting Images":</b> The user selects the import option. The system asks for the image path.
 * The user gives the image path. The system imports the image into the workbook.
 *
 * <h2>3. Analysis</h2>
 * In its most basic form, this user story is an expansion of the first interation of this use case, 
 * however in this iteration instead of storing the image links we will store the image themselves. It is also 
 * important to mention that these images need to be persistent with the workbook, which means they should survive save/open 
 * operations.
 * The other part of this use case is the alteration on the previous iteration, that being said the analysis present in 
 * <code>lapr4.green.s2.core.n1150835.overlayImageWindow.pacakge-info</code> will be taken into account. However now the window should 
 * be able to update it's contents, and not simply close when the user changes the mouse focus to another cell that contains an image.
 * Finally there is the option to enable/disable the opening of the window, which will work as a global option affecting every cell that has
 * one or more images.
 *
 *
 * <h3>First "analysis" sequence diagrams</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case, import image. We
 * call these diagrams an "analysis" use case realization because they function
 * like a draft that we can do during analysis or early design in order to get a
 * previous approach to the design. For that reason we mark the elements of the
 * diagrams with the stereotype "analysis" that states that the element is not a
 * design element and, therefore, does not exists as such in the code of the
 * application (at least at the moment that these diagrams were created), or in this case 
 * may suffer alterations during the UC implementation.
 * <p>
 * <img src="persisting_images_realization1.png" alt="image">
 * <p>
 *
 * From the previous diagram we see that we atleast need to update the already existing code, 
 * or use that code as an inspiration for what will be done in this use case.
 * Therefore, at this point, we need to study the previous iterations of the user story.
 *
 * <h3>Unit Tests</h3>
 * testpathCannotBeNull
 * testpathCannotBeEmpty
 * testpathCannotBeWhiteSpace
 * testpathHasToRepresentAnImage
 *
 * <h2>4. Design</h2>
 *
 * <h3>4.1. UC Realization</h3>
 * To realize this user story we will need to alter the already existing code, be it rewriting or simply 
 * updating it, so that it will support the new requirements. When it comes to importing images, the already 
 * existing code from the first sprint can be used, yet it will be necessary to create a class that represents 
 * the imported image itself to replace the class that contained the image link <code>lapr4.blue.s1.core.n1150630.insertImage.CellImage</code>.
 * When it comes to the new behavior of the window implemented in Core06.2, alterations to <code>lapr4.green.s2.core.n1150835.overlayImageWindow.ImageBrowserListener</code> 
 * will be needed in order to enable the system to detect if the cell that the mouse is currently is focused on 
 * has images, if it has the window will have to update it's contents. The same class will also need to allow the user to summon the window 
 * in case the automatic appearence is disable, for this we will use MouseListener.
 * For the enabling/disabling actions a new option will be created in the Extensions menu, that will allow the user 
 * to chose either option, which will then affect how the window is displayed.
 * <p>
 *
 * <h3>Persisting Images</h3>
 * <img src="persisting_images.png" alt="image">
 * <p>
 *
 *
 *
 * @author 1150834
 */
package lapr4.red.s3.core.n1150834.persistingImages;
