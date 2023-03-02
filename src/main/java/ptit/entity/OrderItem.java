package ptit.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the orderItem database table.
 * 
 */
@Entity
@Table(name="orderItem")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long orderItemID;

	private BigDecimal price;

	private long productID;

	private int quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderID")
	private Order order;

	public OrderItem() {
	}

	public long getOrderItemID() {
		return this.orderItemID;
	}

	public void setOrderItemID(long orderItemID) {
		this.orderItemID = orderItemID;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getProductID() {
		return this.productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}