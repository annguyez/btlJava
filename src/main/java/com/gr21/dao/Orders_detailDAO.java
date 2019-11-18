package com.gr21.dao;

import java.util.List;

import com.gr21.entity.Orders_detail;
import com.gr21.entity.Product_detail;

public interface Orders_detailDAO {
	boolean AddOrderDetail(Orders_detail orders_detail);
	public int total(int order_id);
	public List<Orders_detail> getListOrders_detailbyId(String product_detail_id);
	public Orders_detail getOrders_detail(String product_detail_id);
	public void delete(String product_detail_id);
}
