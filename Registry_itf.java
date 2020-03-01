import java.rmi.*;

public interface Registry_itf extends Remote {
    public void register(Accounting_itf client)  throws RemoteException;
    public int getNumCalls(String name) throws RemoteException;
}