package ptit.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cartItem database table.
 * 
 */
@Entity
@Table(name="cartItem")
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartItemID;

	private Long price;

	public long getCartItemID() {
		return cartItemID;
	}

	public void setCartItemID(long cartItemID) {
		this.cartItemID = cartItemID;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productID")
	private Product product;

	private long quantity;

	//bi-directional many-to-one association to Cart
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cartID")
	private Cart cart;

	public CartItem() {
	}
	


}