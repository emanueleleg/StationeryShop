package ibm.cic.stage.shopBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ibm.cic.stage.shopBackend.service.impl.BrandServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(
		name = "BrandController", 
		description = "Controller contenente i metodi per ottenere dati sui brand dei prodotti"
	)
@RestController
@CrossOrigin
public class BrandController {
	
	
	@Autowired
	private BrandServiceImpl brandService;
	
	
	@GetMapping(value = "/brands", produces="application/json")
	@Operation(summary = "Restituisce un elenco di tutti i brand",
	   description = "Fornisce i nomi e altri dettagli dei brand dei prodotti")
	@ApiResponse(
			responseCode = "200", 
			description = "Lista dei brand recuperata correttamente"
			)
	public String getBrands() {
		return brandService.getBrands();
	}

}
