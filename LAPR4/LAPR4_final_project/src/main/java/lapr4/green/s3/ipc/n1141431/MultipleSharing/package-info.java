/**
 * Technical documentation regarding the user story Multple Sharing
 *
 * <br/>
 *
 *
 * <h2>1. Requirement</h2>
 * <p>
 * <br/>
 *
 * It should be possible to have multiple cell shares active at the same time.
 * Each of the shares should have a unique name. The location (i.e., range
 * address) of the share in each instance of Cleansheets may be different. It
 * should be possible to share ranges that include cells with formulas.
 *
 * <p/>
 * <br/>
 *
 *
 * <h2>2. Analysis</h2>
 * <p>
 * For this uc i will have make some changes to the classes and add new methods
 * and classes such as:
 *
 * It should be possible to select several area ranges. Create a Jlist in the
 * sidebar to display the number of areas .A area must have a name .I must create
 * a Area class to save the diferent ranges selected. Must change the sidebar so
 * it can be added several areas and validate if the range chosen is different
 * for every area ( if the areas dont have the same adress).
 * <p/>
 *
 *
 *
 * <h2>4. Design</h2>
 * <p>
 * <b>Sequence Diagram</b>
 *
 *
 * Analysis SSD
 * <img src="SSD_image.png"/>
 *
 * explains how the information is received
 * <img src="SD_design_receive_sell"/>
 *
 * explains the sending of information
 * <img src="SD_design_send_cell"/>
 *
 * <br/>
 * <p/>
 *
 *
 * <br/>
 *
 * <h2>6. Tests </h2>
 *
 * There was a need to make some tests to assure the full funcionality of this uc such as:
 * testMatrixOfCellsMustNotBeNull
 * testNetworkAdressMustNotBeNull
 *
 *
 * <br/>
 * <br/>
 * <h2>6. Work Log</h2>
 *
 * <b>Monday: </b>
 * <p>
 * started the analysis
 * </p>
 * <b>Tuesday</b>
 * <p>
 * continuation of the analysis
 * </p>
 * <b>Wendsday</b>
 * <p>
 * finished analysis and started the design
 * </p>
 * <b>Thursday</b>
 * <p>
 * finished design and started implementation
 * </p>
 * <b>Friday</b>
 * <p>
 * continuation of the implementation
 * </p>
 * <b> Saturday</b>
 * <p>
 * correction of erros in the implementation
 * </p>
 * <b>Sunday</b>
 * * <p>
 * tests and update the package info
 * </p>
 *
 *
 * @author Pedro Oliveira 1141431
 */
package lapr4.green.s3.ipc.n1141431.MultipleSharing;
