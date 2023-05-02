package ibm.cic.stage.shopBackend.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import ibm.cic.stage.shopBackend.service.impl.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@CrossOrigin
	@GetMapping(value = "/products", produces="application/json")
	public String getProducts() throws JsonProcessingException {
		return productService.getProducts();
	}
	
	@CrossOrigin
	@GetMapping(value = "/categories", produces="application/json")
	public String getCategories() {
		return productService.getCategories();
	}
	
	@CrossOrigin
	@GetMapping(value = "/brands", produces="application/json")
	public String getBrands() {
		return productService.getBrands();
	}
	
}
