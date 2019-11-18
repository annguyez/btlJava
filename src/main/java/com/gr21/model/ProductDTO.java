package com.gr21.model;

import java.util.List;
import java.util.Set;


public class ProductDTO {


	int product_id;
	int category_id;
	String product_name;
	String category_name;
	String price;
	String descriptions;
	String image;
	int discount;
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	List<Product_detailDTO> products_detail;
	int total;
	long total_money;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public List<Product_detailDTO> getProducts_detail() {
		return products_detail;
	}
	public void setProducts_detail(List<Product_detailDTO> products_detail) {
		this.products_detail = products_detail;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public long getTotal_money() {
		return total_money;
	}
	public void setTotal_money(long total_money) {
		this.total_money = total_money;
	}
	

	
}
