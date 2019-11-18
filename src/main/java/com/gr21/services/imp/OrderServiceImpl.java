package com.gr21.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr21.dao.OrdersDAO;
import com.gr21.entity.Orders;
import com.gr21.entity.Orders_detail;
import com.gr21.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrdersDAO orderDao;
	public int addOrder(Orders ord) {
		// TODO Auto-generated method stub
		return orderDao.addOrder(ord);
	}
	public List<Orders> getListOrders() {
		// TODO Auto-generated method stub
		return orderDao.getListOrders();
	}
	public void delete(int orders_id) {
		// TODO Auto-generated method stub
		orderDao.delete(orders_id);
	}
	public void create(Orders orders_id) {
		// TODO Auto-generated method stub
		orderDao.create(orders_id);
	}
	public void update(Orders orders_id) {
		// TODO Auto-generated method stub
		orderDao.update(orders_id);
	}
	public int getLastest() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Orders getOrders(int order_id) {
		// TODO Auto-generated method stub
		return orderDao.getOrders(order_id);
	}
	public Long countOder() {
		// TODO Auto-generated method stub
		return orderDao.countOder();
	}
	public List<Orders> getListOrders(int startPosition, int maxResult) {
		// TODO Auto-generated method stub
		return orderDao.getListOrders(startPosition, maxResult);
	}
	public List<Orders> getListOrdersByStatus() {
		// TODO Auto-generated method stub
		return orderDao.getListOrdersByStatus();
	}
	public List<Orders> getListOrdersByStatus1() {
		// TODO Auto-generated method stub
		return orderDao.getListOrdersByStatus1();
	}
	public List<Orders> getListOrdersByStatus2() {
		// TODO Auto-generated method stub
		return orderDao.getListOrdersByStatus2();
	}
	
	public List<Orders_detail> getOrders_detail(int orders_id){
		return orderDao.getOrders_detail(orders_id);
	}
	public boolean searchOrders(int order_id) {
		// TODO Auto-generated method stub
		boolean search = orderDao.searchOrders(order_id);
		return search;
	}
}
