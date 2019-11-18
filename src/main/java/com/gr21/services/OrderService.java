package com.gr21.services;

import java.util.List;

import com.gr21.entity.Orders;
import com.gr21.entity.Orders_detail;
import com.gr21.entity.Orders;

public interface OrderService {
	int addOrder(Orders ord);
	public List<Orders> getListOrders();
	public void delete(int orders_id);
	public void create(Orders orders_id );
	public void update(Orders orders_id );
	public int getLastest();
	public Orders getOrders(int order_id);
	public Long countOder();
	public List<Orders> getListOrders(int startPosition, int maxResult) ;
	public List<Orders> getListOrdersByStatus();
	public List<Orders> getListOrdersByStatus1();
	public List<Orders> getListOrdersByStatus2();
	
	public List<Orders_detail> getOrders_detail(int orders_id);
	public boolean searchOrders(int order_id);
}
