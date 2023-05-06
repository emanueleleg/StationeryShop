package ibm.cic.stage.shopBackend.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(
        description = "Product"
)
@Entity
@Table(name = "product")
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
	
    @Schema(
            description = "Nome del prodotto"
    )
    @NotEmpty(message = "Il nome del prodotto non dovrebbe essere nullo o un campo vuoto")
	@Column(name = "product_name")
	private String productName;

    
    @Schema(
            description = "Prezzo del prodotto"
    )
    @NotEmpty(message = "Il prezzo del prodotto non dovrebbe essere nullo o un campo vuoto")
	@Column(name = "price")
	private double price;
	
    
    @Schema(
            description = "Brand a cui appartiene il prodotto"
    )
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
    		name = "product_brand_category",
    		joinColumns = @JoinColumn(name = "product_id"),
    		inverseJoinColumns = @JoinColumn(name = "brand_id")
    		)   
	private List<Brand> brands;
	
    
    @Schema(
            description = "Categorie a cui appartiene il prodotto"
    )
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
    		name = "product_brand_category",
    		joinColumns = @JoinColumn(name = "product_id"),
    		inverseJoinColumns = @JoinColumn(name = "category_id")
    		)  
	private List<Category> categories;
	 
    
    @Schema(
            description = "Immagini del prodotto"
    )
	@JsonManagedReference
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private List<ProductPreview> productPreviewList;


    
    
	public Product() {}
	
	public Product(int productId, String productName, double price, List<Brand> brands, List<Category> categories, List<ProductPreview> productPreviewList) {

		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.brands = brands;
		this.categories = categories;
		this.productPreviewList = productPreviewList;
	}





	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	public List<ProductPreview> getProductPreviewList() {
		return productPreviewList;
	}

	public void setProductPreviewList(List<ProductPreview> productPreviewList) {
		this.productPreviewList = productPreviewList;
	}


	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}


	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", brands="
				+ brands + ", categories=" + categories + ", productPreviewList=" + productPreviewList + "]";
	}

 
	
	








	
	
	
	
	

}
