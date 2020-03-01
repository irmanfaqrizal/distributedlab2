
import java.rmi.*;

public  class Hello2Impl implements Hello2 {

	private String message;

	public Hello2Impl(String s) {
        message = s ;
	}

	public String sayHello(Accounting_itf client, Registry_itf reg) throws RemoteException {
        int number = reg.getNumCalls(client.getAccName());
        return message + number;
	}
}

