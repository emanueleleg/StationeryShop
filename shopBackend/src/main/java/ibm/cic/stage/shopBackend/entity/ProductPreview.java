package ibm.cic.stage.shopBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "product_preview")
public class ProductPreview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_preview_id")
	private int productPreviewId;
	
	@Column(name = "src")
	private String src;
	
	@Column(name = "isCover")
	private int isCover;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public ProductPreview() {}

	public ProductPreview(int productPreviewId, String src, int isCover, Product product) {
		this.productPreviewId = productPreviewId;
		this.src = src;
		this.isCover = isCover;
		this.product = product;
	}

	public int getProductPreviewId() {
		return productPreviewId;
	}

	public void setProductPreviewId(int productPreviewId) {
		this.productPreviewId = productPreviewId;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public int getIsCover() {
		return isCover;
	}

	public void setIsCover(int isCover) {
		this.isCover = isCover;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductPreview [productPreviewId=" + productPreviewId + ", src=" + src + ", isCover=" + isCover
				+ ", productId=" + product.getProductId() + "]";
	}
	
	
	
	
	
	

}
