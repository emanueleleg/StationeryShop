package ibm.cic.stage.shopBackend.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import ibm.cic.stage.shopBackend.entity.Product;
import ibm.cic.stage.shopBackend.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;




@Tag(
		name = "ProductController", 
		description = "Controller contenente i metodi per ottenere dati sui prodotti"
	)
@RestController
@CrossOrigin
public class ProductController {
	
	
	@Autowired
	private ProductServiceImpl productService;
	

	
	@GetMapping(value = "/products", produces="application/json")
	@Operation(summary = "Restituisce un elenco di tutti i prodotti",
			   description = "Contiene i prodotti e tutti i dati ad essi relativi, come immagini, brand e categoria a cui appartengono")
	@ApiResponse(
			responseCode = "200", 
			description = "Lista dei prodotti recuperata correttamente",
			content = @Content(
						mediaType = MediaType.APPLICATION_JSON_VALUE,
						schema = @Schema(implementation = Product.class)
					
					)
			)
	public String getProducts() throws JsonProcessingException {
		return productService.getProducts();
	}
	

	

	

	
}
