package ibm.cic.stage.shopBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ibm.cic.stage.shopBackend.service.impl.ProductPreviewServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(
		name = "ProductPreviewController", 
		description = "Controller contenente i metodi per ottenere le immagini dei prodotti o altre informazioni su di essi."
	)
@RestController
@CrossOrigin
public class ProductPreviewController {
	
	
	
	@Autowired
	private ProductPreviewServiceImpl productPreviewService;
	
	
	
	@GetMapping(value = "/productImages", produces="application/json")
	@Operation(summary = "Restituisce un elenco di tutte le immagini dei prodotti",
	   description = "Fornisce i link e altri dettagli delle immagini dei prodotti")
	@ApiResponse(
			responseCode = "200", 
			description = "Lista delle immagini dei prodotti recuperata correttamente"
			)
	public String getOrderedImgGroupByProd() {
		return productPreviewService.getOrderedImagesByProd();
	}

}
