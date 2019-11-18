package com.gr21.model;

import java.util.List;
import java.util.Set;

public class SaleDTO {
	int sale_id;
	String sale_name;
	int  discount; 
	String sale_start;
	String sale_end;
	String descriptions;
	String sale_images;
	List<ProductDTO> products;
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public String getSale_name() {
		return sale_name;
	}
	public void setSale_name(String sale_name) {
		this.sale_name = sale_name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getSale_start() {
		return sale_start;
	}
	public void setSale_start(String sale_start) {
		this.sale_start = sale_start;
	}
	public String getSale_end() {
		return sale_end;
	}
	public void setSale_end(String sale_end) {
		this.sale_end = sale_end;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getSale_images() {
		return sale_images;
	}
	public void setSale_images(String sale_images) {
		this.sale_images = sale_images;
	}
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
	
}
