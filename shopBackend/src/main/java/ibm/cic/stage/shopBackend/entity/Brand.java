package ibm.cic.stage.shopBackend.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "brand")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id")
	private int brandId;
	
	@Column(name = "brand_name")
	private String brandName;

	@JsonBackReference
	@ManyToMany(mappedBy = "brands")
	private List<Product> productsList;
	
	
	
	public Brand() {}
	
	
	public Brand(int brandId, String brandName) {
		this.brandId = brandId;
		this.brandName = brandName;
	}

	
	
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}



	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + "]";
	}
	
	
	
	
	

}
