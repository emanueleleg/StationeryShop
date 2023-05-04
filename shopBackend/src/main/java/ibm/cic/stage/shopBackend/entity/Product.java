package ibm.cic.stage.shopBackend.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
    @Schema(
            description = "User First Name"
    )
    // User first name should not be null or empty
    @NotEmpty(message = "User first name should not be null or empty")
	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@JsonManagedReference
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private List<ProductPreview> productPreviewList;


	public Product() {}
	
	public Product(int productId, String productName, double price, Brand brand, Category category, List<ProductPreview> productPreviewList) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.brand = brand;
		this.category = category; 
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

	public List<ProductPreview> getProductPreviewList() {
		return productPreviewList;
	}

	public void setProductPreviewList(List<ProductPreview> productPreviewList) {
		this.productPreviewList = productPreviewList;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", brand="
				+ brand + ", category=" + category + ", productPreviewList=" + productPreviewList.toString() + "]";
	}
	
	








	
	
	
	
	

}
