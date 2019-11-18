package com.gr21.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;



public class Orders_detail_id implements Serializable{
	int orders_id;
	int product_detail_id;
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getProduct_detail_id() {
		return product_detail_id;
	}
	public void setProduct_detail_id(int product_detail_id) {
		this.product_detail_id = product_detail_id;
	}
	
}
