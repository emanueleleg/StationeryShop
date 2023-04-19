package ibm.cic.stage.shopBackend;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ibm.cic.stage.shopBackend.entity.Product;
import ibm.cic.stage.shopBackend.utils.JPAUtils;

public class Dao {
	
	 
	
	public List<Product> getProducts() {
		
		EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
		List<Product> result = null;
		
		try {
			TypedQuery<Product> q = entityManager.createQuery("SELECT p FROM Product p", Product.class);
			result =  q.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
		return result;
	}


}
