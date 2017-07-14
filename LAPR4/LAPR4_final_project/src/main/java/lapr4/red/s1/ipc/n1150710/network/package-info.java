/**
 * Technical documentation regarding the user story IPC01.1: Start Sharing.
 * <p>
 *
 * <b>Attention: This feature increment and this documentation are work in
 * progress! You should question what is already done!</b><p>
 *
 * <b>Requirement</b><p>
 * Statement:
 * <p>
 * It should be possible to establish a connection with other instance of
 * Cleansheets in the local network. It should be possible to send the contents
 * of a range of cells to another instance of Cleansheets. The other instance
 * should display the received contents in the same cell address as the original
 * cells. It should be possible to configure the port to be used for network
 * connections. It should be possible to find other instances of Cleansheets
 * available in e local network. These instances should be listed in a new
 * window (sidebar window). The user should be able to select one of the
 * discovered instances to connect to when establishing the connection to send
 * the contents of the range of cells. At the moment it is only required to send
 * the value of the cells.
 *
 * Notes:
 *
 * It will be needed a UDP broadcast to advertise the instance of a machine A
 * TCP connection will be created to send or receive cells
 *
 *
 *
 * <p>
 * The same TCP connection should be shared by all the communication
 * functionalities of the Cleansheets application.
 * <p>
 * There should be a specific port to respond to UDP datagrams broadcasted by
 * clients to discover instances of Cleansheets in the local network.
 * <p>
 *
 *
 * <b>Analysis</b><p>
 *
 * Usage: User selects cells and activate extension. System shows computers in
 * network. User selects computer. System warns that the cells were shared. User
 * close list.
 *
 * <b>SSD:<b>
 * <img src="IPC01.1_ssd.png" alt="image">
 *
 *
 *
 * <b>Notes:</b><p>
 *
 * The TCP and UDP utilites are implemented in the package:
 * lapr4.red.s1.ipc.network.library See that package for more information about
 * UDP and TCP connections
 *
 *
 *
 *
 * Class ConnectionUDP: Responsible of broadcasting or receiving UDP
 * packages/string.<p>
 *
 * Class TextConnectionTCP: Responsible by TCP text sent via TCP protococol.<p>
 * 
 * Class TextConnection.SenderTCP: responsible to send text via TCP
 * 
 * Class: TextConnection.ReceiverTCP : responsible to receive text via TCP
 * 
 *
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also
 * use case tests (e.g., like in the TDD approach).
 * <p>
 *
 * <b>Test1:</b> BaseEchoCommunicationTest<p>
 * There should be a simple echo service that should return the echo of each
 * message received.<p>
 * See Package lapr4.black.s1.ipc.n2345678.comm:
 * <p>
 * BaseEchoCommunicationTest, EchoClientHandler, EchoDTO, EchoServerHandler<p>
 *
 * <b>Test2:</b> ShareCellTest<p>
 * Test the initial connection regarding the sharing of the contents of a range
 * of cells. Should we move/refactor this test to Acceptance Test?
 * <p>
 * See Package lapr4.black.s1.ipc.n2345678.comm.sharecells:
 * <p>
 * ShareCellsTest<p>
 *
 *
 *
 * <b>Design</b><p>
 * First draft regarding the design.<p>
 * Will start by illustrating a scenario regarding the use of the CommWorker
 * class.<p>
 * <b>Important Note:</b> Maybe all this functionality should be integrated with
 * the extensions. For instance, extensions could "register" communication
 * servers and asynchronous client handlers. The data (i.e. DTO) would be
 * dispatched according to its type<p>
 *
 * <img src="IPC01.1_UDP_sender_update.png" alt="image">
 * 
 * 
 * <img src="IPC01.1_UDP_machineList_update.png" alt="image">
 * 
 * 
 * <img src="IPC01.1_TCP_send_cell.png" alt="image">
 * 
 * 
 * <img src="IPC01.1_TCP_receive_Cell_update.png" alt="image">
 * <p>
 *
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.red.s1.ipc.n1150710.network:

 *
 *
 * @author 1150710@isep.ipp
 */
package lapr4.red.s1.ipc.n1150710.network;
