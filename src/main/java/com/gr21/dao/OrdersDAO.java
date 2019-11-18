package com.gr21.dao;

import java.util.List;

import com.gr21.entity.Orders;
import com.gr21.entity.Orders_detail;

public interface OrdersDAO {

	public Orders getOrders(int order_id);
	public List<Orders> getListOrders();
	
	public String getOrdersName(int odrers_id);
	public List<String> getListOrdersName();
	public void create(Orders order);
	public void delete (int orders_id);
	public void update(Orders order);
	int addOrder(Orders ord);
	public List<Orders> getListOrders(int startPosition, int maxResult) ;
	public Long countOder();
	public List<Orders> getListOrdersByStatus();
	public List<Orders> getListOrdersByStatus1();
	public List<Orders> getListOrdersByStatus2();
	
	public List<Orders_detail> getOrders_detail(int orders_id);
	public boolean searchOrders(int order_id);
}
