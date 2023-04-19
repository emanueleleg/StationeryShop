package ibm.cic.stage.shopBackend;

import java.util.List;

import ibm.cic.stage.shopBackend.entity.Product;

public class Main {
	
	
	public static void main(String[] args) {
		Dao dao = new Dao();
		
		List<Product> res = dao.getProducts();
		
		for(Product i: res) {
			System.out.println(i.getProductName());
		}
	}

}
