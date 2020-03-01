import java.rmi.*;

public interface Hello2 extends Remote {
	public String sayHello(Accounting_itf client, Registry_itf reg)  throws RemoteException;
}

