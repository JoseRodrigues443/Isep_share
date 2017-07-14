/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150524.automaticDownload.persistence;

import eapli.framework.persistence.repositories.Repository;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.permanentDownload.PermanentFile;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 *
 * @author Filipe Correia <1150524@isep.ipp.pt>
 */
public interface UpdatableFilesRepository extends Repository<PermanentFile, Long>{
    
    Iterable<PermanentFile> getAllPermanentFiles(NetworkAddress address);
    
}
