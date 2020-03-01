import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class HelloClient {
  public static void main(String [] args) {
	
	try {
	  if (args.length < 2) {
	   System.out.println("Usage: java HelloClient <rmiregistry host> <clientname>");
	   return;}

	String host = args[0];
	String name = args[1];

	Info_itfImpl info = new Info_itfImpl(name);
	Info_itf info_stub = (Info_itf) UnicastRemoteObject.exportObject(info, 0);

	

	// Register the remote object in RMI registry with a given identifier
	

	// Get remote object reference
	Registry registry = LocateRegistry.getRegistry(host); 
	// registry.rebind("getClientName", info_stub);
	Hello h = (Hello) registry.lookup("HelloService");

	// Remote method invocation
	String res = h.sayHello(info_stub);
	// String res = h.sayHello(name);
	System.out.println(res);

	} catch (Exception e)  {
		System.err.println("Error on client: " + e);
	}
  }
}