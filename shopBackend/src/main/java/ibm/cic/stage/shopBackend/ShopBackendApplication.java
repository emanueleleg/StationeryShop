package ibm.cic.stage.shopBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import io.swagger.v3.oas.annotations.ExternalDocumentation;
//import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import springfox.documentation.swagger2.mappers.ModelMapper;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Documentazione delle API del progetto StationeryShop",
				description = "Documentazione delle REST API Spring Boot relative al progetto StationeryShop",
				version = "v1.0",
				contact = @Contact(
						name = "Emanuele G. Legrottaglie",
						email = "legrottaglie.em@gmail.com"
						//,url = ""
				)
				/*,license = @License(
						name = "Nome della licenza",
						url = "url della licenza"
				)*/
		)/*,
		externalDocs = @ExternalDocumentation(
				description = "Link per visualizzare della documentazione esterna.",
				url = "https://www.javaguides.net/user_management.html"
		)*/
)
public class ShopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopBackendApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper() {
		};
	}

}
