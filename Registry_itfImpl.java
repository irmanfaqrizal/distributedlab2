
import java.rmi.*;
import java.util.HashMap;

public  class Registry_itfImpl implements Registry_itf {
    private int limit;
    HashMap<String, Integer> clients;
    
	public Registry_itfImpl(int callLimit) throws RemoteException {
        limit = callLimit;
        clients = new HashMap<String, Integer>();
	}

	public void register(Accounting_itf client) throws RemoteException {
        String name = client.getAccName();
        if(clients.get(name) == null) {
            clients.put(name, 1);
        }
        else if (clients.get(name) >= limit){
            clients.put(name, 0);
        }
        else {
            Integer newNumber = clients.get(name)+1;
            clients.put(name, newNumber);
        }
    }
    
    public int getNumCalls(String name) throws RemoteException {
        return clients.get(name);
    }
}

