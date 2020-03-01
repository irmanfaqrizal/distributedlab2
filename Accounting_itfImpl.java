
import java.rmi.*;

public  class Accounting_itfImpl implements Accounting_itf {

	private int numCalls;
 
	public Accounting_itfImpl() {
		numCalls = 0;
	}

	public void numberOfCalls(int number) throws RemoteException {
		numCalls = number;
	}
}

