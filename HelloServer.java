
import java.rmi.*; 
import java.rmi.server.*; 
import java.rmi.registry.*;

public class HelloServer {

  public static void  main(String [] args) {
	  try {
			if (args.length < 1) {
				System.out.println("Usage: java HelloServer <number of 'hello' calls allowed>");
				return;
			}
		 	int numberOfHellos = Integer.parseInt(args[0]);
			// Create a Hello remote object
			HelloImpl h = new HelloImpl ("Hello world !");
			Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);

			// create hello2
			Hello2Impl h2 = new Hello2Impl("Hello count : ");
			Hello2 h2_stub = (Hello2) UnicastRemoteObject.exportObject(h2, 0);

			// create registry
			Registry_itfImpl reg = new Registry_itfImpl(numberOfHellos);
			Registry_itf reg_stub = (Registry_itf) UnicastRemoteObject.exportObject(reg, 0);

			// Register the remote object in RMI registry with a given identifier
			Registry registry= LocateRegistry.getRegistry(); 
			registry.rebind("HelloService", h_stub);
			registry.rebind("Hello2Service", h2_stub);
			registry.rebind("RegistryService", reg_stub);

			System.out.println ("Server ready");

	  } catch (Exception e) {
		  System.err.println("Error on server :" + e) ;
		  e.printStackTrace();
	  }
  }
}
