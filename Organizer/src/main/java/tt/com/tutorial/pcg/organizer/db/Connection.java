package tt.com.tutorial.pcg.organizer.db;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class Connection {
	 static EntityManagerFactory emf;
	static Map<String, String> persistenceMap = new HashMap<String, String>();
static {
	persistenceMap.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/postgres/");
	persistenceMap.put("javax.persistence.jdbc.user", "postgres");
	persistenceMap.put("javax.persistence.jdbc.password", "postgres");
	persistenceMap.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
	emf = Persistence.createEntityManagerFactory("$objectdb/db/organizer_issues.odb", persistenceMap);
}
	 
	 
	 public static void shutdown() {
		 emf.close();
	 }
	 
	 public static EntityManager getNewconnection() {
		 return emf.createEntityManager();
	 }
}
