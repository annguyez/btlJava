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
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orders_id;
	String customer_name;
	String address;
	String phone;
	int orders_status;
	String orders_date;
	String note;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="orders_id",referencedColumnName = "orders_id")
	
	Set<Orders_detail> orders_detail;
	
	

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getOrders_id() {
		return orders_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public String getAddress() {
		return address;
	}
	
	public String getOrders_date() {
		return orders_date;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public int getOrders_status() {
		return orders_status;
	}
	public void setOrders_status(int orders_status) {
		this.orders_status = orders_status;
	}
	public void setOrders_date(String orders_date) {
		this.orders_date = orders_date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Set<Orders_detail> getOrders_detail() {
		return orders_detail;
	}
	public void setOrders_detail(Set<Orders_detail> orders_detail) {
		this.orders_detail = orders_detail;
	}
	


}
