package ptit.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="listImage")
public class ListImage implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long listImageID;
	
	@Lob
	@Column(name = "images",length = Integer.MAX_VALUE, nullable = true)
	private byte[] images;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productID")
    private Product product;

	public ListImage(Long listImageID, byte[] images, Long productID, Product product) {
		super();
		this.listImageID = listImageID;
		this.images = images;
		this.product = product;
	}

	public Long getListImageID() {
		return listImageID;
	}

	public void setListImageID(Long listImageID) {
		this.listImageID = listImageID;
	}

	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
    
}
