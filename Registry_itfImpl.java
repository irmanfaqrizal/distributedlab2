
import java.rmi.*;

public  class Registry_itfImpl implements Registry_itf {

    private Accounting_itf objClient;
 
	public Registry_itfImpl() throws RemoteException {
        
	}

	public void register(Accounting_itf client) throws RemoteException {
        objClient = client;
	}
}

