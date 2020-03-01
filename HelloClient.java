import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class HelloClient {
  public static void main(String [] args) {
	
	try {
	  	if (args.length < 3) {
	   		System.out.println("Usage: java HelloClient <rmiregistry host> <clientname> <number of 'hello' calls>");
			   return;
		}

		String host = args[0];
		String name = args[1];
		int numberOfHellos = Integer.parseInt(args[2]);

		// Info_itfImpl info = new Info_itfImpl(name);
		// Info_itf info_stub = (Info_itf) UnicastRemoteObject.exportObject(info, 0);

		Accounting_itfImpl acc = new Accounting_itfImpl(name);
		Accounting_itf acc_stub = (Accounting_itf) UnicastRemoteObject.exportObject(acc, 0);

		// Get remote object reference
		Registry registry = LocateRegistry.getRegistry(host); 
		Hello h = (Hello) registry.lookup("HelloService");
		Hello2 h2 = (Hello2) registry.lookup("Hello2Service");
		Registry_itf reg = (Registry_itf) registry.lookup("RegistryService");

		for(int i = 0; i < numberOfHellos; i++){
			String res = h.sayHello(reg, acc_stub);
			String res2 = h2.sayHello(acc_stub, reg);
			System.out.println(res);
			if(res.equals("limit reached")){break;}
			System.out.println(res2);
		}

	} catch (Exception e)  {
		System.err.println("Error on client: " + e);
	}
  }
}