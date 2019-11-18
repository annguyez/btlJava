package com.gr21.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="orders_detail")
public class Orders_detail {	
	@EmbeddedId
	Orders_detail_id orders_detail_id;
	@Embeddable
	  public static class Orders_detail_id implements Serializable {
	    int orders_id;
		String product_detail_id;
		public int getOrders_id() {
			return orders_id;
		}
		public void setOrders_id(int orders_id) {
			this.orders_id = orders_id;
		}
		public String getProduct_detail_id() {
			return product_detail_id;
		}
		public void setProduct_detail_id(String i) {
			this.product_detail_id = i;
		}
		
	  }
	
	int quantity;
	String price;
	
	public Orders_detail_id getOrders_detail_id() {
		return orders_detail_id;
	}
	public void setOrders_detail_id(Orders_detail_id orders_detail_id) {
		this.orders_detail_id = orders_detail_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

	
	

}
