package com.gr21.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_detail")
public class Product_detail {
	@Id
	String product_detail_id;
	
	
	@OneToOne
	@JoinColumn(name="product_id", referencedColumnName = "product_id")
	
	Product product;
	@OneToOne
	@JoinColumn(name="size_id",referencedColumnName = "size_id")
	Size size;	
	
	@OneToOne
	@JoinColumn(name="color_id",referencedColumnName = "color_id")
	Color color;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="product_detail_id",referencedColumnName = "product_detail_id")
	Set<Orders_detail> orders_detail;
	
	int quantity;
	
	
	public String getProduct_detail_id() {
		return product_detail_id;
	}
	public void setProduct_detail_id(String product_detail_id) {
		this.product_detail_id = product_detail_id;
	}
	public Set<Orders_detail> getOrders_detail() {
		return orders_detail;
	}
	public void setOrders_detail(Set<Orders_detail> orders_detail) {
		this.orders_detail = orders_detail;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
