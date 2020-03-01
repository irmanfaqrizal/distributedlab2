
import java.rmi.*;

public  class Hello2Impl implements Hello2 {

	private String message;
    private int num;

	public Hello2Impl(String s) {
        message = s ;
        num = 0;
	}

	public String sayHello(Accounting_itf client) throws RemoteException {
        num++;
        client.numberOfCalls(num);
        return "call [" + num + "] : " + message;
	}
}

