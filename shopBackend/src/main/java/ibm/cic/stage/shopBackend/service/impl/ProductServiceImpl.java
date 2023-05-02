package ibm.cic.stage.shopBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ibm.cic.stage.shopBackend.Dao;
import ibm.cic.stage.shopBackend.entity.Brand;
import ibm.cic.stage.shopBackend.entity.Category;
import ibm.cic.stage.shopBackend.entity.Product;
import ibm.cic.stage.shopBackend.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private Dao dao;

	@Override
	public String getProducts() {
		ObjectMapper mapper = new ObjectMapper(); 
		List<Product> products = dao.getProducts();
		String result = "";
		
		try {
			result = mapper.writeValueAsString(products);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public String getCategories() {
		ObjectMapper mapper = new ObjectMapper(); 
		List<Category> categories = dao.getCategories();
		String result = "";
		
		try {
			result = mapper.writeValueAsString(categories);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public String getBrands() {
		ObjectMapper mapper = new ObjectMapper(); 
		List<Brand> brands = dao.getBrands();
		String result = "";
		
		try {
			result = mapper.writeValueAsString(brands);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
