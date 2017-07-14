/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150524.automaticDownload.persistence;

import java.util.HashMap;
import java.util.Map;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.permanentDownload.PermanentFile;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.jpa.CrmJpaRepositoryBase;

/**
 *
 * @author Filipe Correia <1150524@isep.ipp.pt>
 */
public class JpaUpdatableFilesRepository extends CrmJpaRepositoryBase<PermanentFile, Long> implements UpdatableFilesRepository {

    public JpaUpdatableFilesRepository(ExtensionSettings settings) {
        super(settings);
    }

    @Override
    public Iterable<PermanentFile> getAllPermanentFiles(NetworkAddress address) {
        Map<String, Object> params =  new HashMap<>();
        params.put("otherIp", address);
        return match("e.ip not in :otherIp", params);
    }

}
