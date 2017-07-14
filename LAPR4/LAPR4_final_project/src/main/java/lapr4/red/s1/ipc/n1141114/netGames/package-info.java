/**
 * Technical documentation regarding the user story IPC07.1: Choose Game and Partner. 
 * <p>
 * 
 * <b>Requirement</b><p>
 * Statement:<p>
 * It should be possible to establish a connection with other instance of Cleansheets in the local network. <p>
 * It should be possible to invite another instance to play one game. The other instance should display an alert about the receive invitation.<p>
 * It should be possible to configure the user profile. The name should be the system name and the user should be able to configure an icon or photograph to be associated with the profile. <p>
 * It should be possible to find other instances of Cleansheets available in the local network. These instances should be listed in a new window (sidebar window). The user should be able to select one of the discovered instances to connect to when establishing the connection to send the invitation for the game. At the moment both games will not be implemented. <p>
 * It should be possible to play several games at the same time. This instances of games should be listed in a new window (sidebar window). <p>
 * It should be possible to end the game at any given time. <p>
 * 
 * Notes:<p>
 * The same TCP connection should be shared by all the communication functionalities of the Cleansheets application. 
 * <p>
 * There should be a specific port to respond to UDP datagrams broadcasted by clients to discover instances of Cleansheets in the local network.
 * <p>
 * 
 * <b>Analysis</b><p>
 * <img src="IPC07.1_ChooseGame&Partner.png" alt="image">
 * <p>
 * <b>Notes:</b><p>
 * This analysis is based on the fact that the user will work both as a Sender or Receiver at a given moment.
 * It will works as a Sender to be able to be seen online by all the active users in the local newtork.
 * In the other hand it will work as a Receiver to be able to send invitations to another active user in the locak network.
 * 
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also use case tests (e.g., like in the TDD approach). <p>
 *
 * <b>Test1:</b> BaseEchoCommunicationTest<p>
 * There should be a simple echo service that should return the echo of each message received.<p>
 * 
 * <b>Test2:</b> UserProfileNameCannotBeNull<p>
 * There should be a simple test that should verify if the user profile name is null. <p>
 * 
 * <b>Test3:</b> UserProfileAddressCannotBeNull<p>
 * There should be a simple test that should verify if the user profile address is null. <p>
 * 
 * <b>Design</b><p>
 * First model regarding the design.
 * 
 * <img src="IPC07.1_ChooseGame&Partner_ExtensionDesign.png" alt="image"> 
 * <p>
 * Design that explains how the extension functionality works.
 * 
 * <p>
 * <img src="IPC07.1_ChooseGame&Partner_Design.png" alt="image"> 
 * <p>
 * 
 * @author Joao Fernandes - 1141114@isep.ipp.pt
 */
package lapr4.red.s1.ipc.n1141114.netGames;

