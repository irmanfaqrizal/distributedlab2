
import java.rmi.*;

public  class Info_itfImpl implements Info_itf {

	private String clientName;
 
	public Info_itfImpl(String s) {
		clientName = s ;
	}

	public String getName() throws RemoteException {
		return clientName;
	}
}

