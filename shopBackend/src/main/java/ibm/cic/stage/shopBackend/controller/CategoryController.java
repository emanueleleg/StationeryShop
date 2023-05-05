package ibm.cic.stage.shopBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ibm.cic.stage.shopBackend.service.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(
		name = "CategoryController", 
		description = "Controller contenente i metodi per ottenere dati sulle categorie dei prodotti"
	)
@RestController
@CrossOrigin
public class CategoryController {
	
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	
	@GetMapping(value = "/categories", produces="application/json")
	@Operation(summary = "Restituisce un elenco di tutte le categorie",
	   description = "Fornisce i nomi e altri dettagli delle categorie a cui appartengono i prodotti")
	@ApiResponse(
			responseCode = "200", 
			description = "Lista delle categorie recuperata correttamente"
			)
	public String getCategories() {
		return categoryService.getCategories();
	}

}
