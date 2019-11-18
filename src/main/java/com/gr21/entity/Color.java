package com.gr21.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="color")
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int color_id;
	String color_name;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="color_id",referencedColumnName = "color_id")
	List<Product_detail> products_detail;
	

	public List<Product_detail> getProducts_detail() {
		return products_detail;
	}
	public void setProducts_detail(List<Product_detail> products_detail) {
		this.products_detail = products_detail;
	}
	public int getColor_id() {
		return color_id;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_id(int color_id) {
		this.color_id = color_id;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	
}
