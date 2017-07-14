/**
 * Technical documentation regarding the user story IPC08.1: Start Sharing. 
 * <p>
 * 
 * 
 * <b>Analysis</b><p>
 * <img src="IPC08.1_UDP_file_sharing.png" alt="image"><p>
 * This extension should allow the user to share files with with ohter instances of Cleansheets in the same network.<p>
 * This extension opens a sidebar that allows the user to send all files under a specified directory.<p>
 * The files that are going to be shared show up in a list in the sidebar( name and size).<p>
 * The users that receive the files will see the files that are available to download in a separate list in the sidebar.<p>
 * The receiving users can set up a directory to download the files and this download path should be persistent.<p>
 * Each file available to download has a name, size, source,and download status.<p>
 * Its not required to implement the actual download functionality yet.<p>

 * <b>Tests</b><p>
 * 
 * <b>Test1:</b> 
 * Shared Directory must not be empty
 * 
 *  * <b>Design</b><p>
 * <img src="IPC08.1_UDP_file_sharing_Sender_SD.png" alt="image"><p>
 * <img src="IPC08.1_UDP_file_sharing_Reciever_SD.png" alt="image"><p>
 * 
 * 
 * 
 * @author Tiago Vilaça - 1140412@isep.ipp.pt 
 */
package lapr4.red.s1.ipc.n1140412.fileSharing;
