package ibm.cic.stage.shopBackend.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Java Persistence API utility class.
 * The only method in this class is used to obtain a EntityManagerFactory object.
 *
 */
public class JPAUtils {
	
	private static final String PERSISTENCE_UNIT_NAME = "shop-punit";
	private static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		
	    if (entityManagerFactory == null) 
	        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    
	    return entityManagerFactory;
	}
	
}
