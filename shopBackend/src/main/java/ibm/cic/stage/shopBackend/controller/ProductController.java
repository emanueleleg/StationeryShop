package ibm.cic.stage.shopBackend.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import ibm.cic.stage.shopBackend.service.impl.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping(value = "/products", produces="application/json")
	public String getProducts() throws JsonProcessingException {
		return productService.getProducts();
	}
	
	@GetMapping(value = "/prova")
	public String getTest() {
		return "prova";
	}
	
}
