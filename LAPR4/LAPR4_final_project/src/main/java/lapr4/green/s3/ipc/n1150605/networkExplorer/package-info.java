/**
 * Technical documentation regarding the user story Core06.3 - NetworkExplorer
 * <br/>
 *<h2>1. Description</h2>
 * 
 * Cleansheets should now have a new sidebar window to display information about all the instances of
 * Cleansheets in the same local network. The window should be based on a tree control. The tree should
 * display at the root all instances of Cleansheets. For each instance it should display its resources as
 * branches of the root element corresponding to the instance. The information should include: workbooks
 * and respective worksheets; loaded extensions (if they are active or inactive) and its description and version.
 * This tree should be updated in real time

 * <br/>
 * <br/>
 * 
 * <h2>2. Requirement</h2>
 * This use case allows the user to see in real time, all open instances of CleanSheets in the same local network.
 * 
 * <br/>
 * <br/>
 * 
 * <h2>3. Analysis</h2>
 * 
 * There is a sidebar window to display information about the current instances of
 * CleanSheets in the same local network. This information is presented based on a tree control
 * showing workbooks and respective worksheets, loaded and unloaded extensions
 * as its description and version.
 * <br/>
 * <br/>
 * 
 * <h2>SSD</h2>
 * <img src="networkExplorer_analysis.png"/>
 * 
 * <h2>4. Design</h2>
 *
 *<h2>Sequence Diagram</h2>
 *
 * Receive Message
 * <img src="networkExplorer_design_receiveMessage.png"/>
 * 
 * Send Message
 * <img src="networkExplorer_design_sendMessage.png"/>
 * 
 * Tree Control
 * <img src="TreeControl_design.png"/>
 *
 *  <br/>
 * <h2>5. Coding</h2>
 *
 *
 * <br/>
 *
 * <h2>6. Tests </h2>
 *
 * 
 *
 * 
 * 
 *
 * <br/>
 * <br/>
 *
 * @author Miguel Morgado 1150605
 */
package lapr4.green.s3.ipc.n1150605.networkExplorer;
