/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150524.automaticDownload.permanentDownload;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 * Everytime a new permanent file is downloaded, a new Object of this tipe is
 * created This object ensures the data regarding this file is saved in the
 * Server's database
 *
 * @author Filipe Correia <1150524@isep.ipp.pt>
 */
@Entity
public class PermanentFile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The destination's ip address
     */
    private NetworkAddress ip;

    /**
     * The server's path to the file that was sent
     */
    private String filePath;

    /**
     * False, this is the first time the file is sent. True, the file was
     * changed, thus the downloaded file must be refreshed
     */
    private boolean update;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdated;

    public PermanentFile() {
    }

    public PermanentFile(NetworkAddress ip, String filePath, boolean update, Date lastUpdated) {
        this.ip = ip;
        this.filePath = filePath;
        this.update = update;
        this.lastUpdated = lastUpdated;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
    /**
     * Method that checks if this is the object for the first time download or a
     * refresh of an already downloaded file
     *
     * @return boolean checking if the file is or not an update
     */
    public boolean isUpdate() {
        return update;
    }

    /**
     * Returns this object's "ip"
     *
     * @return this object's "ip"
     */
    public NetworkAddress getIp() {
        return ip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermanentFile)) {
            return false;
        }
        PermanentFile other = (PermanentFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lapr4.blue.s2.ipc.n1150524.automaticDownload.permanentDownload.permanentObject[ id=" + id + " ]";
    }

}
