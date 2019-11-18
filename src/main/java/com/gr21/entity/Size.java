package com.gr21.entity;

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
@Table(name="size")
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int size_id;
	String size;
	
	//Lien ket vs bang collection_details
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="size_id",referencedColumnName = "size_id")
	Set<Product_detail> products_detail;
	
	
	public Set<Product_detail> getProducts_detail() {
		return products_detail;
	}
	public void setProducts_detail(Set<Product_detail> products_detail) {
		this.products_detail = products_detail;
	}
	public int getSize_id() {
		return size_id;
	}
	public String getSize() {
		return size;
	}
	public void setSize_id(int size_id) {
		this.size_id = size_id;
	}
	public void setSize(String size) {
		this.size = size;
	}
	

}
