/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.blue.s2.ipc.n1150433.networkAnalizer.domain.TrafficAnalizer;

/**
 * TODO: Remove comments after rest of library is pushed.
 *
 * @author 1150710@isep.ipp.pt 1150710 Edited by Débora Costa 1150433
 */
public class FileConnectionTCP {

    private int portNumberTCP;
    private static final int FILE_SIZE_BYTES_DEFAULT = 10000;

    private ServerSocket s;

    public int getTcpPort() {
        return portNumberTCP;
    }

    /**
     * minimum port number that garanties that isnt being used by protocols like
     * http, dns, ssh, etc
     */
    public static final int MINIMUM_PORT_NUMBER_DEFAULT = 9999;

    public FileConnectionTCP(int portNumber) {
        this.portNumberTCP = portNumber;
    }

    public boolean sendFile(File filesToSend) {

        SenderTCP senderTCP = new SenderTCP(filesToSend);
        senderTCP.sendFile();
        return true;
    }

    public File receiveFile(String location, NetworkAddress addressToSend) {
        ReceiverTCP rtcp = new ReceiverTCP(location);
        return rtcp.receiveFile(addressToSend);
    }

    public SenderTCP tcpSender(File fileToSend) {
        SenderTCP a = null;

        try {
            s = new ServerSocket(0);
            portNumberTCP = s.getLocalPort();    // returns the port the system selected
            a = new SenderTCP(fileToSend);
            a.start();
        } catch (IOException ex) {
            Logger.getLogger(ObjectConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return a;
    }

    /**
     * EDITED by Débora Costa (1150433) added the outgoing traffic counter
     * server that send tcp file
     */
    public class SenderTCP extends Thread{

        File fileToSend;

        public SenderTCP(File fileToSend) {
            this.fileToSend = fileToSend;
        }

        public int getTcpPort() {
            return portNumberTCP;
        }

        public boolean sendFile() {
            boolean continueWhile = true;
            while (continueWhile) {
                System.out.println("Waiting for tcp request to send file...");
                try {
                    System.out.println("port number " + portNumberTCP);
                    //Initialize Sockets
                    ServerSocket ssock = new ServerSocket(0);
                    //System.out.println("Port = " + portNumberTCP);
                    //System.out.println("File = " + fileToSend.getAbsolutePath());

                    /**
                     * it blocks until an connection in made
                     */
                    portNumberTCP = ssock.getLocalPort();
                    Socket socket = ssock.accept();
                    FileInputStream fis = new FileInputStream(fileToSend);
                    BufferedInputStream bis = new BufferedInputStream(fis);

                    //Get socket's output stream
                    OutputStream os = socket.getOutputStream();

                    //Read File Contents into contents array
                    byte[] contents;
                    long fileLength = fileToSend.length();
                    long current = 0;

                    long start = System.nanoTime();
                    while (current != fileLength) {
                        int size = FILE_SIZE_BYTES_DEFAULT;
                        if (fileLength - current >= size) {
                            current += size;
                        } else {
                            size = (int) (fileLength - current);
                            current = fileLength;
                        }
                        contents = new byte[size];
                        bis.read(contents, 0, size);
                        os.write(contents);
                        System.out.println("--> Sending file ... " + (current * 100) / fileLength + "% complete!");

                    }

                    os.flush();
                    //File transfer done. Close the socket connection!
                    socket.close();
                    ssock.close();
                    System.out.println("File sent succesfully!");
                    TrafficAnalizer.totalOutgoing();
                    /**
                     * to get out of the while loop
                     */
                    continueWhile = false;

                    return !continueWhile;
                } catch (IOException ex) {
                    ex.printStackTrace();
                    //  Logger.getLogger(FileConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
                    //  System.out.println("Error!!! TCP file error\n--> :" + ex.toString() + "\n--> --> Port: " + portNumberTCP);
                    return false;
                }

            }
            return true;
        }

        @Override
        public void run() {
            try {
                fileSender();
            } catch (IOException ex) {
                Logger.getLogger(FileConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public boolean fileSender() throws IOException{
            Socket sock = s.accept();
            DataOutputStream dout = new DataOutputStream(sock.getOutputStream());

            System.out.println("Sending File: " + fileToSend);

            int sz = (int) fileToSend.length();
            byte[] conteudo = new byte[sz];
            FileInputStream fin = new FileInputStream(fileToSend);
            int read;
            dout.writeUTF(Long.toString(sz));
            dout.flush();
            while ((read = fin.read(conteudo)) != -1) {
                dout.write(conteudo, 0, read);
                dout.flush();
            }
            fin.close();
            dout.flush();

            sock.close();
            s.close();
            System.out.println("Ficheiro enviado com sucesso!");
            return true;

        }

    }

    /**
     * EDITED by Débora Costa (1150433) added the incoming traffic counter
     */
    public class ReceiverTCP extends Thread {

        private final MessageReceiverInterface server;
        String locationToSaveFile;

        public ReceiverTCP(String locationToSave) {
            this.locationToSaveFile = locationToSave;
            this.server = null;
        }

        public ReceiverTCP(ServerSocket s, MessageReceiverInterface server) {
            this.server = server;
            locationToSaveFile = "";
            portNumberTCP = s.getLocalPort();
        }

        public int getTcpPort() {
            return portNumberTCP;
        }

        public File receiveFile(NetworkAddress addressOfFileServer) {
            File toReturn = null;
            //Initialize socket, for connect to server address and tcp port
            try {
                Socket socket;
                /**
                 * request for server and address and port
                 */
                socket = new Socket(addressOfFileServer.getAddress(), portNumberTCP);
                byte[] contents = new byte[10000];

                //Initialize the FileOutputStream to the output file's full path.
                FileOutputStream fos = new FileOutputStream(locationToSaveFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                InputStream is = socket.getInputStream();

                //No of bytes read in one read() call
                int bytesRead = 0;
                System.out.println("AEFINASDFIONSDFIOGNSDUIOBNSGUOBNIONSRGIOSEGNSRGKNGPISRONGFPIOSNPFGIONSEGPINSEGPI");
                while ((bytesRead = is.read(contents)) != -1) {
                    bos.write(contents, 0, bytesRead);
                }
                bos.flush();
                toReturn = new File(locationToSaveFile);
                System.out.println("!!!!! --> #### --> File saved successfully!  »»»» " + toReturn.getAbsolutePath());
                TrafficAnalizer.totalIncoming();
            } catch (IOException e) {
                Logger.getLogger(FileConnectionTCP.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("--> ERROR: " + e.toString());
            }

            return toReturn;
        }

    }
}
