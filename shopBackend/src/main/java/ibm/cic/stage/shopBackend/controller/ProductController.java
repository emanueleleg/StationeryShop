package ibm.cic.stage.shopBackend.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import ibm.cic.stage.shopBackend.service.impl.BrandServiceImpl;
import ibm.cic.stage.shopBackend.service.impl.CategoryServiceImpl;
import ibm.cic.stage.shopBackend.service.impl.ProductPreviewServiceImpl;
import ibm.cic.stage.shopBackend.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@Tag(name = "ProductController", description = "Controller contenente i metodi per ottenere dati sui prodotti")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired
	private BrandServiceImpl brandService;
	
	@Autowired
	private ProductPreviewServiceImpl productPreviewService;
	

	
	@GetMapping(value = "/products", produces="application/json")
	@Operation(summary = "Restituisce un elenco di tutti i prodotti",
			   description = "Contiene i prodotti e tutti i dati ad essi relativi, come immagini, brand e categoria a cui appartengono")
	public String getProducts() throws JsonProcessingException {
		return productService.getProducts();
	}
	
	@GetMapping(value = "/categories", produces="application/json")
	public String getCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping(value = "/brands", produces="application/json")
	public String getBrands() {
		return brandService.getBrands();
	}
	
	@GetMapping(value = "/productImages", produces="application/json")
	public String getOrderedImgGroupByProd() {
		return productPreviewService.getOrderedImagesByProd();
	}
	
}
