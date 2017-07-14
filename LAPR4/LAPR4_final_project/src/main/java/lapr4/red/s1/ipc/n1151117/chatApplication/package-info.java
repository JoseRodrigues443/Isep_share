/**
 * Technical documentation regarding the user story IPC05.1: Chat Send Message.
 * <p>
 * 
 * <b>Requirement</b><p>
 * Statement:<p>
 * It should be possible to establish a connection with other instance of Cleansheets in the local network and comunicate.<p>
 * It should be possible to send a message to another instance. The other user will see a pop-up that shows the message and .<p>
 * It should be possible to reply to a message, to another instance.<p>
 * It should be possible to group all messages by a thread (conversation). The messages should be grouped by ip addresses.<p>
 * It should be possible to find other instances of Cleansheets available in the local network. These instances should be listed in a new window (sidebar window). The user should be able to select one of the discovered instances to connect to when establishing the connection to send the message to another user. At the moment group chats will not be implemented. <p>
 * It should be possible to have multiple chats (conversations) at the same time. This instances of chats (conversations) should be listed in a new window (sidebar window). <p>
 * 
 * Notes:<p>
 * The same TCP connection should be shared by all the communication functionalities of the Cleansheets application. 
 * <p>
 * There should be a specific port to respond to UDP datagrams broadcasted by clients to discover instances of Cleansheets in the local network.
 * <p>
 * 
 * <b>Application Workflow</b><p>
 * <img src="ipc_05_1_flow.png" alt="image">
 * 
 * <b>Analysis</b><p>
 * In a simple way, the analysis of a chat application is:
 * <p>
 * <img src="ipc_05_1_analysis.png" alt="image">
 * <p>
 * <b>Notes:</b><p>
 * This analysis is based on the fact that the user will work both as a Sender and/or Receiver (peer-to-peer) at a given moment.
 * It will works as a Sender to be able to be seen online by all the active users in the local newtork and send messages to any of them.
 * In the other hand it will work as a Receiver to be able to receive messages from another active user in the locak network.
 * 
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also use case tests (e.g., like in the TDD approach). <p>
 *
 * <b>Test1:</b> BaseEchoCommunicationTest<p>
 * There should be a simple echo service that should return the echo of each message received.<p>
 * 
 * <b>Test2:</b> IPAddressesCannotBeNull<p>
 * There should be a simple test that should verify if any IP address is null. <p>
 * 
 * <b>Test3:</b> MessageCannotBeNullOrEmpty<p>
 * There should be a simple test that should verify if the message is null or empty. <p>
 * 
 * <b>Test4:</b> UserCannotMessageHimself<p>
 * There should be a simple test that should verify if the sender's ip is different than the destination's ip. <p>
 * 
 * <b>Test5:</b> ChatMustHaveTwoDifferentAddresses<p>
 * There should be a simple test that should verify if the chat "links" two different machines. <p>
 *
 * <b>Test6:</b> ChatMustNotHaveNullMessages<p>
 * There should be a simple test that should verify if the message to add to the chat is null. <p>
 * 
 * <b>Test7:</b> ChatListMustNotHaveNullChats<p>
 * There should be a simple test that should verify if the chat to add to the chatList is null. <p>
 * 
 * <b>Design</b><p>
 * First model regarding the design.
 * 
 * <img src="ipc_05_1_design2.png" alt="image"> 
 * <img src="ipc_05_1_design3.png" alt="image"> 
 * <p>
 * Design that explains how the extension functionality works.
 * 
 * <p>
 * <img src="ipc_05_1_design.png" alt="image"> 
 * <p>
 * 
 * @author Barros
 */
package lapr4.red.s1.ipc.n1151117.chatApplication;

