/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150524.automaticDownload.extension;

import csheets.ext.Extension;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.application.FileTransferController;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.permanentDownload.PermanentFile;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.persistence.JpaUpdatableFilesRepository;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.ConnectionManagerFileTransfer;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 *
 * @author Filipe Correia <1150524@isep.ipp.pt>
 */
public class AutomaticUpdateExtension {

    public AutomaticUpdateExtension(FileTransferController ftc) throws InstantiationException, IllegalAccessException {

        FileChecker fc = new FileChecker(ftc);

        fc.start();

    }

    public class FileChecker extends Thread {

        ConnectionManagerFileTransfer cm;
        
        int tcpPort;

        List<PermanentFile> updatableFiles = new ArrayList<>();
        JpaUpdatableFilesRepository repo;

        public FileChecker(FileTransferController ftc) {
            cm = new ConnectionManagerFileTransfer(ftc);
        }

        @Override
        public void run() {

            try {

                repo = JpaUpdatableFilesRepository.class.newInstance();

                for (PermanentFile pF : repo.getAllPermanentFiles(Utils.ownIpAddress())) {

                    File f = new File(pF.getFilePath());

                    Date d = new Date(f.lastModified());

                    if (d.after(pF.getLastUpdated())) {
                        
                        String msg = "@FileTransfer@TCP@Update@" + pF.getFilePath() +  "@" + Utils.ownIpAddress().getAddress() +"@" + tcpPort + "@";
                        
                        cm.sendTcp(msg, tcpPort, pF.getIp());
                        
                    }

                }

            } catch (IllegalAccessException ex) {
                Logger.getLogger(AutomaticUpdateExtension.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(AutomaticUpdateExtension.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
