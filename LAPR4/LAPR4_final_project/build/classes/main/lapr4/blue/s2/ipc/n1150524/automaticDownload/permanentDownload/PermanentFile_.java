package lapr4.blue.s2.ipc.n1150524.automaticDownload.permanentDownload;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

@Generated(value="EclipseLink-2.6.1.v20150916-rNA", date="2017-06-21T17:37:18")
@StaticMetamodel(PermanentFile.class)
public class PermanentFile_ { 

    public static volatile SingularAttribute<PermanentFile, Date> lastUpdated;
    public static volatile SingularAttribute<PermanentFile, NetworkAddress> ip;
    public static volatile SingularAttribute<PermanentFile, String> filePath;
    public static volatile SingularAttribute<PermanentFile, Boolean> update;
    public static volatile SingularAttribute<PermanentFile, Long> id;

}