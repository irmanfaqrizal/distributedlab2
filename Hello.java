import java.rmi.*;

public interface Hello extends Remote {
	public String sayHello(Registry_itf reg, Accounting_itf acc)  throws RemoteException;
}

