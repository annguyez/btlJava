package com.gr21.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr21.dao.Orders_detailDAO;
import com.gr21.entity.Orders_detail;
import com.gr21.services.Orders_detailService;
@Service
public class Orders_detailServiceImpl implements Orders_detailService
{
	@Autowired
	Orders_detailDAO orders_detailDao;
	public boolean AddOrderDetail(Orders_detail orders_detail) {
		// TODO Auto-generated method stub
		
		return orders_detailDao.AddOrderDetail(orders_detail);
	}
	public int total(int order_id) {
		// TODO Auto-generated method stub
		return orders_detailDao.total(order_id);
	}
	public List<Orders_detail> getListOrders_detailbyId(String product_detail_id) {
		// TODO Auto-generated method stub
		return orders_detailDao.getListOrders_detailbyId(product_detail_id);
	}
	public Orders_detail getOrders_detail(String product_detail_id) {
		// TODO Auto-generated method stub
		return orders_detailDao.getOrders_detail(product_detail_id);
	}
	public void delete(String product_detail_id) {
		// TODO Auto-generated method stub
		orders_detailDao.delete(product_detail_id);
	}

}
