
import java.rmi.*;

public  class HelloImpl implements Hello {

	private String message;

	public HelloImpl(String s) {
		message = s ;
	}

	public String sayHello(Registry_itf reg, Accounting_itf acc) throws RemoteException {
		reg.register(acc);
		
		String name = acc.getAccName();
		int isLimit = reg.getNumCalls(name);
		if(isLimit != 0) { return name+ " " +message ; }
		return "limit reached";
	}
}

