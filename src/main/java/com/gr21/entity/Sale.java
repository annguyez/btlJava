package com.gr21.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="sale")
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sale_id;
	String sale_name;
	int  discount; 
	String sale_start;
	String sale_end;
	String descriptions;
	String sale_images;
	@ManyToMany
	@JoinTable(name="sale_detail",
		joinColumns = @JoinColumn(name="sale_id",referencedColumnName = "sale_id"),
		inverseJoinColumns = @JoinColumn(name="product_id",referencedColumnName = "product_id")
			)
	Set<Product> products;
	
	public int getDiscount() {
		return discount;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getSale_id() {
		return sale_id;
	}
	public String getSale_name() {
		return sale_name;
	}
	public String getSale_start() {
		return sale_start;
	}
	public String getSale_end() {
		return sale_end;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public String getSale_images() {
		return sale_images;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public void setSale_name(String sale_name) {
		this.sale_name = sale_name;
	}
	public void setSale_start(String sale_start) {
		this.sale_start = sale_start;
	}
	public void setSale_end(String sale_end) {
		this.sale_end = sale_end;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public void setSale_images(String sale_images) {
		this.sale_images = sale_images;
	}
	
	
}
