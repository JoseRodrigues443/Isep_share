/**
 * Technical documentation regarding the user story IPC5.2: Chat Participants
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
 * The sidebar should have an option to The sidebar should have an option to
 * communicate with other machines. To communicate it is necessary for each
 * machine to have a profile. Only in the "Online" state can each machine
 * communicate with other machines. Once the profile is created it is possible
 * to create a chat conversation. In addition to communicating with other
 * machines, you can view past conversations.
 * <p>
 *
 * <h2>2. Analysis</h2>
 *
 * The user initiates communication after creating profile. The profile must be
 * online.
 *
 * Dependencies: Depends on the uc Chat Send Message
 *
 * Questions for the client: Is it the user that defines their status? Yes.
 * <p>
 *
 * <h2>3. Tests</h2>
 *
 * The main tests will have to be checked if the user creates a profile and puts
 * it in the "Online" state. Therefore, when the user creates a profile, we will
 * test whether the status is correct.
 * <p>
 *
 * <h2>4. Design</h2>
 *
 * <b>Sequence Diagrams</b><p>
 *
 * <p>
 *
 * <img src="SD_InsertImage.png" alt="image">
 *
 * <p>
 * <img src="SD_RemoveImage.png" alt="image">
 *
 * <p>
 * <img src="SD_ShowImage.png" alt="image">
 *
 *
 * @author David
 */
package lapr4.blue.s2.ipc.n1150630.chatApplication;
