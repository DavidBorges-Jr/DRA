package connectionfactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory entityManagerFactory;
        
	public static EntityManager getEntityManager(){
            if(entityManagerFactory==null|| !entityManagerFactory.isOpen()){
                System.out.println("Criando EntityManager....");
                entityManagerFactory = Persistence.createEntityManagerFactory("xxx");
            }
            return entityManagerFactory.createEntityManager();
	}
        
        public static void closeEntityFactory(){
            entityManagerFactory.close();
        }
	
}