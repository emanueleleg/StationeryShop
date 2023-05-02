package ibm.cic.stage.shopBackend;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ibm.cic.stage.shopBackend.entity.Product;

public class Main {
	
	
	public static void main(String[] args) throws JsonProcessingException {
		Dao dao = new Dao();
		
		
		List<Product> res = dao.getProducts();
		
		
	    ObjectMapper mapper = new ObjectMapper(); 
	    String simpleJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res); 
	    
	    System.out.println(simpleJSON);
	}

}