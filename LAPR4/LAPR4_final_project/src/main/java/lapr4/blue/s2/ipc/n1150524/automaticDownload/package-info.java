/**
 * Technical documentation regarding the user story IPC8.2: Automatic Download.
 * <p>
 * 
 * <b>Attention: This feature increment and this documentation are work in progress! You should question what is already done!</b><p>
 * 
 * <b>Requirement</b>
 * Statement:<p>
 * A user should be able to download files.<p>
 * A user should be able to see the progress of a download<p>
 * A user should be able to have files automatically sync'd with the host<p>
 * 
 * <b>Analisys</b><p>
 * <img src="ssd82.png" alt="image"><p>
 * 
 * <b>Questions:</b><p>
 * How permanent is the "permanent" file, as in is there anyway to cancel the source refresh?;<p>
 * R: No answer was obtained, so an eventual cancelation was left off of the design.<p>
 * 
 * <b>Glossary:</b><p>
 * One time download - A file that is downloaded by a user. <p>
 * Permanent download - A file that is downloaded by a user and will allways be updated with the source file, as long as the app is running. <p>
 * Overwritte - To write the file data replacing the pre-existing one <p>
 * 
 * <b> Description: </b><p>
 * The file download must now be implemented, using as a base what was implemented in the former sprint.<p>
 * The file download must be implemented without blocking the main app, so threads will be a must.<p>
 * A new window for displaying the progress of a download is required. <p>
 * This window will launch immediatly after the user presses the download button and it shall feature the file name and the progress.<p>
 * The user will have a dialog window asking if the download is "one time" or permanent.<p>
 * In case the user has permanent downloads, he will be prompted with a dialog each time the source file is updated, asking if he wants to overwrite.<p>
 * 
 * <b>Design: </b><p>
 * 
 * Sequence diagram<p>
 * <img src="sd82.png" alt="image"><p>
 * 
 * 
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.blue.s2.ipc.n1150524.automaticDownload:<p>
 * {@link lapr4.blue.s2.ipc.n1150524.automaticDownload.ConnectionManagerFileTransfer}
 * {@link lapr4.blue.s2.ipc.n1150524.automaticDownload.NetworkMachinesTcpPortsList}
 * <p>
 * Package lapr4.blue.s2.ipc.n1150524.automaticDownload.application:<p>
 * {@link lapr4.blue.s2.ipc.n1150524.automaticDownload.application.FileTransferController}<p>
 * 
 * Package lapr4.blue.s2.ipc.n1150524.automaticDownload.permanentDownload:<p>
 * {@link lapr4.blue.s2.ipc.n1150524.automaticDownload.permanentDownload.FileSender}<p>
 * 
 * Package lapr4.blue.s2.ipc.n1150524.automaticDownload.Persistence:<p>
 * {@link lapr4.blue.s2.ipc.n1150524.automaticDownload.Persistence.JpaUpdatableFilesRepository}<p>
 * {@link lapr4.blue.s2.ipc.n1150524.automaticDownload.Persistence.UpdatableFilesRepository}<p>
 * <p>
 * Package lapr4.blue.s2.ipc.n1150524.automaticDownload.ui<p>
 * {@link lapr4.blue.s2.ipc.n1150524.automaticDownload.ui.DownloadProgressUI}
 * 
 */
package lapr4.blue.s2.ipc.n1150524.automaticDownload;
