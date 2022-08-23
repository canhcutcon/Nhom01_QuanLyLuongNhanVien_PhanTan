package UI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;



public class Server {

	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			String config = "rmi://DESKTOP-JI4LMH5:9999";
			LocateRegistry.createRegistry(9999);

			System.out.println("Server stated at " + LocalDateTime.now());
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
