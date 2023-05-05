package ibm.cic.stage.shopBackend;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import ibm.cic.stage.shopBackend.entity.Brand;
import ibm.cic.stage.shopBackend.entity.Category;
import ibm.cic.stage.shopBackend.entity.Product;
import ibm.cic.stage.shopBackend.entity.ProductPreview;
import ibm.cic.stage.shopBackend.utils.JPAUtils;

@Repository
public class Dao {
	
	 
	
	public List<Product> getProducts() {
		
		EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
		List<Product> result = null;
		
		try {
			TypedQuery<Product> q = entityManager.createQuery("SELECT p FROM Product p", Product.class);
			result =  q.getResultList();
			for(Product i: result) {
				Hibernate.initialize(i.getProductPreviewList());

			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
		return result;
	}
	
	
	public List<Category> getCategories() {
		
		EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
		List<Category> result = null;
		
		try {
			TypedQuery<Category> q = entityManager.createQuery("SELECT c FROM Category c", Category.class);
			result =  q.getResultList();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
		
		return result;		
	}
	
	
	public List<Brand> getBrands() {
		
		EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
		List<Brand> result = null;
		
		try {
			TypedQuery<Brand> q = entityManager.createQuery("SELECT b FROM Brand b", Brand.class);
			result =  q.getResultList();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
		
		return result;		
	}
	
	
	public List<ProductPreview> getOrderedImagesByProd(){
		
		EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
		List<ProductPreview> result = null;
		
		try {
			TypedQuery<ProductPreview> q = entityManager.createQuery("SELECT pp FROM ProductPreview pp ORDER BY pp.imgIndex DESC ", ProductPreview.class);
			result =  q.getResultList();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
		
		return result;
		
	}


}
