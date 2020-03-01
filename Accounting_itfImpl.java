
import java.rmi.*;

public  class Accounting_itfImpl implements Accounting_itf {

	private String clientName;
	private int numCalls;

	public Accounting_itfImpl(String name) {
		clientName = name;
		numCalls = 0;
	}

	public void numberOfCalls(int number) throws RemoteException {
		numCalls = number;
	}

	public String getAccName() throws RemoteException {
		return clientName;
	}
}

